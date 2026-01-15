package es.gbr.aeris.view.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.lifecycle.lifecycleScope
import es.gbr.aeris.R
import es.gbr.aeris.data.preferences.PreferenciasRepository
import es.gbr.aeris.model.DatosCompartidos
import es.gbr.aeris.model.database.entities.CiudadEntidad
import es.gbr.aeris.model.database.relations.CiudadConTiempoActual
import es.gbr.aeris.ui.theme.AerisTheme
import es.gbr.aeris.viewmodel.LocalizacionesViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

// Activity para gestionar las ciudades - añadir, ocultar, ver detalle
class LocalizacionesActivity : ComponentActivity() {

    private val modeloVista: LocalizacionesViewModel by viewModels()
    private lateinit var preferenciasRepository: PreferenciasRepository

    private var usarFahrenheit: Boolean = false
    private var usarMph: Boolean = false
    private var temaOscuro: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("LocalizacionesActivity", "onCreate")
        
        preferenciasRepository = PreferenciasRepository(applicationContext)

        // Cargo preferencias
        lifecycleScope.launch {
            val prefs = preferenciasRepository.preferenciasFlow.first()
            usarFahrenheit = prefs.usarFahrenheit
            usarMph = prefs.usarMph
            temaOscuro = prefs.temaOscuro
            
            // Los valores del intent tienen prioridad
            intent.extras?.let {
                if (it.containsKey("usarFahrenheit")) usarFahrenheit = it.getBoolean("usarFahrenheit")
                if (it.containsKey("usarMph")) usarMph = it.getBoolean("usarMph")
                if (it.containsKey("temaOscuro")) temaOscuro = it.getBoolean("temaOscuro")
            }

            // Cargo las ciudades que quiere ver el usuario
            val ciudadesVisibles = DatosCompartidos.obtenerCiudadesVisibles()
            modeloVista.actualizarCiudadesVisibles(ciudadesVisibles)
            
            configurarUI()
        }
    }
    
    private fun configurarUI() {
        setContent {
            AerisTheme(darkTheme = temaOscuro) {
                PantallaLocalizaciones(
                    modeloVista = modeloVista,
                    usarFahrenheit = usarFahrenheit,
                    alNavegarAInicio = {
                        Log.d("LocalizacionesActivity", "-> MainActivity")
                        val intencion = Intent(this, MainActivity::class.java)
                        val bundle = Bundle()
                        bundle.putBoolean("usarFahrenheit", usarFahrenheit)
                        bundle.putBoolean("usarMph", usarMph)
                        bundle.putBoolean("temaOscuro", temaOscuro)
                        intencion.putExtras(bundle)
                        startActivity(intencion)
                        finish()
                    },
                    alNavegarAAjustes = {
                        Log.d("LocalizacionesActivity", "-> AjustesActivity")
                        val intencion = Intent(this, AjustesActivity::class.java)
                        val bundle = Bundle()
                        bundle.putBoolean("usarFahrenheit", usarFahrenheit)
                        bundle.putBoolean("usarMph", usarMph)
                        bundle.putBoolean("temaOscuro", temaOscuro)
                        intencion.putExtras(bundle)
                        startActivity(intencion)
                        finish()
                    },
                    alSeleccionarCiudad = { ciudad ->
                        // Cambiar ciudad seleccionada y volver a MainActivity para ver detalle
                        DatosCompartidos.idCiudadSeleccionada = ciudad.idCiudad
                        Log.d("LocalizacionesActivity", "-> MainActivity con ciudad: ${ciudad.nombre}")
                        val intencion = Intent(this, MainActivity::class.java)
                        val bundle = Bundle()
                        bundle.putBoolean("usarFahrenheit", usarFahrenheit)
                        bundle.putBoolean("usarMph", usarMph)
                        bundle.putBoolean("temaOscuro", temaOscuro)
                        intencion.putExtras(bundle)
                        startActivity(intencion)
                        finish()
                    },
                    alOcultarCiudad = { idCiudad ->
                        lifecycleScope.launch {
                            DatosCompartidos.ocultarCiudad(idCiudad)
                            modeloVista.actualizarCiudadesVisibles(DatosCompartidos.obtenerCiudadesVisibles())
                            modeloVista.refrescarCiudades()
                        }
                    },
                    alMostrarCiudad = { idCiudad ->
                        lifecycleScope.launch {
                            DatosCompartidos.mostrarCiudad(idCiudad)
                            modeloVista.actualizarCiudadesVisibles(DatosCompartidos.obtenerCiudadesVisibles())
                            modeloVista.refrescarCiudades()
                        }
                    },
                    alMostrarMensaje = { mensaje ->
                        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaLocalizaciones(
    modeloVista: LocalizacionesViewModel,
    usarFahrenheit: Boolean,
    alNavegarAInicio: () -> Unit,
    alNavegarAAjustes: () -> Unit,
    alSeleccionarCiudad: (CiudadEntidad) -> Unit,
    alOcultarCiudad: (Int) -> Unit,
    alMostrarCiudad: (Int) -> Unit,
    alMostrarMensaje: (String) -> Unit
) {
    val todasLasCiudadesDB by modeloVista.todasLasCiudadesDB.observeAsState(emptyList())
    val ciudadesFiltradas by modeloVista.ciudadesFiltradas.observeAsState(emptyList())
    
    var textoBusqueda by remember { mutableStateOf("") }
    var mostrarDialogoAnadir by remember { mutableStateOf(false) }
    var mostrarDialogoEliminar by remember { mutableStateOf(false) }
    var ciudadAEliminar by remember { mutableStateOf<CiudadEntidad?>(null) }
    var mostrarDialogoConfirmarAnadir by remember { mutableStateOf(false) }
    var ciudadAAnadir by remember { mutableStateOf<CiudadEntidad?>(null) }
    var refrescando by remember { mutableStateOf(false) }
    
    val scope = rememberCoroutineScope()
    val contextoLocal = LocalContext.current
    
    // Ciudad principal reactiva - observa el StateFlow de DatosCompartidos
    val idCiudadPrincipal by DatosCompartidos.idCiudadSeleccionadaFlow.collectAsState()
    var ciudadesVisibles by remember { mutableStateOf(setOf<Int>()) }
    
    // Cargar ciudades visibles al iniciar
    LaunchedEffect(Unit) {
        ciudadesVisibles = DatosCompartidos.obtenerCiudadesVisibles()
    }

    LaunchedEffect(todasLasCiudadesDB) {
        modeloVista.actualizarListaFiltrada(todasLasCiudadesDB)
    }

    LaunchedEffect(textoBusqueda) {
        modeloVista.buscarCiudad(textoBusqueda)
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.ubicaciones_titulo),
                        fontWeight = FontWeight.Bold
                    )
                }
            )
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = { Icon(painterResource(R.drawable.ic_home), contentDescription = null) },
                    label = { Text(stringResource(R.string.nav_inicio)) },
                    selected = false,
                    onClick = alNavegarAInicio
                )
                NavigationBarItem(
                    icon = { Icon(painterResource(R.drawable.ic_localizacion), contentDescription = null) },
                    label = { Text(stringResource(R.string.nav_localizaciones)) },
                    selected = true,
                    onClick = { }
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
        ) {
            // Barra de búsqueda y botones
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = textoBusqueda,
                    onValueChange = { textoBusqueda = it },
                    modifier = Modifier.weight(1f),
                    placeholder = { Text(stringResource(R.string.ubicaciones_buscar_ciudad)) },
                    leadingIcon = {
                        Icon(painterResource(R.drawable.ic_buscar), contentDescription = null)
                    },
                    singleLine = true
                )
                
                IconButton(onClick = { mostrarDialogoAnadir = true }) {
                    Icon(
                        painterResource(R.drawable.ic_anadir),
                        contentDescription = stringResource(R.string.ubicaciones_anadir),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Text(
                text = stringResource(R.string.ubicaciones_gestionar),
                style = MaterialTheme.typography.titleLarge
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            // Pull-to-refresh para actualizar todas las ciudades
            PullToRefreshBox(
                isRefreshing = refrescando,
                onRefresh = {
                    scope.launch {
                        refrescando = true
                        Log.d("LocalizacionesActivity", "Pull-to-refresh iniciado")
                        Toast.makeText(contextoLocal, "Actualizando...", Toast.LENGTH_SHORT).show()
                        modeloVista.sincronizarTodasLasCiudades { exito ->
                            refrescando = false
                            if (exito) {
                                Toast.makeText(contextoLocal, "Actualizado", Toast.LENGTH_SHORT).show()
                            } else {
                                Toast.makeText(contextoLocal, "Error", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                },
                modifier = Modifier.weight(1f)
            ) {
                // Lista de ciudades
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                items(ciudadesFiltradas) { ciudadConTiempo ->
                    ElementoLocalizacion(
                        ciudadConTiempo = ciudadConTiempo,
                        esCiudadPrincipal = ciudadConTiempo.ciudad.idCiudad == idCiudadPrincipal,
                        usarFahrenheit = usarFahrenheit,
                        alPulsar = { alSeleccionarCiudad(ciudadConTiempo.ciudad) },
                        alPulsacionProlongada = {
                            // No permitir eliminar la ciudad principal
                            if (ciudadConTiempo.ciudad.idCiudad != idCiudadPrincipal) {
                                ciudadAEliminar = ciudadConTiempo.ciudad
                                mostrarDialogoEliminar = true
                            } else {
                                alMostrarMensaje("No puedes eliminar tu ciudad principal")
                            }
                        }
                    )
                }
            }
            } // Cierre PullToRefreshBox
        }
    }
    
    // Diálogo añadir ciudad
    if (mostrarDialogoAnadir) {
        AlertDialog(
            onDismissRequest = { mostrarDialogoAnadir = false },
            title = { Text(stringResource(R.string.ubicaciones_seleccionar_titulo)) },
            text = {
                LazyColumn {
                    items(todasLasCiudadesDB) { ciudadConTiempo ->
                        // Ahora mostramos las ciudades que NO están visibles (para poder añadirlas)
                        val estaVisible = ciudadesVisibles.contains(ciudadConTiempo.ciudad.idCiudad)
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    if (!estaVisible) {
                                        // Solo se puede añadir si no está visible
                                        ciudadAAnadir = ciudadConTiempo.ciudad
                                        mostrarDialogoConfirmarAnadir = true
                                        mostrarDialogoAnadir = false
                                    }
                                }
                                .padding(vertical = 8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(ciudadConTiempo.ciudad.nombre)
                            if (estaVisible) {
                                // Marca de que ya está visible
                                Text("✓", color = MaterialTheme.colorScheme.primary)
                            }
                        }
                    }
                }
            },
            confirmButton = {},
            dismissButton = {
                TextButton(onClick = { mostrarDialogoAnadir = false }) {
                    Text(stringResource(R.string.btn_cancelar))
                }
            }
        )
    }
    
    // Diálogo confirmar añadir
    if (mostrarDialogoConfirmarAnadir && ciudadAAnadir != null) {
        AlertDialog(
            onDismissRequest = { mostrarDialogoConfirmarAnadir = false },
            title = { Text(stringResource(R.string.ubicaciones_anadir_titulo)) },
            text = { Text(stringResource(R.string.ubicaciones_anadir_mensaje, ciudadAAnadir!!.nombre)) },
            confirmButton = {
                TextButton(onClick = {
                    alMostrarCiudad(ciudadAAnadir!!.idCiudad)
                    mostrarDialogoConfirmarAnadir = false
                }) {
                    Text(stringResource(R.string.ubicaciones_anadir_btn))
                }
            },
            dismissButton = {
                TextButton(onClick = { mostrarDialogoConfirmarAnadir = false }) {
                    Text(stringResource(R.string.btn_cancelar))
                }
            }
        )
    }
    
    // Diálogo eliminar
    if (mostrarDialogoEliminar && ciudadAEliminar != null) {
        AlertDialog(
            onDismissRequest = { 
                mostrarDialogoEliminar = false
                ciudadAEliminar = null
            },
            title = { Text(stringResource(R.string.ubicaciones_dialogo_eliminar_titulo)) },
            text = {
                Text("${stringResource(R.string.ubicaciones_dialogo_eliminar_mensaje)} ${ciudadAEliminar?.nombre}?")
            },
            confirmButton = {
                TextButton(onClick = {
                    ciudadAEliminar?.let { ciudad ->
                        alOcultarCiudad(ciudad.idCiudad)
                    }
                    mostrarDialogoEliminar = false
                    ciudadAEliminar = null
                }) {
                    Text(stringResource(R.string.ubicaciones_eliminar))
                }
            },
            dismissButton = {
                TextButton(onClick = { 
                    mostrarDialogoEliminar = false
                    ciudadAEliminar = null
                }) {
                    Text(stringResource(android.R.string.cancel))
                }
            }
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ElementoLocalizacion(
    ciudadConTiempo: CiudadConTiempoActual,
    esCiudadPrincipal: Boolean,
    usarFahrenheit: Boolean,
    alPulsar: () -> Unit,
    alPulsacionProlongada: () -> Unit
) {
    val ciudad = ciudadConTiempo.ciudad
    val tiempo = ciudadConTiempo.tiempoActual
    val contexto = LocalContext.current
    
    val formatoDia = SimpleDateFormat("EEEE", Locale.getDefault())
    val diaSemana = formatoDia.format(Date()).replaceFirstChar {
        if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .combinedClickable(
                onClick = { alPulsar() },
                onLongClick = { alPulsacionProlongada() }
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = ciudad.nombre,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = diaSemana,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                tiempo?.let {
                    // Mostrar descripción del clima para TODAS las ciudades
                    Text(
                        text = DatosCompartidos.traducirDescripcion(contexto, it.descripcion),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    // Mostrar min/max para TODAS las ciudades
                    val tempMin = if (usarFahrenheit) (it.tempBaja * 9/5) + 32 else it.tempBaja
                    val tempMax = if (usarFahrenheit) (it.tempAlta * 9/5) + 32 else it.tempAlta
                    Text(
                        text = "MIN: ${tempMin.toInt()}° / MAX: ${tempMax.toInt()}°",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
            
            tiempo?.let {
                val temp = if (usarFahrenheit) (it.temperatura * 9/5) + 32 else it.temperatura
                Text(
                    text = "${temp.toInt()}°",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )
            }
            
            Spacer(modifier = Modifier.width(8.dp))
            
            if (esCiudadPrincipal) {
                Icon(
                    painterResource(R.drawable.ic_home),
                    contentDescription = null,
                    modifier = Modifier.size(32.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.width(4.dp))
            }
            
            // Mostrar icono del clima siempre (incluso para ciudad principal)
            tiempo?.let {
                val iconoRes = when(it.codigoIcono) {
                    "ic_sol" -> R.drawable.ic_sol
                    "ic_lluvia" -> R.drawable.ic_lluvia
                    "ic_nieve" -> R.drawable.ic_nieve
                    "ic_nublado" -> R.drawable.ic_nublado
                    "ic_parcialmente_nublado" -> R.drawable.ic_parcialmente_nublado
                    "ic_tormenta" -> R.drawable.ic_tormenta
                    else -> R.drawable.ic_sol
                }
                Icon(
                    painterResource(iconoRes),
                    contentDescription = null,
                    modifier = Modifier.size(32.dp),
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}
