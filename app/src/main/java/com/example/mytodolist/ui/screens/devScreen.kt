package com.example.mytodolist.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mytodolist.core.SettingsViewModel
import com.example.mytodolist.ui.theme.MyToDoListTheme

@Preview
@Composable
fun devScreen(){
    Column(
        Modifier.fillMaxSize(),verticalArrangement = Arrangement.SpaceBetween) {
        Row(modifier = Modifier.fillMaxWidth().fillMaxHeight(0.05f).background(Color.Red),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Filled.ArrowBackIosNew, contentDescription = "back")
            }
            Text(
                text = "FOR DEVELOPER",
                modifier = Modifier.weight(1f).fillMaxHeight(),
                textAlign = TextAlign.End,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        Row(modifier = Modifier.fillMaxWidth().fillMaxHeight(0.35f).padding(end = 10.dp, start = 10.dp).background(Color.Red)) {
            val codeLines = listOf(
                "import androidx.compose.foundation.lazy.LazyColumn",
                "import androidx.compose.foundation.lazy.items",
                "import androidx.compose.foundation.shape.RoundedCornerShape",
                "import androidx.compose.foundation.shape.RoundedCornerShape",
                "import androidx.compose.foundation.shape.RoundedCornerShape",
            )
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(1.dp, Color.Gray),
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    codeLines.forEach { line ->
                        Text(
                            text = line,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.Black
                        )
                    }
                }
            }
        }
        Row(modifier = Modifier.fillMaxWidth().fillMaxHeight(0.75f).padding(10.dp).background(Color.Red)) {

        }
    }
}