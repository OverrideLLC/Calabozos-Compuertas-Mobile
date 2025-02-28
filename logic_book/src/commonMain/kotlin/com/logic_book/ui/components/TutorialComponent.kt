package com.logic_book.ui.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.controller.ControllerState
import com.controller.ControllerViewModel
import com.resources.Res
import com.resources.swipe_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
import com.resources.swipe_down_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
import com.resources.touch_app_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
import org.jetbrains.compose.resources.painterResource

@Composable
fun TutorialComponent(
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
    var isVisible by remember { mutableStateOf(true) }
    when (stateController.indexActual) {
        0 -> {
            if (isVisible) {
                Tutorial1(animatedOffset, onClick = { isVisible = false })
            } else {
                viewModel.update { copy(isPagComplete = true) }
                Tutorial2()
            }
        }
    }
}

@Composable
fun Tutorial2() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
        content = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(Res.drawable.touch_app_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(70.dp)
                )
                Text(
                    text = "Manten presionado para iluminar",
                    color = Color.White,
                    fontSize = 30.sp
                )
            }
        }
    )
}

@Composable
private fun Tutorial1(
    animatedOffset: State<Float>,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) { detectTapGestures(onTap = { onClick() }) },
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            content = {
                Spacer(modifier = Modifier.weight(1f))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.swipe_down_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier
                            .size(70.dp)
                            .graphicsLayer { translationY = -animatedOffset.value }
                    )
                    Spacer(modifier = Modifier.padding(10.dp))
                    Text(
                        text = "Desplegar la Compuerta logica",
                        color = Color.White,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "Anterior",
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
                Spacer(modifier = Modifier.weight(1f))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.touch_app_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(70.dp)
                    )
                    Spacer(modifier = Modifier.padding(10.dp))
                    Text(
                        text = "Siguiente tip",
                        color = Color.White,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        )
    }
}
