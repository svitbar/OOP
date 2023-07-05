package com.example.lab4

import android.content.Context
import android.graphics.*
import android.view.MotionEvent
import android.view.View


abstract class Shapes(context: Context,
                      private var extraCanvas: Canvas,
                      private var extraBitmap: Bitmap
) : View(context) {

    private var paint = Paint()
    var isDrawing = false

    var startX = 0f
    var startY = 0f

    var moveX = 0f
    var moveY = 0f

    override fun onTouchEvent(event: MotionEvent): Boolean {

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                startX = event.x
                startY = event.y

                isDrawing = true
            }
            MotionEvent.ACTION_MOVE -> {
                moveX = event.x
                moveY = event.y

                invalidate()
            }
            MotionEvent.ACTION_UP -> {

                isDrawing = false
                drawShape(extraCanvas, paint)
                invalidate()
            }
        }
        return true
    }

    fun paintAtr(color: Int, style: Paint.Style, paint: Paint, step: Float) {
        paint.color = color
        paint.style = style
        paint.isAntiAlias = true
        paint.strokeWidth = 10f
        paint.pathEffect = DashPathEffect(floatArrayOf(step, step - 40.0f), 0f)
    }

    abstract fun drawShape(canvas: Canvas, paint: Paint)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawBitmap(extraBitmap, 0f, 0f, null)

        if(isDrawing) {
            paintAtr(Color.BLUE, Paint.Style.STROKE, paint, 60.0f)
            drawShape(canvas, paint)
        }
    }
}