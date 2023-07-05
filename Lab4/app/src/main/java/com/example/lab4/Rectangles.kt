package com.example.lab4

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class Rectangles(context: Context,
                 extraCanvas: Canvas,
                 extraBitmap: Bitmap
) : Shapes(context, extraCanvas, extraBitmap) {

    override fun drawShape(canvas: Canvas, paint: Paint) {

        if (!isDrawing) {
            paintAtr(Color.rgb(0, 255, 255), Paint.Style.FILL, paint, 0f)
            canvas.drawRect(startX, startY, moveX, moveY, paint)

            paintAtr(Color.BLACK, Paint.Style.STROKE, paint, 0f)
        }

        canvas.drawRect(startX, startY, moveX, moveY, paint)
    }
}