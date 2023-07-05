package com.example.lab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity() {

    private lateinit var contentView: ContentView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        contentView = ContentView(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_1, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.dot -> {
                title = item.title
                setContentView(contentView.dot)
            }
            R.id.line -> {
                title = item.title
                setContentView(contentView.line)
            }
            R.id.ellips -> {
                title = item.title
                setContentView(contentView.ellipse)
            }
            R.id.rectangle -> {
                title = item.title
                setContentView(contentView.rect)
            }
            R.id.brush -> {
                title = item.title
                setContentView(contentView.brush)
            }
        }
        return true
    }

}