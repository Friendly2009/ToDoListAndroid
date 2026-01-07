package com.example.mytodolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mytodolist.core.sqliteManager
import com.example.mytodolist.ui.screens.MainScreen
import com.example.mytodolist.ui.screens.settings

class MainActivity : ComponentActivity() {
    private lateinit var SqliteManager: sqliteManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        SqliteManager = sqliteManager.getInstance(this)
        SqliteManager.createDatabase()
        val db = SqliteManager.readableDatabase
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "main") {
                composable("main"){
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


