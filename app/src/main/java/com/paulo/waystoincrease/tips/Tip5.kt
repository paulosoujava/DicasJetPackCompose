package com.paulo.waystoincrease.tips

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import kotlin.math.pow

//Wait until you read state
//as long as possible
@Composable
fun Tip5(isOptimized: Boolean = false) {
    val counter = remember {
        mutableStateOf(0)
    }

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            counter.value++
        }) {
            Text(text = "Increase", fontSize = 40.sp)
        }
        val currentHeavyResult = 50.0.pow(50.0)

        if (isOptimized) {
            Composable1Wrong(text = "${counter.value}")
            Composable2Wrong(text = "$currentHeavyResult")
        } else {
            Composable1Right { "${counter.value}" }
            Composable2Right { "$currentHeavyResult" }
        }
        //more composables
        println("Composition composable column")
    }
    counter.value++
}

@Composable
fun Composable1Wrong(text: String) {
    Text(text = "Composition Composable 1: $text", fontSize = 40.sp)
}

@Composable
fun Composable2Wrong(text: String) {
    Text(text = "Composition Composable 2: $text", fontSize = 40.sp)
}

@Composable
fun Composable1Right(onText: () -> String) {
    Text(onText(), fontSize = 40.sp)
}

@Composable
fun Composable2Right(onText: () -> String) {
    Text(onText(), fontSize = 40.sp)
}