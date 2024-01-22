@file:OptIn(ExperimentalAnimationApi::class, ExperimentalAnimationApi::class)

package com.example.bmi_calculator.stopwatch

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@ExperimentalAnimationApi
fun addAnimation(duration: Int = 800): ContentTransform {
    return slideInVertically(animationSpec = tween(durationMillis = duration)){height -> height} + fadeIn(
        animationSpec = tween(durationMillis = duration)
    )with
            slideOutVertically(animationSpec = tween(durationMillis = duration)){height -> -height} + fadeOut(
                animationSpec = tween(durationMillis = duration)
            )
}

@ExperimentalAnimationApi
@Composable
fun StopWatchScreen(mainViewModel: MainViewModel)
{
    val seconds by mainViewModel.seconds.collectAsState(initial = "00")

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        AnimatedContent(
            targetState = seconds,
            transitionSpec = {
                addAnimation().using(
                    SizeTransform(clip = true)
                )
            }) {
            targetCount ->
            Text(
                text = "$targetCount",
                style = TextStyle(fontSize = MaterialTheme.typography.bodyMedium.fontSize),
                textAlign = TextAlign.Center
            )
        }

    }


}

@Preview
@Composable
fun stopprev() {

    StopWatchScreen(mainViewModel= MainViewModel())

}