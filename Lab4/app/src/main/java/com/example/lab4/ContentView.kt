package com.example.lab4

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas
import android.view.View

open class ContentView(context: Context) : View(context) {
    private var extraCanvas: Canvas
    private var extraBitmap: Bitmap

    init {
        val hd = Resources.getSystem().displayMetrics.heightPixels
        val wd = Resources.getSystem().displayMetrics.widthPixels
        extraBitmap = Bitmap.createBitmap(wd, hd, Bitmap.Config.ARGB_8888)
        extraCanvas = Canvas(extraBitmap)
    }

    var line = Line(context, extraCanvas, extraBitmap)
    var dot = Dot(context, extraCanvas, extraBitmap)
    var rect = Rectangles(context, extraCanvas, extraBitmap)
    var ellipse = Ellipse(context, extraCanvas, extraBitmap)
    var brush = Brush(context, extraCanvas, extraBitmap)
    var cube = Cube(context, extraCanvas, extraBitmap)
    var lineOO = LineOO(context, extraCanvas, extraBitmap)
}