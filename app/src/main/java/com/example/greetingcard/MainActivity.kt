package com.example.greetingcard

import android.accounts.AuthenticatorDescription
import android.os.Bundle
import android.provider.Settings
import android.provider.Settings.Global.getString
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.greetingcard.ui.theme.GreetingCardTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreetingCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //GreetingImage()
                    // ComposeArticle()
                    // TaskManager()
                    //QuadrantView()
                    AllCompose()

                }
            }
        }
    }
}
// All Compose
@Composable
fun AllCompose() {
    var currentLayout by remember { mutableStateOf(0) }

    Box(Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()

        ) {
            when (currentLayout) {
                0 -> QuadrantView()
                1 -> GreetingImage()
                2 -> TaskManager()
                3 -> ComposeArticle()
                // Add more cases for additional layouts
                else -> QuadrantView()
            }
        }

        Button(
            onClick = {
                // Switch to the next layout
                currentLayout = (currentLayout + 1) % 4
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
        ) {
            Text("Change Layout")
        }
    }
}



// Compose Quadrant
@Composable
fun QuadrantView(modifier: Modifier = Modifier) {
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
            InfoCard(
                title = stringResource(R.string.QuadrantTitle1),
                description = stringResource(R.string.QuadrantDes1),
                backgroundColor = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f)
            )
            InfoCard(
                title = stringResource(R.string.QuadrantTitle2),
                description = stringResource(R.string.QuadrantDes2),
                backgroundColor = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            InfoCard(
                title = stringResource(R.string.QuadrantTitle3),
                description = stringResource(R.string.QuadrantDes3),
                backgroundColor = Color(0xFFB69DF8),
                modifier = Modifier.weight(1f)
            )
            InfoCard(
                title = stringResource(R.string.QuadrantTitle4),
                description = stringResource(R.string.QuadrantDes4),
                backgroundColor = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f)
            )
        }
    }

}
@Composable
fun InfoCard(
    title: String,
    description: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
        Column (
            modifier = modifier
                .fillMaxSize()
                .background(backgroundColor)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(
                text = title,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = description,
                color = Color.Black,
                textAlign = TextAlign.Justify
            )

        }


}


// Task Manager
@Composable
fun TaskManager( modifier: Modifier =Modifier) {

    val image = painterResource(id = R.drawable.ic_task_completed)

    Surface(color = Color.White , modifier = Modifier.fillMaxSize()  ) {

        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ){
            Image(
                painter = image,
                contentDescription = null

            )
            Text(
                text = stringResource(id = R.string.T_line1),
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = modifier.padding(
                    top = 24.dp,
                    bottom = 8.dp
                ),
                textAlign = TextAlign.Center
            )
            Text(
                text = stringResource(id = R.string.T_line2),
                color = Color.Black,
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )

        }

    }
}

// Compose article
@Composable
fun ComposeArticle( modifier: Modifier =Modifier) {

    val image = painterResource(id = R.drawable.bg_compose_background)

    Surface(color = Color.White , modifier = Modifier.fillMaxSize()  ) {

        Column {
            Image(
                painter = image,
                contentDescription = null

            )
            Text(
                text = stringResource(id = R.string.title),
                color = Color.Black,
                fontSize = 24.sp,
                modifier = modifier.padding(16.dp)
            )
            Text(
                text = stringResource(id = R.string.para1),
                color = Color.Black,
                modifier = modifier.padding(16.dp),
                textAlign = TextAlign.Justify
            )
            Text(
                text = stringResource(id = R.string.para2),
                color = Color.Black,
                modifier = modifier.padding(16.dp),
                textAlign = TextAlign.Justify
            )

        }

    }
}


// Greeting Card
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {


    Surface(color = Color.Transparent , modifier = Modifier.fillMaxSize()  ) {

        Column (
            verticalArrangement = Arrangement.Center,
            modifier = modifier.padding(8.dp)
        ) {
            Text(
                text = "Happy Birthday $name",
                fontSize = 75.sp,
                lineHeight = 120.sp,
                textAlign = TextAlign.Center
            )
            Text(
                text = "May God bless you",
                fontSize = 25.sp,
                modifier = modifier
                    .padding(30.dp)
                    .align(alignment = Alignment.End),
                )

        }

    }
}

@Composable
fun GreetingImage(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.androidparty)

    Box {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Greeting(name = stringResource(id = R.string.Name))
    }


}

@Preview
@Composable
fun GreetingPreview() {
    GreetingCardTheme {
        //GreetingImage()
        //ComposeArticle()
        //TaskManager()
        //QuadrantView()
        AllCompose()
    }
}