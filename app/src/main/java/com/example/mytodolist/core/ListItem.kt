package com.example.mytodolist.core

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun item(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(0.10f)){
        Text(text = "Title")
    }
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(0.90f)){
        Text(text = "This is the text")
    }
}