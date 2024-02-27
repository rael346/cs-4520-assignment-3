package com.cs4520.assignment3.ui.mvp

interface Model {
    fun add(number1: Int, number2: Int): Int
    fun subtract(number1: Int, number2: Int): Int
    fun multiply(number1: Int, number2: Int): Int
    fun divide(number1: Int, number2: Int): Int
}
class MVPModel: Model {
    override fun add(number1: Int, number2: Int): Int {
        return number1 + number2
    }

    override fun subtract(number1: Int, number2: Int): Int {
        return number1 - number2;
    }
    override fun multiply(number1: Int, number2: Int): Int {
        return number1 * number2
    }

    override fun divide(number1: Int, number2: Int): Int {
        return number1 / number2
    }
}