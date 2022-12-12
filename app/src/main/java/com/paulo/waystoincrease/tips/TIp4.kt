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

//NOT DO THAT
//Avoid backwards writing
@Composable
fun Tip4() {

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
        Text(text = "Value ${counter.value}", fontSize = 40.sp)
    }
    counter.value++
}