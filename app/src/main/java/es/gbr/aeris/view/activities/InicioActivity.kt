package es.gbr.aeris.view.activities

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import es.gbr.aeris.R
import es.gbr.aeris.data.preferences.PreferenciasRepository
import es.gbr.aeris.ui.theme.AerisTheme
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

// Pantalla de bienvenida inicial al abrir la aplicación
class InicioActivity : ComponentActivity() {

    private lateinit var preferenciasRepository: PreferenciasRepository
    
    private var usarFahrenheit = false
    private var usarMph = false
    private var temaOscuro = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("InicioActivity", "onCreate")
        
        preferenciasRepository = PreferenciasRepository(applicationContext)

        // Cargar preferencias guardadas
        lifecycleScope.launch {
            val prefs = preferenciasRepository.preferenciasFlow.first()
            usarFahrenheit = prefs.usarFahrenheit
            usarMph = prefs.usarMph
            temaOscuro = prefs.temaOscuro
            
            // Si no hay tema guardado, usar el del sistema
            if (!temaOscuro) {
                val esTemaOscuroSistema = (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES
                temaOscuro = esTemaOscuroSistema
            }
            
            configurarUI()
        }
    }
    
    private fun configurarUI() {
        setContent {
            AerisTheme(darkTheme = temaOscuro) {
                PantallaInicio(
                    alPulsarEntrar = {
                        Log.d("InicioActivity", "-> MainActivity")
                        val intent = Intent(this, MainActivity::class.java)
                        val bundle = Bundle()
                        bundle.putBoolean("usarFahrenheit", usarFahrenheit)
                        bundle.putBoolean("usarMph", usarMph)
                        bundle.putBoolean("temaOscuro", temaOscuro)
                        intent.putExtras(bundle)
                        startActivity(intent)
                        finish()
                    }
                )
            }
        }
    }
}

@Composable
fun PantallaInicio(
    alPulsarEntrar: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.weight(0.25f))
                
                Image(
                    painter = painterResource(R.drawable.ic_nube_inicio),
                    contentDescription = stringResource(R.string.app_name),
                    modifier = Modifier.size(width = 346.dp, height = 241.dp)
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                Text(
                    text = stringResource(R.string.app_name),
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
                
                Spacer(modifier = Modifier.height(24.dp))
                
                Text(
                    text = stringResource(R.string.inicio_titulo),
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    color = MaterialTheme.colorScheme.primary
                )
                
                Spacer(modifier = Modifier.weight(0.5f))
                
                Button(
                    onClick = alPulsarEntrar,
                    modifier = Modifier
                        .width(301.dp)
                        .height(45.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    )
                ) {
                    Text(
                        text = stringResource(R.string.inicio_entrar),
                        fontWeight = FontWeight.Bold
                    )
                }
                
                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}
