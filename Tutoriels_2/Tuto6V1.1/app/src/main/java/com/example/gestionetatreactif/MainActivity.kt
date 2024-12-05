package com.example.gestionetatreactif

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gestionetatreactif.ui.theme.GestionEtatReactifTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GestionEtatReactifTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp()
{
    Column(modifier = Modifier.padding(32.dp),
        verticalArrangement = Arrangement.Center
        ) {
        Divider(color = Color.Gray, thickness = 1.dp)
        Spacer(modifier = Modifier.padding(8.dp))
        Counter()
        Spacer(modifier = Modifier.padding(8.dp))
        Divider(color = Color.Gray, thickness = 1.dp)
        Spacer(modifier = Modifier.padding(8.dp))
        AsyncDataLoader()
        Spacer(modifier = Modifier.padding(8.dp))
        Divider(color = Color.Gray, thickness = 1.dp)
        Spacer(modifier = Modifier.padding(8.dp))
        DataStream()
        Spacer(modifier = Modifier.padding(8.dp))
        Divider(color = Color.Gray, thickness = 1.dp)

    }
}

@Composable
fun Counter() {
    var counter by remember { mutableStateOf(0) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "Counter: $counter", style = MaterialTheme.typography.titleLarge)
        Button(onClick = { counter++ }) {
            Text("Increment")
        }
    }
}

@Composable
fun AsyncDataLoader(modifier: Modifier = Modifier) {
    var data by remember { mutableStateOf("") }
    LaunchedEffect(Unit) {
        while(true)
        data = fetchData()
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()) {
        Text(text = data, style = MaterialTheme.typography.titleMedium)
    }

}

@Composable
fun DataStream() {
    val dataFlow = remember {
        flow {
            for (i in 1..1000) {
                emit("item $i")
                delay(1000)
            }
        }
    }

    val data by dataFlow.collectAsState(initial = "Starting...")

    Row (horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()){
        Text(text = data, style = MaterialTheme.typography.headlineSmall)
    }

}

@SuppressLint("NewApi")
suspend fun fetchData(): String {
    delay(1000)
    val currentTime = LocalTime.now()
    val formatter = DateTimeFormatter.ofPattern("HH:mm:ss")
    return "Date et heure actuelles : ${currentTime.format(formatter)}"
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GestionEtatReactifTheme {
        //AsyncDataLoader()
        //Counter()
        Surface{
            MyApp()
        }

    }
}