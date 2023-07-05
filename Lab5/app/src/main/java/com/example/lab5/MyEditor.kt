package com.example.lab5

object MyEditor {
    private val shapes = mutableListOf<Shapes>()
    private lateinit var myShape: Shapes

    fun startMyShape(shape: Shapes): MyEditor {
        myShape = shape
        return this
    }

    fun mouseDown(x1: Float, y1: Float) {
        myShape = myShape.clone()
        myShape.setStartCords(x1, y1)
    }

    fun mouseMove(x2: Float, y2: Float) {
        myShape.stopDrawing = false
        if (shapes.contains(myShape)) shapes.removeAt(shapes.lastIndex)

        myShape.setFinishCords(x2, y2)
        shapes.add(myShape)
    }

    fun mouseUp() {
        myShape.stopDrawing = true
    }

    fun listOfShapes(): MutableList<Shapes> {
        return shapes
    }
}