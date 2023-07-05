package com.example.lab4

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class Cube(context: Context,
           extraCanvas: Canvas,
           extraBitmap: Bitmap) : Shapes(context, extraCanvas, extraBitmap) {

    override fun drawShape(canvas: Canvas, paint: Paint) {
        if (!isDrawing) paintAtr(Color.BLACK, Paint.Style.STROKE, paint, 0f)

        var edge = (moveY - startY) / 4

        canvas.drawRect(startX, startY, moveX + edge, moveY - edge, paint)
        canvas.drawRect( startX - edge, startY + edge, moveX, moveY, paint)
        canvas.drawLine(startX, startY,startX - edge, startY + edge, paint)
        canvas.drawLine( moveX + edge, moveY - edge, moveX, moveY, paint)
        canvas.drawLine(startX, moveY - edge, startX - edge, moveY, paint)
        canvas.drawLine(moveX + edge, startY, moveX, startY + edge, paint)
    }
}