package com.example.grille

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.grille.data.DataSource
import com.example.grille.model.Topic
import com.example.grille.ui.theme.GrilleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GrilleTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .statusBarsPadding(),
                    color = MaterialTheme.colorScheme.background
                ){
                    GrillesApp(
                        modifier = Modifier
                    )
                }


            }
        }
    }
}

@Composable
fun GrillesApp(modifier:Modifier)
{
    Grille(
        DataSource.topics
    )
}

@Composable
fun Grille(topiclist:List<Topic>,modifier: Modifier = Modifier)
{
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    )
    {
        items(topiclist) { topic ->
            CardGrille(topic)
        }
    }
}

@Composable
fun CardGrille(topic: Topic,modifier: Modifier = Modifier) {

    Card {
        Row(modifier = Modifier
            .clip(shape = RoundedCornerShape(10.dp))

        ) {

            Image(
                contentDescription = "img",
                painter = painterResource(topic.img),
                modifier = Modifier.size(68.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = topic.nom),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.fillMaxWidth(),
                    maxLines = 1

                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically

                ){
                    Icon(
                        contentDescription = "icon",
                        painter = painterResource(R.drawable.ic_grain)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "321",
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
        }
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GrilleTheme {
        GrillesApp(modifier = Modifier)



    }
}