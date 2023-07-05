package com.example.lab4

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class Line(context: Context,
           extraCanvas: Canvas,
           extraBitmap: Bitmap
) : Shapes(context, extraCanvas, extraBitmap) {

    override fun drawShape(canvas: Canvas, paint: Paint) {
        if (!isDrawing) paintAtr(Color.BLACK, Paint.Style.STROKE, paint, 0f)

        canvas.drawLine(startX, startY, moveX, moveY, paint)
    }
}