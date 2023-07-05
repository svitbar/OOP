package com.example.object_2

import kotlin.math.pow

class Determinant {

    private fun matrixMinor(parentMatrix: MutableList<MutableList<Int>>, num: Int, index: Int):
            MutableList<MutableList<Int>> {

        val newMatrix = parentMatrix.toMutableList()

        repeat(num) { i -> newMatrix[i].removeAt(index) }
        newMatrix.removeAt(0)

        return newMatrix
    }

    private fun calculateDet(matrix: MutableList<MutableList<Int>>, num: Int): Int {
        return when (matrix.size) {
            0 -> 0
            1 -> matrix[0][0]
            2 -> matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0]
            else -> {
                var det = 0
                for (i in matrix.indices) {
                    val copiedMatrix = createCopyList(matrix)
                    val minor = matrixMinor(copiedMatrix, copiedMatrix.size, i)
                    val sign = (-1F).pow(i)
                    det += matrix[0][i] * sign.toInt() * calculateDet(minor, num)
                }

                det
            }
        }
    }

    private fun createCopyList(list: MutableList<MutableList<Int>>): MutableList<MutableList<Int>> {
        val listCopy:  MutableList<MutableList<Int>> = mutableListOf()

        for (i in 0 until list.size) listCopy.add(list[i].toMutableList())

        return listCopy
    }

    fun showDeterminant(matrix: MutableList<MutableList<Int>>, n: Int): Int {

        return calculateDet(matrix, n)
    }
}