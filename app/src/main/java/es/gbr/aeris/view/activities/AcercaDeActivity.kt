package es.gbr.aeris.view.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import es.gbr.aeris.R
import es.gbr.aeris.ui.theme.AerisTheme

// Información del desarrollador y características de la app
class AcercaDeActivity : ComponentActivity() {

    private var temaOscuro: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("AcercaDeActivity", "onCreate")

        intent.extras?.let { bundle ->
            temaOscuro = bundle.getBoolean("temaOscuro", false)
        }

        setContent {
            AerisTheme(darkTheme = temaOscuro) {
                PantallaAcercaDe(
                    alVolver = { finish() }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaAcercaDe(
    alVolver: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.acerca_de_titulo),
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = alVolver) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = stringResource(R.string.acerca_volver)
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(24.dp))
            
            // Logo de la aplicación
            Image(
                painter = painterResource(R.drawable.ic_nube_inicio),
                contentDescription = stringResource(R.string.app_name),
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Nombre de la app
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            
            // Versión
            Text(
                text = stringResource(R.string.acerca_version),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Tarjeta de información
            OutlinedCard(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(
                            text = stringResource(R.string.acerca_informacion),
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    
                    Spacer(modifier = Modifier.height(12.dp))
                    
                    Text(
                        text = stringResource(R.string.acerca_info_texto),
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Justify
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Tarjeta de tecnologías
            OutlinedCard(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Code,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(
                            text = stringResource(R.string.acerca_tecnologias),
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    
                    Spacer(modifier = Modifier.height(12.dp))
                    
                    TecnologiaItem(stringResource(R.string.acerca_tech_kotlin), stringResource(R.string.acerca_tech_kotlin_desc))
                    TecnologiaItem(stringResource(R.string.acerca_tech_compose), stringResource(R.string.acerca_tech_compose_desc))
                    TecnologiaItem(stringResource(R.string.acerca_tech_material), stringResource(R.string.acerca_tech_material_desc))
                    TecnologiaItem(stringResource(R.string.acerca_tech_ktor), stringResource(R.string.acerca_tech_ktor_desc))
                    TecnologiaItem(stringResource(R.string.acerca_tech_room), stringResource(R.string.acerca_tech_room_desc))
                    TecnologiaItem(stringResource(R.string.acerca_tech_datastore), stringResource(R.string.acerca_tech_datastore_desc))
                    TecnologiaItem(stringResource(R.string.acerca_tech_mvvm), stringResource(R.string.acerca_tech_mvvm_desc))
                }
            }
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // Desarrollador
            Text(
                text = stringResource(R.string.acerca_desarrollado_por),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                text = stringResource(R.string.acerca_desarrollador),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Copyright
            Text(
                text = stringResource(R.string.acerca_copyright),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontSize = 12.sp
            )
            
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
private fun TecnologiaItem(nombre: String, descripcion: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "• $nombre",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Medium
        )
        Text(
            text = descripcion,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}
