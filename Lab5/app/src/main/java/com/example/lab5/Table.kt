package com.example.lab5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableRow
import android.widget.TextView
import com.example.lab5.databinding.FragmentTableBinding

class Table : Fragment() {

    private lateinit var binding: FragmentTableBinding
    private val rowViews = mutableListOf<TableRow>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTableBinding.inflate(inflater)
        return binding.root
    }

    fun addRow(name: String, cords: Array<Float>) {
        val tableRow = TableRow(context)
        val textName = TextView(context)

        textName.text = name
        tableRow.addView(textName)

        for (item in cords) {
            val textColumn = TextView(context)
            textColumn.text = item.toString()

            tableRow.addView(textColumn)
            rowViews.add(tableRow)
        }

        binding.tableLayout.addView(tableRow)
    }
}