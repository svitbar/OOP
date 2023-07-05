package com.example.lab_6

import android.content.ComponentName
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.example.lab_6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() {
        val editData = arrayOf(binding.inputN,
            binding.inputMin,
            binding.inputMax)
        binding.executeButton.isEnabled = false

        binding.checkButton.setOnClickListener {
            if (checkData(editData)) {
                val data = myData(editData)
                binding.executeButton.isEnabled = checkInput(editData, data)
            }
        }

        binding.executeButton.setOnClickListener {
            val output = myData(editData)
            sendData(output)
            binding.executeButton.isEnabled = false
        }
    }

    private fun myData(edit: Array<EditText>): IntArray {
        val list = mutableListOf<Int>()

        for (i in edit) list.add(i.text.toString().toInt())

        return list.toIntArray()
    }

    private fun checkData(edit: Array<EditText>): Boolean {
        for (i in edit) return isFilled(edit)

        return true
    }

    private fun checkInput(edit: Array<EditText>, data: IntArray): Boolean {
        if (data[0] < 0) {
            edit[0].error = "N cannot be negative"
            return false
        }
        if (data[1] >= data[2]) {
            edit[1].error = "Min cannot be greater than max"
            edit[2].error = "Max cannot be less than min"
            return false
        }
        edit.forEach { it.error = null }
        return true
    }

    private fun isFilled(edit: Array<EditText>): Boolean {
        for (i in edit) if (i.text.toString().isEmpty()) return false
        return true
    }

    private fun sendData(data: IntArray) {
        val intent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra("data", data)
        }

        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or
                Intent.FLAG_ACTIVITY_CLEAR_TASK

        val shareIntent = intent.setComponent(
            ComponentName("com.example.object_2", "com.example.object_2.MainActivity" )
        )
        startActivity(shareIntent)
    }
}