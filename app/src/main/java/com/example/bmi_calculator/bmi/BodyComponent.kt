package com.example.bmi_calculator.bmi

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bmi_calculator.ui.theme.White


@Composable
fun Body() {
    
   //Marked all the changing parts of the app with mutable states
    var height by remember{ mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var classification by remember { mutableStateOf(" ") }
    var calculation by remember { mutableStateOf(0.0f) }
    var progress by remember { mutableStateOf(0.0f) }
    var classificationColor by remember { mutableStateOf(Color.White) }
    
    Column (
        Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Calculate BMI",
            color = Color.Green,
            fontSize = 32.sp,
            fontWeight = FontWeight.Medium,
            )
        Text(
            text = "EU Metrics",
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            )
        //custom TextField Component
        TextFieldComponent(
            inputValue = height,
            metric = "cm",
            label = "Height" ,
            onValueChange = {
                height = it
                if(height.isEmpty() || weight.isEmpty()){
                    classification = " "
                    calculation = 0f
                    progress = 0f
                }
                else {
                    calculation = computeBMI(height = height, weight = weight)
                    calculation = computeBMI(height = height, weight = weight)
                    classification = classifyBMI(calculation)
                    progress = getProgress(calculation)
                    classificationColor = getClassificationColor(calculation)
                }
            })
        TextFieldComponent(
            inputValue = weight ,
            metric = "kg",
            label = "weight",
            onValueChange = {
                weight = it
                if (height.isEmpty() || weight.isEmpty()){
                    classification = ""
                    calculation = 0f
                    progress = 0f
                }
                else {
                    calculation = computeBMI(height, weight)
                    classification = classifyBMI(calculation)
                    progress = getProgress(calculation)
                    classificationColor = getClassificationColor(calculation)
                }
            })
        Box (
            Modifier.padding(vertical = 16.dp), contentAlignment = Alignment.Center
        ) {
            Text(
                text = classification,
                color = classificationColor,
                fontSize = 32.sp,
                fontWeight = FontWeight.Medium
            )
        }
        //Circular Progress bar with text in the center Custom Box

        Box (
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 64.dp)
                .size(250.dp),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = String.format("%.2f", calculation),// Format Result
                color = White,
                fontSize = 64.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Medium,
            )
            CircularProgressIndicator(
                progress = progress,
                color = classificationColor,
                strokeWidth = 16.dp,
                modifier = Modifier.fillMaxSize()

            )
        }
        
    }
    
}

@Preview
@Composable
fun PrevBody() {

    Body()
    
}