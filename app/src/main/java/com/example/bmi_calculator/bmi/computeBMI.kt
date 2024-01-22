package com.example.bmi_calculator.bmi

import androidx.compose.runtime.Composable
import kotlin.math.pow

//BMI computation Logic
//@Composable
fun computeBMI(height: String, weight: String): Float {

    //EU METRICS FORMULA
    val calculation: Float
    val w = weight.toFloat()
    val h = height.toFloat() /100
    calculation = (w / h.pow(2))
    return calculation

}
