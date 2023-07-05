package com.example.lab5

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

open class ContentView(context: Context) : View(context) {

    private var editor = MyEditor.startMyShape(Rectangles())
    private var paint = Paint()
    private lateinit var table: Table
    private var name: String = resources.getString(R.string.dot_title)

    fun startMyEditor(shape: Shapes) {
        editor = editor.startMyShape(shape)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {

        val cordX = event.x
        val cordY = event.y

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                editor.mouseDown(cordX, cordY)
            }
            MotionEvent.ACTION_MOVE -> {
                invalidate()
                editor.mouseMove(cordX, cordY)
            }
            MotionEvent.ACTION_UP -> {
                invalidate()
                editor.mouseUp()
                fillRow()
            }
        }
        return true
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        for (item in editor.listOfShapes()) {
            item.drawShape(canvas, paint)
            if (item.stopDrawing) item.drawFinalShape(canvas, paint)
        }
    }

    fun startMyTable(_table: Table) {
        table = _table
    }

    fun shapeName(_name: String) {
        name = _name
    }

    private fun fillRow() {
        val cordsArray = editor.listOfShapes().last().getCords()

        if (name == resources.getString(R.string.dot_title)) {
            cordsArray[2] = cordsArray[0]
            cordsArray[3] = cordsArray[1]
        }

        table.addRow(name, cordsArray)
        writeFile(name, cordsArray)
    }

    private lateinit var file: File

    fun createFile() {
        val fileName = "Figures.txt"
        val path = context.getExternalFilesDir(null)

        val oldFilePath = Paths.get("$path/$fileName")
        Files.deleteIfExists(oldFilePath)

        file = File(path, fileName)
    }

    private fun writeFile(shape: String, array: Array<Float>) {
        var string = shape + "\t"
        for (item in array) string += item.toString() + "\t"

        file.appendText(string + "\n")
    }
}