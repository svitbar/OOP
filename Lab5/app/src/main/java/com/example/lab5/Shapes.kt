package com.example.lab5

import android.graphics.*

abstract class Shapes: Cloneable {

    var x1: Float = 0.0f
    var y1: Float = 0.0f
    var x2: Float = 0.0f
    var y2: Float = 0.0f

    var stopDrawing: Boolean = false

    abstract fun drawShape(canvas: Canvas, paint: Paint)
    abstract fun drawFinalShape(canvas: Canvas, paint: Paint)
    abstract fun highlightShape(canvas: Canvas, paint: Paint)

    public override fun clone(): Shapes {
        return super.clone() as Shapes
    }

    fun setColorStyle(paint: Paint, color: Int, style: Paint.Style) {
        paint.color = color
        paint.style = style
        paint.isAntiAlias = true
        paint.strokeWidth = 10f
        paint.pathEffect = DashPathEffect(floatArrayOf(0f, 0f), 0f)
    }

    fun setDashEffect(paint: Paint) {
        paint.color = Color.BLUE
        paint.style = Paint.Style.STROKE
        paint.isAntiAlias = true
        paint.strokeWidth = 10f
        paint.pathEffect = DashPathEffect(floatArrayOf(60f, 20f), 0f)
    }

    fun setStartCords(_x1: Float, _y1: Float) {
        x1 = _x1
        y1 = _y1
    }

    fun setFinishCords(_x2: Float, _y2: Float) {
        x2 = _x2
        y2 = _y2
    }

    fun getCords(): Array<Float> {
        return  arrayOf(x1, y1, x2, y2)
    }
}