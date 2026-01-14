package es.gbr.aeris.view.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import es.gbr.aeris.R
import es.gbr.aeris.model.DatosCompartidos
import es.gbr.aeris.model.database.entities.CiudadEntidad
import es.gbr.aeris.model.database.entities.PrediccionDiariaEntidad
import es.gbr.aeris.model.database.entities.PrediccionHorasEntidad
import es.gbr.aeris.model.database.entities.TiempoActualEntidad
import es.gbr.aeris.ui.components.ElementoPrediccionDias
import es.gbr.aeris.ui.components.ElementoPrediccionHoras
import es.gbr.aeris.ui.components.TarjetaDetalleClima
import es.gbr.aeris.ui.theme.AerisTheme
import es.gbr.aeris.data.preferences.PreferenciasRepository
import es.gbr.aeris.viewmodel.MainViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import androidx.lifecycle.lifecycleScope

// Pantalla principal con datos meteorológicos, pronóstico horario y diario
class MainActivity : ComponentActivity() {

    private val modeloVista: MainViewModel by viewModels()
    private lateinit var preferenciasRepository: PreferenciasRepository

    private var usarFahrenheit: Boolean = false
    private var usarMph: Boolean = false
    private var temaOscuro: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MainActivity", "onCreate")
        
        preferenciasRepository = PreferenciasRepository(applicationContext)

