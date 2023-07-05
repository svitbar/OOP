package com.example.lab2

import android.content.Context
import android.graphics.*

class Ellipse(context: Context,
              extraCanvas: Canvas,
              extraBitmap: Bitmap) : Shapes(context, extraCanvas, extraBitmap) {

    override fun drawShape(canvas: Canvas, paint: Paint) {

        val oval = RectF(startX, startY, moveX, moveY)

        if (!isDrawing) {
            paintAtr(Color.WHITE, Paint.Style.FILL, paint)
            canvas.drawOval(oval, paint)

            paintAtr(Color.BLACK, Paint.Style.STROKE, paint)
        }

        canvas.drawOval(oval, paint)
    }
}