package com.protorxgenera.osiris

import android.os.Bundle
import android.widget.CheckBox
import android.widget.Switch
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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

// from the Philipp Lackner tutorial
// use rememberMutableState, access the value through .value, enclose in *lambda* function remember

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val squareSize = 150.dp

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                ClickableBox(
                    modifier = Modifier
                        .height(squareSize)
                        .width(squareSize)
                )
            }

        }
    }
}

@Composable
fun ClickableBox(modifier: Modifier = Modifier) {

    val myColor = remember {
        mutableStateOf(IntenseBlue)
    }
    val listOfColors = listOf(
        Purple40, PurpleGrey40, Pink40, IntenseBlue, DarkBlue, DarkCyan, DarkPink
    )

    Box(modifier = modifier
        .background(myColor.value)
        .clickable {
            myColor.value = listOfColors.random()
        })
}
