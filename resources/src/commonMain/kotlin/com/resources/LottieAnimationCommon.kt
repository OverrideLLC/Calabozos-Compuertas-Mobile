package com.resources

import KottieAnimation
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import kottieComposition.KottieCompositionSpec
import kottieComposition.animateKottieCompositionAsState
import kottieComposition.rememberKottieComposition
import org.jetbrains.compose.resources.ExperimentalResourceApi
import utils.KottieConstants

@OptIn(ExperimentalResourceApi::class)
@Composable
fun LottieAnimationCommon(
    path: String = "files/Animation_loading.json"
) {
    var animation by remember { mutableStateOf("") }

    // Load animation JSON
    LaunchedEffect(Unit){
        animation = Res.readBytes(path).decodeToString()
    }

    // Create the animation composition
    val composition = rememberKottieComposition(
        spec = KottieCompositionSpec.File(animation)
    )

    // Optionally: Define the animation state so you can control the progress
    val animationState by animateKottieCompositionAsState(
        composition = composition,
        iterations = KottieConstants.IterateForever
    )

    KottieAnimation(
        composition = composition,
        progress = { animationState.progress },
        modifier = Modifier.fillMaxWidth()
    )
}