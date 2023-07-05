package com.example.lab4

import android.content.Context
import android.graphics.*
import android.view.MotionEvent
import android.view.ViewConfiguration
import kotlin.math.abs

class Brush(context: Context,
            private var extraCanvas: Canvas,
            extraBitmap: Bitmap
) : Shapes(context, extraCanvas, extraBitmap) {

    private val path = Path()
    private val touchTolerance = ViewConfiguration.get(context).scaledTouchSlop
    private var paint = Paint()

    override fun onTouchEvent(event: MotionEvent): Boolean {
        startX = event.x
        startY = event.y

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                path.reset()
                path.moveTo(startX, startY)

                moveX = startX
                moveY = startY

                isDrawing = true
            }
            MotionEvent.ACTION_MOVE -> {
                val dx = abs(startX - moveX)
                val dy = abs(startY - moveY)

                if (dx >= touchTolerance || dy >= touchTolerance) {
                    path.quadTo(
                        moveX, moveY,
                        (moveX + startX) / 2,
                        (startY + moveY) / 2
                    )

                    moveX = event.x
                    moveY = event.y
                }
                invalidate()
            }
            MotionEvent.ACTION_UP -> {
                isDrawing = false

                drawShape(extraCanvas, paint)
                invalidate()
                path.reset()
            }
        }
        return true
    }

    override fun drawShape(canvas: Canvas, paint: Paint) {
        if(!isDrawing) paintAtr(Color.BLACK, Paint.Style.STROKE, paint, 0f)
        canvas.drawPath(path, paint)
    }
}