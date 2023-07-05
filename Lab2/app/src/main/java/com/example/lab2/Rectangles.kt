package com.example.lab2

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class Rectangles(context: Context,
                 extraCanvas: Canvas,
                 extraBitmap: Bitmap) : Shapes(context, extraCanvas, extraBitmap) {

    override fun drawShape(canvas: Canvas, paint: Paint) {
        val endX = 2 * startX - moveX
        val endY = 2 * startY - moveY

        if (!isDrawing) {
            paintAtr(Color.GREEN, Paint.Style.FILL, paint)
            canvas.drawRect(moveX, moveY, endX, endY, paint)

            paintAtr(Color.BLACK, Paint.Style.STROKE, paint)
        }

        canvas.drawRect(moveX, moveY, endX, endY, paint)
    }
}