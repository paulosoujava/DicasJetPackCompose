package com.paulo.waystoincrease.tips

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlin.math.roundToInt

@Composable
fun Tip3(isOptimized: Boolean = false) {
    val counter = remember {
        mutableStateOf(0)
    }

    LaunchedEffect(key1 = true) {
        for (i: Int in 0..10000) {
            delay(5)
            counter.value++
        }
    }

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if(isOptimized)
            ProgressComposableRight(progress = counter)
        else
            ProgressComposableWrong(progress = counter)
    }
}

@Composable
fun ProgressComposableRight(progress: State<Int>) {

    //another example
   // val scrollState = rememberLazyListState()

    val progressInPercentage = remember {
        derivedStateOf {
            (progress.value / 100f)
            //scrollState.firstVisibleItemIndex >0
        }
    }

    println("Progress Composition: ${progressInPercentage.value}")
    Text(text = "Progress: ${progressInPercentage.value.roundToInt()}%", fontSize = 45.sp)
}

@Composable
fun ProgressComposableWrong(progress: State<Int>) {
    println("Progress Composition: ${progress.value}")
    Text(text = "Progress: ${(progress.value / 100f).roundToInt()}%", fontSize = 45.sp)
}
