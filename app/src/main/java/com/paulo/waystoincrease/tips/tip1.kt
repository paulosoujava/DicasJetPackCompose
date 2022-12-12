package com.paulo.waystoincrease.tips

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.pow

@Composable
fun Tip1(isOptimized: Boolean = true) {
    var toggle by remember {
        mutableStateOf(false)
    }

    Column(Modifier.fillMaxSize()) {
        Button(onClick = { toggle = !toggle }) {
            Text("Press me")
        }

        if (toggle) {
            val list = mutableListOf<String>()

            for (i: Int in 0..200000) {
                list.add("Name $i")
            }
            if (isOptimized)
                BadComposeNameList(
                    names = list
                )
            else
                RightComposeNameList(list)
        }
    }
}

val reusableModifier = Modifier
    .padding(bottom = 5.dp)
    .fillMaxWidth()
    .clip(CircleShape)
    .onSizeChanged {
        println("On size changed")
        for (i: Int in 0..10000) {
            val x = i * i
                .toDouble()
                .pow(5.0)
            val y = x + 1
        }
        IntOffset(0, 0)
    }


@Composable
fun RightComposeNameList(names: MutableList<String>) {

    LazyColumn {
        items(names) {
            Text(
                text = it,
                modifier = reusableModifier,
                fontSize = 25.sp

            )
        }
    }
}

@Composable
fun BadComposeNameList(names: MutableList<String>) {

    LazyColumn {
        items(names) {
            Text(
                text = it,
                modifier = Modifier
                    .padding(bottom = 5.dp)
                    .fillMaxWidth()
                    .clip(CircleShape)
                    .onSizeChanged {
                        println("On size changed")
                        for (i: Int in 0..10000) {
                            val x = i * i
                                .toDouble()
                                .pow(5.0)
                            val y = x + 1
                        }
                        IntOffset(0, 0)
                    },
                fontSize = 25.sp

            )
        }
    }

}
