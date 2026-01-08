package com.example.mytodolist.core

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SettingsViewModel: ViewModel() {
    var isDarkTheme = mutableStateOf(true)
}