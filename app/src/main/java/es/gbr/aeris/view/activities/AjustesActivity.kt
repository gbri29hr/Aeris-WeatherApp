package es.gbr.aeris.view.activities

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
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
import es.gbr.aeris.ui.theme.AerisTheme
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

// Configuración de unidades de medida y tema de la interfaz
class AjustesActivity : ComponentActivity() {

    private lateinit var preferenciasRepository: PreferenciasRepository
    
    private var usarFahrenheit: Boolean = false
    private var usarMph: Boolean = false
    private var temaOscuro: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("AjustesActivity", "onCreate")
        
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

            if (!intent.hasExtra("temaOscuro") && !prefs.temaOscuro) {
                val esTemaOscuroSistema = (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES
                temaOscuro = esTemaOscuroSistema
            }
            
            configurarUI()
        }
    }
    
    private fun configurarUI() {
        setContent {
            var fahrenheit by remember { mutableStateOf(usarFahrenheit) }
            var mph by remember { mutableStateOf(usarMph) }
            var oscuro by remember { mutableStateOf(temaOscuro) }
            val contexto = LocalContext.current

            AerisTheme(darkTheme = oscuro) {
                PantallaAjustes(
                    usarFahrenheit = fahrenheit,
                    usarMph = mph,
                    temaOscuro = oscuro,
                    alCambiarFahrenheit = { nuevoValor ->
                        fahrenheit = nuevoValor
                        usarFahrenheit = nuevoValor
                        lifecycleScope.launch {
                            preferenciasRepository.guardarUsarFahrenheit(nuevoValor)
                        }
                    },
                    alCambiarMph = { nuevoValor ->
                        mph = nuevoValor
                        usarMph = nuevoValor
                        lifecycleScope.launch {
                            preferenciasRepository.guardarUsarMph(nuevoValor)
                        }
                    },
                    alCambiarTema = { nuevoValor ->
                        oscuro = nuevoValor
                        temaOscuro = nuevoValor
                        lifecycleScope.launch {
                            preferenciasRepository.guardarTemaOscuro(nuevoValor)
                        }
                    },
                    alNavegarAInicio = {
                        val intencion = Intent(this, MainActivity::class.java)
                        val bundle = Bundle()
                        bundle.putBoolean("usarFahrenheit", fahrenheit)
                        bundle.putBoolean("usarMph", mph)
                        bundle.putBoolean("temaOscuro", oscuro)
                        intencion.putExtras(bundle)
                        startActivity(intencion)
                        finish()
                    },
                    alNavegarALocalizaciones = {
                        val intencion = Intent(this, LocalizacionesActivity::class.java)
                        val bundle = Bundle()
                        bundle.putBoolean("usarFahrenheit", fahrenheit)
                        bundle.putBoolean("usarMph", mph)
                        bundle.putBoolean("temaOscuro", oscuro)
                        intencion.putExtras(bundle)
                        startActivity(intencion)
                        finish()
                    },
                    alNavegarAAcercaDe = {
                        val intencion = Intent(this, AcercaDeActivity::class.java)
                        val bundle = Bundle()
                        bundle.putBoolean("temaOscuro", oscuro)
                        intencion.putExtras(bundle)
                        startActivity(intencion)
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaAjustes(
    usarFahrenheit: Boolean,
    usarMph: Boolean,
    temaOscuro: Boolean,
    alCambiarFahrenheit: (Boolean) -> Unit,
    alCambiarMph: (Boolean) -> Unit,
    alCambiarTema: (Boolean) -> Unit,
    alNavegarAInicio: () -> Unit,
    alNavegarALocalizaciones: () -> Unit,
    alNavegarAAcercaDe: () -> Unit = {}
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.ajustes_titulo),
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
                    selected = false,
                    onClick = alNavegarALocalizaciones
                )
                NavigationBarItem(
                    icon = { Icon(painterResource(R.drawable.ic_ajustes), contentDescription = null) },
                    label = { Text(stringResource(R.string.nav_ajustes)) },
                    selected = true,
                    onClick = { }
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            
            Text(
                text = stringResource(R.string.ajustes_unidades),
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(start = 8.dp)
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            // Card Temperatura
            TarjetaAjuste(
                titulo = stringResource(R.string.ajustes_temperatura),
                subtitulo = stringResource(R.string.ajustes_escoge_opcion),
                etiquetaIzquierda = "°C",
                etiquetaDerecha = "°F",
                activado = usarFahrenheit,
                alCambiar = alCambiarFahrenheit
            )
            
            Spacer(modifier = Modifier.height(12.dp))
            
            // Card Velocidad viento
            TarjetaAjuste(
                titulo = stringResource(R.string.ajustes_velocidad_viento),
                subtitulo = stringResource(R.string.ajustes_escoge_opcion),
                etiquetaIzquierda = "km/h",
                etiquetaDerecha = "mph",
                activado = usarMph,
                alCambiar = alCambiarMph
            )
            
            Spacer(modifier = Modifier.height(24.dp))
            
            Text(
                text = stringResource(R.string.ajustes_tema_app),
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(start = 8.dp)
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            // Card Tema
            TarjetaAjuste(
                titulo = stringResource(R.string.ajustes_tema_titulo),
                subtitulo = stringResource(R.string.ajustes_escoge_opcion),
                etiquetaIzquierda = stringResource(R.string.ajustes_claro),
                etiquetaDerecha = stringResource(R.string.ajustes_oscuro),
                activado = temaOscuro,
                alCambiar = alCambiarTema
            )
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Botón Acerca de
            OutlinedCard(
                modifier = Modifier.fillMaxWidth(),
                onClick = alNavegarAAcercaDe
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = stringResource(R.string.acerca_de_titulo),
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = "Versión 2.0",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    Icon(
                        painter = painterResource(R.drawable.ic_flecha_abajo),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun TarjetaAjuste(
    titulo: String,
    subtitulo: String,
    etiquetaIzquierda: String,
    etiquetaDerecha: String,
    activado: Boolean,
    alCambiar: (Boolean) -> Unit
) {
    OutlinedCard(
        modifier = Modifier.fillMaxWidth(),
        border = CardDefaults.outlinedCardBorder().copy(
            brush = androidx.compose.ui.graphics.SolidColor(MaterialTheme.colorScheme.primary)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = titulo,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = subtitulo,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = etiquetaIzquierda,
                    style = MaterialTheme.typography.labelLarge,
                    color = if (!activado) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.width(8.dp))
                Switch(
                    checked = activado,
                    onCheckedChange = alCambiar
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = etiquetaDerecha,
                    style = MaterialTheme.typography.labelLarge,
                    color = if (activado) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}
