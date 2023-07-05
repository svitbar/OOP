package com.example.lab5

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class Cube : Shapes() {

    override fun drawShape(canvas: Canvas, paint: Paint) {
        setDashEffect(paint)
        calculateCube(canvas, paint)
    }

    override fun drawFinalShape(canvas: Canvas, paint: Paint) {
        setColorStyle(paint, Color.BLACK, Paint.Style.STROKE)
        calculateCube(canvas, paint)
    }

    override fun highlightShape(canvas: Canvas, paint: Paint) {
        setColorStyle(paint, Color.RED, Paint.Style.STROKE)
        calculateCube(canvas, paint)
    }

    private fun calculateCube(canvas: Canvas, paint: Paint) {
        val edge = (y2 - y1) / 4

        canvas.drawRect(x1, y1, x2 + edge, y2 - edge, paint)
        canvas.drawRect( x1 - edge, y1 + edge, x2, y2, paint)
        canvas.drawLine(x1, y1,x1 - edge, y1 + edge, paint)
        canvas.drawLine( x2 + edge, y2 - edge, x2, y2, paint)
        canvas.drawLine(x1, y2 - edge, x1 - edge, y2, paint)
        canvas.drawLine(x2 + edge, y1, x2, y1 + edge, paint)
    }
}