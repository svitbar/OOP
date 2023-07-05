package com.example.object_2

class MyMatrix {

    private fun createArray(n: Int, min: Int, max: Int): MutableList<Int> {

        val myArray = mutableListOf<Int>()

        repeat(n * n) {
            val number = (min..max).random()
            myArray.add(number)
        }

        return myArray
    }

    private fun createMatrix(array: MutableList<Int>, num: Int): MutableList<MutableList<Int>> {

        val matrixD = mutableListOf<MutableList<Int>>()

        repeat(num) {
            val row = mutableListOf<Int>()

            repeat(num) {
                row.add(array[0])
                array.removeAt(0)
            }
            matrixD.add(row)
        }

        return matrixD
    }

    fun showMatrix(n: Int, min: Int, max: Int): MutableList<MutableList<Int>> {
        val array = createArray(n, min, max)
        return createMatrix(array, n)
    }
}