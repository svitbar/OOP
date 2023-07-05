package com.example.lab5

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import kotlin.math.*

class LineOO : Shapes() {

    override fun drawShape(canvas: Canvas, paint: Paint) {
        setDashEffect(paint)
        calculateLineOO(canvas, paint)
    }

    override fun drawFinalShape(canvas: Canvas, paint: Paint) {
        setColorStyle(paint, Color.BLACK, Paint.Style.STROKE)
        calculateLineOO(canvas, paint)
    }

    override fun highlightShape(canvas: Canvas, paint: Paint) {
        setColorStyle(paint, Color.RED, Paint.Style.STROKE)
        calculateLineOO(canvas, paint)
    }

    private fun calculateLineOO(canvas: Canvas, paint: Paint) {
        val dx = x2 - x1
        val dy = y2 - y1
        val r = sqrt(dx.pow(2) + dy.pow(2)) / 10
        val angle = atan(dy / dx)
        var k = 1

        if (dx <= 0) k = -1

        val x = k * r * cos(angle)
        val y = k * r * sin(angle)

        canvas.drawCircle(x1, y1, r, paint)
        canvas.drawLine(x1 + x,
            y1 + y,
            x2 - x,
            y2 - y, paint)
        canvas.drawCircle(x2, y2, r, paint)
    }
}