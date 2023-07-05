package com.example.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Module2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module2)
    }

    fun OnClickNext(view: View) {
        val intent = Intent(this, Module3::class.java)
        startActivity(intent)
    }

    fun OnClickCancel(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}