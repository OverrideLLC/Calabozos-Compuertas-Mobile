package com.calabozos_compuertas.runes_book.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.calabozos_compuertas.runes_book.utils.RunesState
import com.controller.ControllerViewModel
import com.controller.ControllerState
import com.resources.Res
import com.resources.swipe_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
import com.resources.swipe_down_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
import com.resources.swipe_up_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
import com.resources.touch_app_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
import org.jetbrains.compose.resources.painterResource

@Composable
fun TutorialComponent(
    stateRune: RunesState,
    stateController: ControllerState,
    viewModel: ControllerViewModel
) {
    val density = LocalDensity.current
    val offsetDp = 10.dp
    val offsetPx = remember { with(density) { offsetDp.toPx() } }
    val infiniteTransition = rememberInfiniteTransition()
    val animatedOffset = infiniteTransition.animateFloat(
        initialValue = -offsetPx,
        targetValue = offsetPx,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    when (stateController.indexActual) {
        0 -> {
            viewModel.update { copy(isPagComplete = true) }
            Tutorial1(animatedOffset)
        }

        1 -> if (stateRune.isExpandedInventory) {
            viewModel.update { copy(isPagComplete = true) }
            Tutorial2_1(animatedOffset)
        } else if (!stateController.isPagComplete){
            Tutorial2(animatedOffset)
        }
    }
}

@Composable
private fun Tutorial1(animatedOffset: State<Float>) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Atras",
                color = Color.White,
                fontSize = 30.sp,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                painter = painterResource(Res.drawable.swipe_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .size(70.dp)
                    .graphicsLayer {
                        translationX = animatedOffset.value
                    }
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Siguiente",
                color = Color.White,
                fontSize = 30.sp,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Composable
private fun Tutorial2(animatedOffset: State<Float>) {
    Box(
        modifier = Modifier.fillMaxSize().padding(bottom = 15.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Icon(
            painter = painterResource(Res.drawable.swipe_up_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .size(70.dp)
                .graphicsLayer { translationY = animatedOffset.value }
        )
    }
}

@Composable
private fun Tutorial2_1(animatedOffset: State<Float>) {
    Box(
        modifier = Modifier.fillMaxSize().padding(bottom = 15.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Icon(
            painter = painterResource(Res.drawable.swipe_down_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .size(70.dp)
                .graphicsLayer { translationY = -animatedOffset.value }
        )
    }
}

