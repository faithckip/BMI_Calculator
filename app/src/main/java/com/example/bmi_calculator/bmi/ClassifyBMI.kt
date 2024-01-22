package com.example.bmi_calculator.bmi

import androidx.compose.ui.graphics.Color
import com.example.bmi_calculator.ui.theme.Blue
import com.example.bmi_calculator.ui.theme.DarkRed
import com.example.bmi_calculator.ui.theme.Green
import com.example.bmi_calculator.ui.theme.Red
import com.example.bmi_calculator.ui.theme.White

//Logic Function to categorize weight Computation
fun classifyBMI(
    calculation: Float
): String{
    var classification = ""
    if (calculation < 18.5){
        classification = "Underweight"
    }
    else if (calculation >= 18.5 && calculation < 24.9){
        classification = "Healthy"
    }
    else if (calculation >= 24.9 && calculation < 30){
        classification = " Overweight"
    }
    else if (calculation >= 30){
        classification = " Suffering from Obesity"
    }
    return classification
}

fun getProgress(calculation: Float): Float{
    var progress = 0f
    if (calculation < 18.5){
        progress = .1f
    }
    else if (calculation >= 18.5 && calculation < 24.9){
        progress = .5f
    }
    else if (calculation >= 24.9 && calculation < 30){
        progress = .75f
    }
    else if (calculation >= 30){
        progress = 1f
    }
    return progress
}

fun getClassificationColor(
    calculation: Float
): Color{
    var classificationColor = White
    if (calculation < 18.5){
        classificationColor = Blue
    }
    else if (calculation >= 18.5 && calculation < 24.9){
        classificationColor = Green
    }
    else if (calculation >= 24.9 && calculation < 30){
        classificationColor = DarkRed
    }
    else if (calculation >= 30){
        classificationColor = Red
    }

    return classificationColor
}