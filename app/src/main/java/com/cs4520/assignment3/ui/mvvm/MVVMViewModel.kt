package com.cs4520.assignment3.ui.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cs4520.assignment3.ui.Operation

class MVVMViewModel: ViewModel() {
    val result = MutableLiveData<Int?>()
    val error = MutableLiveData<String?>()

    fun operate(number1: Int, number2: Int, operation: Operation) {
        try {
            result.value = when(operation) {
                Operation.Add -> number1 + number2
                Operation.Subtract -> number1 - number2
                Operation.Multiply-> number1 * number2
                Operation.Divide-> number1 / number2
            }
            error.value = null
        } catch (e: Exception) {
            result.value = null
            error.value = e.message.toString()
        }
    }
}