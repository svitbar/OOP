
package com.example.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Module3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module3)
    }

    fun OnClickBack(view: View) {
        finish()
    }

    fun OnClickOk(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun OnClickCancel3(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}