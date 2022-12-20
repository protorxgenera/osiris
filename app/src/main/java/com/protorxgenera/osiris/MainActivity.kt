package com.protorxgenera.osiris

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.unit.dp
import com.protorxgenera.osiris.ui.theme.*

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val squareSize = 100.dp
            val ourColor = remember {
                mutableStateOf (IntenseBlue)
            }

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                ClickableBox(
                    modifier = Modifier
                        .background(DarkGray)
                        .height(squareSize)
                        .width(squareSize)
                ) {
                    color: Color ->
                    ourColor.value = color
                }
                Spacer(modifier = Modifier.height(24.dp))
                Box(
                    modifier = Modifier
                        .height(squareSize)
                        .width(squareSize)
                        .background(ourColor.value)
                )
            }
        }
    }
}

@Composable
fun ClickableBox(modifier: Modifier, function: (Color) -> Unit) {

    val listOfColors = listOf(
        Purple40,
        PurpleGrey40,
        Pink40,
        IntenseBlue,
        DarkBlue,
        DarkCyan,
        DarkPink
    )

    Box(modifier.clickable {

    }) {
        function(listOfColors.random())
    }

}
