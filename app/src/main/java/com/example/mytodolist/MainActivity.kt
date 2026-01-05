package com.example.mytodolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.example.mytodolist.core.sqliteManager
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
            MyToDoListTheme(true) {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Text(text = "Hello world, finally...")
                }
            }
        }
    }
}