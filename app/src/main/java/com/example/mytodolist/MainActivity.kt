package com.example.mytodolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mytodolist.core.sqliteManager
import com.example.mytodolist.ui.screens.MainScreen
import com.example.mytodolist.ui.screens.Settings
import com.example.mytodolist.ui.theme.MyToDoListTheme

class MainActivity : ComponentActivity() {
    private lateinit var SqliteManager: sqliteManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        SqliteManager = sqliteManager.getInstance(this)
        SqliteManager.createDatabase()
        val db = SqliteManager.readableDatabase
        setContent {
            var isDarkTheme by remember { mutableStateOf(false) }
            MyToDoListTheme(isDarkTheme) {
                Surface(modifier = Modifier.fillMaxSize()) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "main") {
                        composable("main") {
                            MainScreen(newItem = {

                            }, toItem = {
                                navController.navigate("Item")
                            }, settings = {
                                navController.navigate("Settings")
                            })
                        }
                        composable("Item") {

                }
                composable("Settings") {
                    settings()
                }
            }
        }
    }
}


