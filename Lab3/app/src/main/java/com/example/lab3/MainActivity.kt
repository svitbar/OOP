package com.example.lab3

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity() {

    private lateinit var contentView: ContentView
    private var index = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        contentView = ContentView(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu): Boolean {
        when(index) {
            0 -> {
                menu.getItem(0).icon.setTint(Color.MAGENTA)
                menu.getItem(1).isChecked = true
            }
            1 -> {
                menu.getItem(2).icon.setTint(Color.MAGENTA)
                menu.getItem(3).isChecked = true
            }
            2 -> {
                menu.getItem(4).icon.setTint(Color.MAGENTA)
                menu.getItem(5).isChecked = true
            }
            3 -> {
                menu.getItem(6).icon.setTint(Color.MAGENTA)
                menu.getItem(7).isChecked = true
            }
            4 -> {
                menu.getItem(8).icon.setTint(Color.MAGENTA)
                menu.getItem(9).isChecked = true
            }
            else -> {
                menu.getItem(0).icon.setTint(Color.WHITE)
                menu.getItem(2).icon.setTint(Color.WHITE)
                menu.getItem(4).icon.setTint(Color.WHITE)
                menu.getItem(6).icon.setTint(Color.WHITE)
                menu.getItem(8).icon.setTint(Color.WHITE)
            }
        }

        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.dot -> {
                index = 0

                invalidateOptionsMenu()
                setContentView(contentView.dot)
            }
            R.id.line -> {
                index = 1

                invalidateOptionsMenu()
                setContentView(contentView.line)
            }
            R.id.ellips -> {
                index = 2

                invalidateOptionsMenu()
                setContentView(contentView.ellipse)
            }
            R.id.rectangle -> {
                index = 3

                invalidateOptionsMenu()
                setContentView(contentView.rect)
            }
            R.id.brush -> {
                index = 4

                invalidateOptionsMenu()
                setContentView(contentView.brush)
            }
        }
        return true
    }
}