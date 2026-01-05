package com.example.mytodolist.core

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class sqliteManager(private val context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object{
        private const val DATABASE_NAME = "todolist.db"
        private const val DATABASE_VERSION = 1
        private var instance: sqliteManager? = null

        fun getInstance(context: Context): sqliteManager {
            if (instance == null) {
                instance = sqliteManager(context.applicationContext)
            }
            return instance!!
        }
    }
    fun createTable(db: SQLiteDatabase) {
        val createTableQuery = """
        CREATE TABLE IF NOT EXISTS main (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            name TEXT NOT NULL
        );
    """.trimIndent()
        db.execSQL(createTableQuery)
    }
    override fun onCreate(db: SQLiteDatabase) {
        createTable(db = db)
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
    fun createDatabase() {
        val dbFile = context.getDatabasePath(DATABASE_NAME)
        if (!dbFile.exists()) {
            this.readableDatabase
            try {
                copyDatabase(dbFile)
            } catch (e: IOException) {
                throw RuntimeException("Error copying database", e)
            }
        }
    }

    private fun copyDatabase(dbFile: File) {
        val inputStream: InputStream = context.assets.open(DATABASE_NAME)
        val outputStream: OutputStream = FileOutputStream(dbFile)

        val buffer = ByteArray(1024)
        var length: Int
        while (inputStream.read(buffer).also { length = it } > 0) {
            outputStream.write(buffer, 0, length)
        }

        outputStream.flush()
        outputStream.close()
        inputStream.close()
    }
}