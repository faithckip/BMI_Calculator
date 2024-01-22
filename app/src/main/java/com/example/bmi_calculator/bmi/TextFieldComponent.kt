package com.example.bmi_calculator.bmi

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldComponent(
    inputValue: String,
    metric: String,
    label: String,
    onValueChange: (String) -> Unit
) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center
    ){
        //Logic if either weight or height value is changed
        TextField(
            value =inputValue ,
            onValueChange = onValueChange,
            label = { Text(text = "label", color= Color.White)},
            //keyboardOptions = KeyboardOptions(keyboardType = keyboardType.Number ),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Green,
                unfocusedIndicatorColor = White,
                textColor = Green
            ),
            )
        Text(
            text = metric,
            Modifier.padding(horizontal = 8.dp),
            color = White)

    }

}