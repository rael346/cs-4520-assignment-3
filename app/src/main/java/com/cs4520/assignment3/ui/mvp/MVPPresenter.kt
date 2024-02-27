package com.cs4520.assignment3.ui.mvp

import com.cs4520.assignment3.ui.Operation
import java.lang.Exception

interface Presenter {
    fun operate(operation: Operation)
    fun onDestroy()
}
class MVPPresenter(private var view: MVPView?, private val model: MVPModel): Presenter {
    override fun operate(operation: Operation) {
        val inputs: Pair<Int, Int>;
        try {
            inputs = view?.getNumberInputs()!!
        } catch(e: Exception) {
            e.message?.let { view?.displayError(it) }
            return;
        }
        val number1 = inputs.component1()
        val number2 = inputs.component2()

        try {
            val result: Int = when (operation) {
                Operation.Add -> model.add(number1, number2)
                Operation.Subtract -> model.subtract(number1, number2)
                Operation.Multiply -> model.multiply(number1, number2)
                Operation.Divide -> model.divide(number1, number2)
            }

            view?.displayResult(result)
        } catch (e: Exception) {
            e.message?.let { view?.displayError(it) }
            return;
        }

        view?.clearInputs()
    }

    override fun onDestroy() {
        view = null
    }
}