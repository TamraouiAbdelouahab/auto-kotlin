package com.example.listeaffirmations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.listeaffirmations.ui.theme.ListeAffirmationsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListeAffirmationsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AffirmationList(affirmations)
                }
            }
        }
    }
}
val affirmations = listOf(
    "Crois en toi-même et en toutes tes capacités.",
    "Chaque jour est une nouvelle opportunité.",
    "Tu es plus fort que tu ne le penses.",
    "N'abandonne jamais, les miracles prennent du temps.",
    "Le succès commence par la volonté de l'atteindre."
)
@Composable
fun AffirmationList(Affirmationlist : List<String>,modifier:Modifier = Modifier)
{
    var textinput by remember { mutableStateOf("") }
    var ListAff  = remember { Affirmationlist.toMutableStateList()}
    var Listaffdisplay = ListAff.toList()
    LazyColumn(
        modifier = Modifier.padding(8.dp)
    ) {
        item {
            Row {
                TextField(value = textinput, onValueChange = {it ->
                    textinput = it
                })
                Button(onClick = {
                    ListAff.add(0,textinput)
                    textinput = ""
                }) {
                    Text(text = "+")
                }
            }

        }
        items(Listaffdisplay){affirmation ->
            AffirmationCard(affirmation)
        }
    }

}

@Composable
fun AffirmationCard(affirmation:String,modifier:Modifier = Modifier)
{
    var elementcolor by remember { mutableStateOf(false) }
    //var color = if(elementcolor) Color.Red else Color.Blue

    Card(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            if(elementcolor) MaterialTheme.colorScheme.tertiaryContainer
            else MaterialTheme.colorScheme.primary))
        {
            Box(modifier = Modifier.padding(10.dp)) {
            Button(onClick = { elementcolor = !elementcolor } ,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ))
            {
                Text(text = affirmation)
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ListeAffirmationsTheme {
        AffirmationList(affirmations)
    }
}
