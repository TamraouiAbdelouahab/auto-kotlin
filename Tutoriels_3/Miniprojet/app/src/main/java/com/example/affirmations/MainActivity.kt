package com.example.affirmations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.affirmations.ui.theme.AffirmationsTheme
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.toMutableStateList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AffirmationsTheme {
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
val affirmations = mutableListOf(
    "Crois en toi-même et en toutes tes capacités.",
    "Chaque jour est une nouvelle opportunité.",
    "Tu es plus fort que tu ne le penses.",
    "N'abandonne jamais, les miracles prennent du temps.",
    "Le succès commence par la volonté de l'atteindre.",
    "Tu es plus fort que tu ne le penses.",
    "N'abandonne jamais, les miracles prennent du temps.",
    "Le succès commence par la volonté de l'atteindre."
)
@Composable
fun AffirmationCard(affirmation: String,modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
    val color =
                if (expanded) MaterialTheme.colorScheme.surface
                else MaterialTheme.colorScheme.onPrimary

    Button(
        onClick = { expanded = !expanded },
        //modifier = Modifier.background(null)
        colors = ButtonDefaults.buttonColors(
        containerColor = Color.Transparent
        )
        ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            colors = CardDefaults.cardColors(containerColor = color,

            )
        ) {
            Text(text = affirmation,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(16.dp),
                color = MaterialTheme.colorScheme.onSurface
            )
        }
       }

}





@Composable
fun AffirmationList(affirmations: List<String>) {
    var affirmationtext by remember { mutableStateOf("") }
    val affirmationsState = remember {affirmations.toMutableStateList()}
    val affirmationsList  : List<String> = affirmationsState.toList()

    LazyColumn(
            modifier = Modifier.padding(16.dp)
        ) {
            item { AddAffirmationfield(affirmationtext,{affirmationtext = it})
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                    Button(
                        onClick = {
                            affirmationsState.add(affirmationtext)
                            affirmationtext = ""
                                  } ,
                    )
                    {
                        Text(text = "Ajouter")
                    }
                }
             }
            items(affirmationsList) { it ->
                AffirmationCard(it)
            }

        }


}

@Composable
fun AddAffirmationfield(affirmation: String,onValueChanged: (String) -> Unit,modifier: Modifier =Modifier)
{

    TextField(
        value = affirmation,
        onValueChange = onValueChanged,
        singleLine = true,
        placeholder = { Text("Ajouter une affirmation") },
        label = { Text("Affirmation") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    )
//    Button { affirmations.add("test") }


}




@Preview()
@Composable
fun PreviewLight() {
    AffirmationsTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ){
            AffirmationList(affirmations)

        }

    }
}
@Preview()
@Composable
fun PreviewDark() {
    AffirmationsTheme(darkTheme = true){
        AffirmationList(affirmations)
    }
}