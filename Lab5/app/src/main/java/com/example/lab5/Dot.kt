package com.example.lab5

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class Dot : Shapes() {

    override fun drawShape(canvas: Canvas, paint: Paint) {
        setDashEffect(paint)
        canvas.drawPoint(x1, y1, paint)
    }

    override fun drawFinalShape(canvas: Canvas, paint: Paint) {
        setColorStyle(paint, Color.BLACK, Paint.Style.STROKE)
        canvas.drawPoint(x1, y1, paint)
    }

    override fun highlightShape(canvas: Canvas, paint: Paint) {
        setColorStyle(paint, Color.RED, Paint.Style.STROKE)
        canvas.drawPoint(x1, x2, paint)
    }
}