package com.example.lab5

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class Rectangles : Shapes() {

    override fun drawShape(canvas: Canvas, paint: Paint) {
        setDashEffect(paint)
        canvas.drawRect(x1, y1, x2, y2, paint)
    }

    override fun drawFinalShape(canvas: Canvas, paint: Paint) {
        setColorStyle(paint, Color.rgb(0, 255, 255), Paint.Style.FILL)
        canvas.drawRect(x1, y1, x2, y2, paint)

        setColorStyle(paint, Color.BLACK, Paint.Style.STROKE)
        canvas.drawRect(x1, y1, x2, y2, paint)
    }

    override fun highlightShape(canvas: Canvas, paint: Paint) {
        setColorStyle(paint, Color.RED, Paint.Style.STROKE)
        canvas.drawRect(x1, y1, x2, y2, paint)
    }
}