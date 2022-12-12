package com.paulo.waystoincrease.tips

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import java.util.jar.Attributes.Name

@Composable
fun Tip2(isOptimized: Boolean = false) {
    val nameList = remember {
        mutableStateListOf("Name 1", "Name 2")
    }

    Column(Modifier.fillMaxSize()) {
        Button(onClick = {
            nameList.add(0, "Name 3")
        }) {
            if (isOptimized)
                NameListNice(names = nameList)
            else
                NameListBad(names = nameList)
        }
    }
}

@Composable
fun NameListBad(names: List<String>) {
    LazyColumn {
        items(names) {
            NameComposable(name = it)
        }
    }
}

@Composable
fun NameListNice(names: List<String>) {
    LazyColumn {
        items(names, key = { it }) {
            NameComposable(name = it)
        }
    }
}

@Composable
fun NameComposable(name: String) {
    println("Composition $name")
    Text(text = name, fontSize = 28.sp)
}
