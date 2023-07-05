package com.example.lab5

import android.graphics.*

class Ellipse : Shapes() {

    override fun drawShape(canvas: Canvas, paint: Paint) {
        setDashEffect(paint)
        canvas.drawOval(x1, y1, x2, y2, paint)
    }

    override fun drawFinalShape(canvas: Canvas, paint: Paint) {
        setColorStyle(paint, Color.BLACK, Paint.Style.STROKE)
        canvas.drawOval(x1, y1, x2, y2, paint)
    }

    override fun highlightShape(canvas: Canvas, paint: Paint) {
        setColorStyle(paint, Color.RED, Paint.Style.STROKE)
        canvas.drawOval(x1, y1, x2, y2, paint)
    }
}