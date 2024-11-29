package com.example.VisitCard

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.VisitCard.ui.theme.MyCityTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyCityTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
            }
        }
    }
}
//@Composable
//fun ElementPage(modifier : Modifier = Modifier)
//{
//    Text(
//        text = "Marrakech",
//        style = TextStyle(fontWeight = FontWeight.Bold),
//        fontSize = 70.sp,
//        textAlign = TextAlign.Center
//    )
//    Box(modifier = Modifier
//        .fillMaxWidth()
//        .padding(15.dp))
//    {
//        Image(
//            painter = painterResource(image),
//            contentDescription = null,
//            contentScale = ContentScale.Crop,
//            modifier = Modifier
//                .align(LineHeightStyle.Alignment.Center)
//                .aspectRatio(10 / 7f),
//        )
//    }
//    Text(
//        text = title,
//        style = TextStyle(fontWeight = FontWeight.Bold),
//        fontSize = 50.sp,
//        textAlign = TextAlign.Center
//    )
//    Text(
//        text = description,
//        style = TextStyle(fontWeight = FontWeight.Bold),
//        fontSize = 20.sp,
//        textAlign = TextAlign.Center,
//        modifier = Modifier.padding(top = 80.dp, start = 10.dp, end = 20.dp)
//    )
//    Spacer(modifier = Modifier.height(32.dp))
//}


@Composable
fun CarteDeVisite() {
    val context = LocalContext.current
    val callIntent = Intent(Intent.ACTION_DIAL).apply {
        var data = Uri.parse("tel:+33612345678")
    }
    val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
        data = Uri.parse("mailto:hi@cyyc.lol")
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Hamza Jarane",
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "Développeur Android",
            style = MaterialTheme.typography.headlineMedium,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(16.dp))

        ContactInfo(
            label = "Téléphone :",
            value = "+33 6 12 34 56 78",
            onClick = { context.startActivity(callIntent) }
        )
        ContactInfo(
            label = "Email :",
            value = "hi@cyyc.lol",
            onClick = { context.startActivity(emailIntent) }
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Bouton pour site web
        Button(onClick = { /* Ouvrir le site */ }) {
            Text("Visiter mon site")
        }
    }
}

@Composable
fun ContactInfo(label: String, value: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(vertical = 4.dp)
    ) {
        Text(text = "$label ", fontWeight = FontWeight.Bold)
        Text(text = value, color = Color.Blue)
    }
}

@Composable
fun VisitCard(modifier:Modifier = Modifier)
{
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Abdelouahab Tamraoui",
            style = MaterialTheme.typography.titleLarge,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "développeur mobile",
            style = MaterialTheme.typography.titleMedium,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(8.dp))
        ContactInformation("Téléphone","+21209902299")
        ContactInformation("Email","Abdel@gmail.com")
        ContactInformation("Adresse","SoliCode,Tanger")
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {}) {
            Text("Visit Site" , style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
            )
            )
        }
    }
}

@Composable
fun ContactInformation(label: String,value: String,modifier:Modifier = Modifier)
{
    Row {
        Text(text = label,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = Color.Black
            ))

        Text(text = ": $value",
                style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = Color.Blue
        ))

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyCityTheme {
        Surface {
            VisitCard()
        }

    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    MyCityTheme {
        Surface() {
            CarteDeVisite()
        }

    }
}