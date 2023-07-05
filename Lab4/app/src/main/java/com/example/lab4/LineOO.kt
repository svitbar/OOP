package com.example.lab4

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import kotlin.math.*

class LineOO(context: Context,
             extraCanvas: Canvas,
             extraBitmap: Bitmap
) : Shapes(context, extraCanvas, extraBitmap) {

    override fun drawShape(canvas: Canvas, paint: Paint) {
        if (!isDrawing) paintAtr(Color.BLACK, Paint.Style.STROKE, paint, 0f)

        var dx = moveX - startX
        var dy = moveY - startY
        var r = sqrt(dx.pow(2) + dy.pow(2)) / 10
        var angle = atan(dy / dx)
        var k = 1

        if (dx <= 0) k = -1

        var x = k * r * cos(angle)
        var y = k * r * sin(angle)

        canvas.drawCircle(startX, startY, r, paint)
        canvas.drawLine(startX + x,
            startY + y,
            moveX - x,
            moveY - y, paint)
        canvas.drawCircle(moveX, moveY, r, paint)
    }
}