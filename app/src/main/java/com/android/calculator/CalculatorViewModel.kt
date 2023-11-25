package com.android.calculator

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {
    val result = MutableLiveData<Int>()

    fun add (num1: Int, num2:Int){
        result.value = num1 + num2
    }
    fun sub (num1: Int, num2:Int){
        result.value = num1 - num2
    }
    fun mul (num1: Int, num2:Int){
        result.value = num1 * num2
    }
    fun div (num1: Int, num2:Int){
        result.value = num1 / num2
    }
}