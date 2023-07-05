package com.example.object_2

import android.annotation.SuppressLint
import android.content.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import com.example.object_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var clipboardManager: ClipboardManager
    private var matrix = MyMatrix()
    private var det = Determinant()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (receiveData() != null) {
            receiveData()?.let { setData(it) }
            sendData()
        }
  /*      val arr = intArrayOf(2, 2, 4)
        setData(arr)*/
    }

    private fun setData(arr: IntArray) {
        val data = matrix.showMatrix(arr[0], arr[1], arr[2])
        val detValue = det.showDeterminant(data, data.size)
        println(detValue)
        fillTable(data)
        copyTextToClipboard(detValue.toString())
    }

    private fun receiveData(): IntArray? {
        if (intent.action == Intent.ACTION_SEND) {
            return intent.getIntArrayExtra("data")
        }
        return null
    }

    @SuppressLint("SetTextI18n")
    private fun fillTable(list: MutableList<MutableList<Int>>) {

        for (row in 0 until list.size) {

            val tableRow = TableRow(this)

            for (col in list[row]) {

                val textColumn = TextView(this)
                textColumn.text = "$col    "
                textColumn.textSize = 24F

                tableRow.addView(textColumn)
            }
            binding.tableLayout.addView(tableRow)
        }
    }

    private fun copyTextToClipboard(textToCopy: String) {
        println(textToCopy)
        clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = ClipData.newPlainText("text", textToCopy)
        clipboardManager.setPrimaryClip(clipData)
        Toast.makeText(this, "Text copied to clipboard", Toast.LENGTH_LONG).show()
    }

    private fun sendData() {
        val intent: Intent = Intent().apply {
            action = Intent.ACTION_MAIN
        }
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or
                Intent.FLAG_ACTIVITY_CLEAR_TASK
        val shareIntent = intent.setComponent(
            ComponentName("com.example.object_3", "com.example.object_3.MainActivity" )
        )
        startActivity(shareIntent)
    }
}