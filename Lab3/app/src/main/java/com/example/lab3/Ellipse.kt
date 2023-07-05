package com.example.lab3

import android.content.Context
import android.graphics.*

class Ellipse(context: Context,
              extraCanvas: Canvas,
              extraBitmap: Bitmap
) : Shapes(context, extraCanvas, extraBitmap) {

    override fun drawShape(canvas: Canvas, paint: Paint) {

        var endX = 2 * startX - moveX
        var endY = 2 * startY - moveY

        val oval = RectF(moveX, moveY, endX, endY)

        if (!isDrawing) paintAtr(Color.BLACK, Paint.Style.STROKE, paint)

        canvas.drawOval(oval, paint)
    }
}