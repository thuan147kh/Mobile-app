package com.example.ex1_lab4

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {

    private lateinit var btnReadData: Button
    private lateinit var etContent: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnReadData = findViewById(R.id.btnReadData)
        etContent = findViewById(R.id.etContent)

        btnReadData.setOnClickListener {
            readDataFromFile()
        }
    }

    private fun readDataFromFile() {
        val inputStream = resources.openRawResource(R.raw.myfile)
        val bufferedReader = BufferedReader(InputStreamReader(inputStream))
        val content = StringBuilder()

        bufferedReader.forEachLine { line ->
            content.append(line).append("\n")
        }

        bufferedReader.close()

        etContent.setText(content.toString())
    }
}