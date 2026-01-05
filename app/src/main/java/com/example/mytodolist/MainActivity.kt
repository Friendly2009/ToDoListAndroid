package com.example.mytodolist

import android.R
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mytodolist.core.sqliteManager
import com.example.mytodolist.ui.theme.MyToDoListTheme

class MainActivity : ComponentActivity() {
    private lateinit var SqliteManager: sqliteManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        SqliteManager = sqliteManager.getInstance(this)
        val db = SqliteManager.readableDatabase
        var exp = "Hello World"
        setContent {
            MyToDoListTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    try {
                        val cursor = db.rawQuery("SELECT * FROM main", null)
                        cursor.close()
                    }catch(e: Exception) {
                        exp = "$e"
                    }
                    Greeting(
                        name = exp,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "$name",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyToDoListTheme {
        Greeting("Android")
    }
}