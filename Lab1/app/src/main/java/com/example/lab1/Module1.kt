package com.example.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView

class Module1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module1)

        val seek = findViewById<SeekBar>(R.id.seekbar)
        val num = findViewById<TextView>(R.id.number)
        val yep = findViewById<Button>(R.id.button7)

        seek.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                num.text = p1.toString()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })

        yep.setOnClickListener {
            val intent = Intent(this@Module1, MainActivity::class.java)
            val number = num.text.toString()
            intent.putExtra("number_key", number)
            startActivity(intent)
        }
    }

    fun OnClickCancel1(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}