        // Cargar preferencias de DataStore primero
        lifecycleScope.launch {
            val prefs = preferenciasRepository.preferenciasFlow.first()
            usarFahrenheit = prefs.usarFahrenheit
            usarMph = prefs.usarMph
            temaOscuro = prefs.temaOscuro
            
            // Los valores del intent tienen prioridad si existen
            intent.extras?.let {
                if (it.containsKey("usarFahrenheit")) usarFahrenheit = it.getBoolean("usarFahrenheit")
                if (it.containsKey("usarMph")) usarMph = it.getBoolean("usarMph")
                if (it.containsKey("temaOscuro")) temaOscuro = it.getBoolean("temaOscuro")
            }

            modeloVista.cambiarCiudadSeleccionada(DatosCompartidos.idCiudadSeleccionada)
            configurarUI()
        }
    }
    
    override fun onResume() {
        super.onResume()
        // Solo log, NO sincronizar automáticamente aquí
        // El usuario puede hacer pull-to-refresh si quiere actualizar
        Log.d("MainActivity", "onResume")
    }
    
    private fun configurarUI() {
        setContent {
            AerisTheme(darkTheme = temaOscuro) {
                PantallaPrincipal(
                    modeloVista = modeloVista,
                    usarFahrenheit = usarFahrenheit,
                    usarMph = usarMph,
                    alNavegarALocalizaciones = {
                        Log.d("MainActivity", "-> LocalizacionesActivity")
                        val intencion = Intent(this, LocalizacionesActivity::class.java)
                        val bundle = Bundle()
                        bundle.putBoolean("usarFahrenheit", usarFahrenheit)
                        bundle.putBoolean("usarMph", usarMph)
                        bundle.putBoolean("temaOscuro", temaOscuro)
                        intencion.putExtras(bundle)
                        startActivity(intencion)
                        finish()
                    },
                    alNavegarAAjustes = {
                        Log.d("MainActivity", "-> AjustesActivity")
                        val intencion = Intent(this, AjustesActivity::class.java)
                        val bundle = Bundle()
                        bundle.putBoolean("usarFahrenheit", usarFahrenheit)
                        bundle.putBoolean("usarMph", usarMph)
                        bundle.putBoolean("temaOscuro", temaOscuro)
                        intencion.putExtras(bundle)
                        startActivity(intencion)
                        finish()
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaPrincipal(
    modeloVista: MainViewModel,
    usarFahrenheit: Boolean,
    usarMph: Boolean,
    alNavegarALocalizaciones: () -> Unit,
    alNavegarAAjustes: () -> Unit
) {
    val tiempoActual by modeloVista.tiempoActual.observeAsState()
    val prediccionHoras by modeloVista.prediccionHoras.observeAsState(emptyList())
    val prediccionDiaria by modeloVista.prediccionDiaria.observeAsState(emptyList())
    val todasLasCiudades by modeloVista.todasLasCiudades.observeAsState(emptyList())
    val idCiudadSeleccionada by modeloVista.idCiudadSeleccionada.observeAsState(1)
    val refrescandoManual by modeloVista.refrescandoManual.observeAsState(false)
    
    var mostrarDialogoCiudad by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val ciudadActual = todasLasCiudades.find { it.idCiudad == idCiudadSeleccionada }

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = { Icon(painterResource(R.drawable.ic_home), contentDescription = null) },
                    label = { Text(stringResource(R.string.nav_inicio)) },
                    selected = true,
                    onClick = { }
                )
                NavigationBarItem(
                    icon = { Icon(painterResource(R.drawable.ic_localizacion), contentDescription = null) },
                    label = { Text(stringResource(R.string.nav_localizaciones)) },
                    selected = false,
                    onClick = alNavegarALocalizaciones
                )
                NavigationBarItem(
                    icon = { Icon(painterResource(R.drawable.ic_ajustes), contentDescription = null) },
                    label = { Text(stringResource(R.string.nav_ajustes)) },
                    selected = false,
                    onClick = alNavegarAAjustes
                )
            }
        }
    ) { paddingValues ->
        if (tiempoActual == null) {
            // Pantalla de carga mientras obtiene datos de AEMET
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(64.dp),
                        color = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    Text(
                        text = stringResource(R.string.cargando_datos),
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = ciudadActual?.nombre ?: stringResource(R.string.app_name),
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        } else {
            // Pull-to-refresh para recargar datos
            val contextoLocal = LocalContext.current
            PullToRefreshBox(
                isRefreshing = refrescandoManual,
                onRefresh = {
                    modeloVista.sincronizarCiudadActual { exito ->
                        val mensaje = if (exito) contextoLocal.getString(R.string.sincronizacion_exitosa)
                                      else contextoLocal.getString(R.string.sincronizacion_error)
                        Toast.makeText(contextoLocal, mensaje, Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ) {
                    tiempoActual?.let { tiempo ->
                        ContenidoClimaPrincipal(
                            tiempo = tiempo,
                            nombreCiudad = ciudadActual?.nombre ?: "",
                            prediccionHoras = prediccionHoras,
                            prediccionDiaria = prediccionDiaria,
                            usarFahrenheit = usarFahrenheit,
                            usarMph = usarMph,
                            alSeleccionarCiudad = { mostrarDialogoCiudad = true }
                        )
                    }
                }
            }
        }
    }
    
    // Mostrar todas las ciudades en el diálogo de Home
    if (mostrarDialogoCiudad && todasLasCiudades.isNotEmpty()) {
        DialogoSeleccionCiudad(
            ciudades = todasLasCiudades,
            idCiudadSeleccionada = idCiudadSeleccionada,
            alSeleccionarCiudad = { ciudad ->
                // Añadir a ciudades visibles si no está ya
                scope.launch {
                    if (!DatosCompartidos.esCiudadVisible(ciudad.idCiudad)) {
                        DatosCompartidos.mostrarCiudad(ciudad.idCiudad)
                    }
                }
                modeloVista.cambiarCiudadSeleccionada(ciudad.idCiudad)
                mostrarDialogoCiudad = false
            },
            alCerrar = { mostrarDialogoCiudad = false }
        )
    }
}

@Composable
fun ContenidoClimaPrincipal(
    tiempo: TiempoActualEntidad,
    nombreCiudad: String,
    prediccionHoras: List<PrediccionHorasEntidad>,
    prediccionDiaria: List<PrediccionDiariaEntidad>,
    usarFahrenheit: Boolean,
    usarMph: Boolean,
    alSeleccionarCiudad: () -> Unit
) {
    val contexto = LocalContext.current
    
    val temperatura = if (usarFahrenheit) celsiusAFahrenheit(tiempo.temperatura) else tiempo.temperatura
    val maxima = if (usarFahrenheit) celsiusAFahrenheit(tiempo.tempAlta) else tiempo.tempAlta
    val minima = if (usarFahrenheit) celsiusAFahrenheit(tiempo.tempBaja) else tiempo.tempBaja
    val viento = if (usarMph) kphAMph(tiempo.vientoVelocidad) else tiempo.vientoVelocidad
    val unidadViento = if (usarMph) "mph" else "km/h"
    
    val formateadorFecha = SimpleDateFormat("EEEE, dd MMM", Locale.getDefault())
    val fechaActual = formateadorFecha.format(Date()).replaceFirstChar { 
        if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() 
    }
    
    // Cabecera con ciudad y selector
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = nombreCiudad,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.weight(1f)
        )
        IconButton(onClick = alSeleccionarCiudad) {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = stringResource(R.string.main_seleccionar_ciudad),
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }
    
    Text(
        text = fechaActual,
        style = MaterialTheme.typography.bodySmall,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        modifier = Modifier.padding(start = 24.dp)
    )
    
    // Información principal del clima
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(obtenerIconoClima(tiempo.codigoIcono)),
            contentDescription = stringResource(R.string.desc_icono_clima),
            modifier = Modifier.size(160.dp),
            tint = MaterialTheme.colorScheme.onSurface
        )
        
        Text(
            text = "${temperatura.toInt()}°",
            fontSize = 96.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface
        )
        
        Text(
            text = DatosCompartidos.traducirDescripcion(contexto, tiempo.descripcion),
            style = MaterialTheme.typography.bodyLarge,
            fontSize = 18.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
    
    HorizontalDivider(
        modifier = Modifier.padding(horizontal = 24.dp, vertical = 24.dp),
        color = MaterialTheme.colorScheme.outlineVariant
    )
    
    // Temperaturas máxima y mínima
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "MIN: ${minima.toInt()}°",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            text = "MAX: ${maxima.toInt()}°",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
    
    // Detalles del clima
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TarjetaDetalleClima(
            iconoRes = R.drawable.ic_humedad,
            titulo = stringResource(R.string.main_humedad),
            valor = "${tiempo.humedad.toInt()}%",
            modificador = Modifier.weight(1f)
        )
        TarjetaDetalleClima(
            iconoRes = R.drawable.ic_viento_velocidad,
            titulo = stringResource(R.string.main_viento),
            valor = "${viento.toInt()} $unidadViento",
            modificador = Modifier.weight(1f)
        )
        TarjetaDetalleClima(
            iconoRes = R.drawable.ic_uv,
            titulo = stringResource(R.string.main_indice_uv),
            valor = "${tiempo.uvIndice.toInt()} (${obtenerNivelUV(contexto, tiempo.uvIndice.toInt())})",
            modificador = Modifier.weight(1f)
        )
        TarjetaDetalleClima(
            iconoRes = R.drawable.ic_lluvia,
            titulo = stringResource(R.string.main_precipitacion),
            valor = "${tiempo.precipitacion}%",
            modificador = Modifier.weight(1f)
        )
    }
    
    HorizontalDivider(
        modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp),
        color = MaterialTheme.colorScheme.outlineVariant
    )
    
    // Pronóstico por horas
    Text(
        text = stringResource(R.string.main_pronostico_horario),
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        modifier = Modifier.padding(start = 24.dp, top = 16.dp)
    )
    
    val horaActual = SimpleDateFormat("HH", Locale.getDefault()).format(Date())
    
    LazyRow(
        modifier = Modifier.padding(vertical = 8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(prediccionHoras) { prediccion ->
            val esHoraActual = prediccion.hora == horaActual || prediccion.hora == "${horaActual}:00"
            ElementoPrediccionHoras(
                prediccion = prediccion,
                usarFahrenheit = usarFahrenheit,
                esHoraActual = esHoraActual,
                iconoRes = obtenerIconoClima(prediccion.codigoIcono)
            )
        }
    }
    
    HorizontalDivider(
        modifier = Modifier.padding(horizontal = 24.dp, vertical = 24.dp),
        color = MaterialTheme.colorScheme.outlineVariant
    )
    
    // Pronóstico por días
    Text(
        text = stringResource(R.string.main_pronostico_diario),
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        modifier = Modifier.padding(start = 24.dp, top = 16.dp)
    )
    
    prediccionDiaria.forEachIndexed { indice, prediccion ->
        val calendario = Calendar.getInstance()
        calendario.add(Calendar.DAY_OF_YEAR, indice + 2)
        val formatoDia = SimpleDateFormat("EEEE", Locale.getDefault())
        val diaSiguiente = formatoDia.format(calendario.time).replaceFirstChar {
            if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
        }
        
        ElementoPrediccionDias(
            prediccion = prediccion,
            diaTraducido = DatosCompartidos.traducirDia(contexto, prediccion.nombreDia),
            diaSiguiente = diaSiguiente,
            usarFahrenheit = usarFahrenheit,
            iconoRes = obtenerIconoClima(prediccion.codigoIcono)
        )
    }
    
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun DialogoSeleccionCiudad(
    ciudades: List<CiudadEntidad>,
    idCiudadSeleccionada: Int,
    alSeleccionarCiudad: (CiudadEntidad) -> Unit,
    alCerrar: () -> Unit
) {
    AlertDialog(
        onDismissRequest = alCerrar,
        title = { Text(stringResource(R.string.main_seleccionar_ciudad_titulo)) },
        text = {
            // Usar LazyColumn para scroll cuando hay muchas ciudades
            LazyColumn(
                modifier = Modifier.heightIn(max = 400.dp)
            ) {
                items(ciudades) { ciudad ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { alSeleccionarCiudad(ciudad) }
                            .padding(vertical = 12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = ciudad.idCiudad == idCiudadSeleccionada,
                            onClick = { alSeleccionarCiudad(ciudad) }
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = ciudad.nombre)
                    }
                }
            }
        },
        confirmButton = {},
        dismissButton = {
            TextButton(onClick = alCerrar) {
                Text(stringResource(android.R.string.cancel))
            }
        }
    )
}

private fun obtenerIconoClima(codigoIcono: String): Int {
    return when(codigoIcono) {
        "ic_sol" -> R.drawable.ic_sol
        "ic_lluvia" -> R.drawable.ic_lluvia
        "ic_nieve" -> R.drawable.ic_nieve
        "ic_nublado" -> R.drawable.ic_nublado
        "ic_parcialmente_nublado" -> R.drawable.ic_parcialmente_nublado
        "ic_tormenta" -> R.drawable.ic_tormenta
        else -> R.drawable.ic_sol
    }
}

private fun obtenerNivelUV(contexto: android.content.Context, indice: Int): String {
    return when {
        indice <= 2 -> contexto.getString(R.string.main_bajo)
        indice <= 5 -> contexto.getString(R.string.main_medio)
        else -> contexto.getString(R.string.main_alto)
    }
}

private fun celsiusAFahrenheit(celsius: Double): Double = (celsius * 9/5) + 32

private fun kphAMph(kph: Double): Double = kph / 1.609
