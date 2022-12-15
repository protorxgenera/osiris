package com.protorxgenera.osiris

import android.os.Bundle
import android.widget.CheckBox
import android.widget.Switch
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.CardDefaults.cardElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.protorxgenera.osiris.ui.theme.*

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val painter = painterResource(id = R.drawable.ic_launcher_foreground)


            // Scaffold is a Material3 default component that helps by structuring the layout.
            // It has a top bar (which I used here), a bottom bar, some floating buttons and a pop-up
            // The main app is inside the content variable
            Scaffold(topBar = {
                TopAppBar(
                    title = {
                        Text(text = "00-osiris-01-00-00", style = TextStyle(color = White))
                    }, colors = TopAppBarDefaults.topAppBarColors(DarkGray)
                )
            }, content = { innerPadding ->
                Column( // the components inside Column will be placed one under the other, like a list
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
//                ImageCard(painter = painter, contentDescription = "Hello", title = "Hello")
                    Text(text = "Pressing the button will change its color")
                    Spacer(
                        modifier = Modifier.height(48.dp)
                    )
                    MyButton()
                }

            })
        }
    }
}

// normally, custom components are written here (= composable functions)
// Composable functions are written in UpperCamelCase, as opposed to normal functions
@Composable
fun ImageCard( // Ignore this whole function
    painter: Painter, contentDescription: String, title: String, modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 20.dp)
    ) {
        Image(
            painter = painter,
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop
        )
    }

}

@Composable
fun MyButton() {
    val colorList = listOf(
        DarkCyan,
        IntenseBlue,
        DarkBlue,
        DarkPink,
        Color.DarkGray,
        Color.Gray,
        Pink40,
        Purple40,
        PurpleGrey40
    )
    val myColor = remember { mutableStateOf(Color.DarkGray) }

    Button(colors = buttonColors(containerColor = myColor.value),
        onClick = { myColor.value = colorList.random() })
    {
        Text(text = "Press me please", modifier = Modifier.padding(8.dp))
    }

}

