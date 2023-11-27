package com.android.calculator

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {
    val result = MutableLiveData<Int>()

    fun onCalculate(operation: String, num1: String, num2: String) {
        val op = Operation.valueOf(operation)
        val number1 = num1.toIntOrNull() ?: 0
        val number2 = num2.toIntOrNull() ?: 0

        val calcResult = when (op) {
            Operation.ADD -> number1 + number2
            Operation.SUB -> number1 - number2
            Operation.MUL -> number1 * number2
            Operation.DIV -> number1 / number2
        }

        result.value = calcResult
    }
}