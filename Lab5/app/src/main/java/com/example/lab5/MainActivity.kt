package com.example.lab5

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.lab5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var contentView: ContentView
    private var index = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        contentView = ContentView(this)
        binding.canvasLayout.addView(contentView)

        createTable()
        contentView.createFile()
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
            5 -> {
                menu.getItem(10).icon.setTint(Color.MAGENTA)
                menu.getItem(11).isChecked = true
            }
            else -> {
                menu.getItem(4).icon.setTint(Color.WHITE)
                menu.getItem(6).icon.setTint(Color.WHITE)
                menu.getItem(8).icon.setTint(Color.WHITE)
                menu.getItem(10).icon.setTint(Color.WHITE)
                menu.getItem(12).icon.setTint(Color.WHITE)
            }
        }

        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.dot -> {
                index = 0

                invalidateOptionsMenu()
                contentView.startMyEditor(Dot())
                contentView.shapeName(item.title as String)
            }
            R.id.line -> {
                index = 1

                invalidateOptionsMenu()
                contentView.startMyEditor(Line())
                contentView.shapeName(item.title as String)
            }
            R.id.ellipse -> {
                index = 2

                invalidateOptionsMenu()
                contentView.startMyEditor(Ellipse())
                contentView.shapeName(item.title as String)
            }
            R.id.rectangle -> {
                index = 3

                invalidateOptionsMenu()
                contentView.startMyEditor(Rectangles())
                contentView.shapeName(item.title as String)
            }
            R.id.cube -> {
                index = 4

                invalidateOptionsMenu()
                contentView.startMyEditor(Cube())
                contentView.shapeName(item.title as String)
            }
            R.id.lineOO -> {
                index = 5

                invalidateOptionsMenu()
                contentView.startMyEditor(LineOO())
                contentView.shapeName(item.title as String)
            }
            R.id.table -> {
                index = 6

                binding.tableFrame.isVisible = !binding.tableFrame.isVisible
            }
        }
        return true
    }

    private fun createTable() {
        val table = Table()
        binding.tableFrame.isVisible = false
        binding.tableFrame.layoutParams.height = 300
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.table_frame, table)
            .commit()
        contentView.startMyTable(table)
    }
}