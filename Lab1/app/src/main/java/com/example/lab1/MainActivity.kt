package com.example.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val number = intent.getStringExtra("number_key")
        val progressTextView = findViewById<TextView>(R.id.passedText)
        progressTextView.text = number
    }

    fun Work1(view: View) {
        val intent = Intent(this, Module1::class.java)
        startActivity(intent)
    }

    fun Work2(view: View) {
        val intent = Intent(this, Module2::class.java)
        startActivity(intent)
    }
}