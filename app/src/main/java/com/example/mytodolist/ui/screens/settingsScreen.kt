package com.example.mytodolist.ui.screens

import android.R.attr.onClick
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mytodolist.core.SettingsViewModel

@Composable
fun Settings(
    viewModel: SettingsViewModel = viewModel(),
    logout: () -> Unit,
    developerScreen: () -> Unit) {
    Scaffold() { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            IconButton(onClick = {logout()}) {
                Icon(imageVector = Icons.Filled.ArrowBackIosNew, "logout")
            }
            Text(text = "Темы", style = MaterialTheme.typography.titleMedium)
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Темная тема")
                Spacer(modifier = Modifier.weight(1f))
                Switch(
                    checked = viewModel.isDarkTheme.value,
                    onCheckedChange = { viewModel.isDarkTheme.value = it },
                ) }
            Divider(
                thickness = 1.dp,
                color = Color.Gray,
                modifier = Modifier.fillMaxWidth()
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { developerScreen() },
                horizontalArrangement = Arrangement.Center
            ) {
                Text("developer panel")
            }
        }
    }
}