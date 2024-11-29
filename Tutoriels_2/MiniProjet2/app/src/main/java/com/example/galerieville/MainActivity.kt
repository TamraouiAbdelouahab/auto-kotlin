package com.example.galerieville

import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.galerieville.ui.theme.GalerieVilleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GalerieVilleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Pageinformation()
                }
            }
        }
    }
}
@Composable
fun ElementPage(title:String, description : String,image : Int)
{
    Text(
        text = "Marrakech",
        style = TextStyle(fontWeight = FontWeight.Bold),
        fontSize = 70.sp,
        textAlign = TextAlign.Center
    )
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(15.dp))
    {
        Image(
            painter = painterResource(image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .align(Alignment.Center)
                .aspectRatio(10 / 7f),
        )
    }
    Text(
        text = title,
        style = TextStyle(fontWeight = FontWeight.Bold),
        fontSize = 50.sp,
        textAlign = TextAlign.Center
    )
    Text(
        text = description,
        style = TextStyle(fontWeight = FontWeight.Bold),
        fontSize = 20.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(top = 80.dp, start = 10.dp, end = 20.dp)
    )
    Spacer(modifier = Modifier.height(32.dp))
}
@Composable
fun Pageinformation(modifier: Modifier = Modifier) {
    var id by remember { mutableIntStateOf(1) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .alpha(0.7f)
    ){
        Image(
            painter = painterResource(id = R.drawable.marrakech),
            contentDescription = "Marrakech Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        when(id){
            1->ElementPage(stringResource(R.string.potier),stringResource(R.string.potier_description),R.drawable.potier)
            2->ElementPage(stringResource(R.string.horizon),stringResource(R.string.horizon_description),R.drawable.horizone)
            3->ElementPage(stringResource(R.string.souk),stringResource(R.string.souk_description),R.drawable.souk)
        }

        Row(
            modifier = modifier
                .fillMaxWidth()
                .size(48.dp)
                .padding(start = 30.dp, end = 30.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = {if(id == 1) id = 3 else id -=1}) {
                Text(text = stringResource(R.string.precedent))
            }
            Button(onClick = {if(id == 3) id = 1 else id +=1}) {
                Text(text = stringResource(R.string.suivant))
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun Preview() {
    GalerieVilleTheme {
        Pageinformation()
    }
}