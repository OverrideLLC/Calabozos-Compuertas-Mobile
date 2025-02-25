package com.controller.components

import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp

@Composable
fun ControllerComponent(
    swipeToTheLeft: () -> Unit = {},
    swipeToTheRight: () -> Unit = {},
    swipeToTheUp: () -> Unit = {},
    swipeToTheDown: () -> Unit = {},
    oneTap: () -> Unit = {},
    twoTap: () -> Unit = {},
    moreTap: () -> Unit = {},
    onFinish: () -> Unit = {},
) {
    val density = LocalDensity.current
    var totalDragHorizontal by remember { mutableStateOf(0f) }
    val thresholdHorizontal = with(density) { 100.dp.toPx() }
    var totalDragVertical by remember { mutableStateOf(0f) }
    val thresholdVertical = with(density) { 100.dp.toPx() }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectVerticalDragGestures(
                    onDragStart = { totalDragVertical = 0f },
                    onVerticalDrag = { change, dragAmount ->
                        change.consume()
                        totalDragVertical += dragAmount
                    },
                    onDragEnd = {
                        when {
                            // Swipe hacia arriba (desplazamiento negativo supera el umbral)
                            totalDragVertical < -thresholdVertical -> {
                                swipeToTheUp()
                            }
                            // Opcional: Swipe hacia abajo si es necesario
                            totalDragVertical > thresholdVertical -> {
                                swipeToTheDown()
                            }
                        }
                        totalDragVertical = 0f
                    }
                )
            }
            .pointerInput(Unit) {
                detectHorizontalDragGestures(
                    onDragStart = { totalDragHorizontal = 0f },
                    onHorizontalDrag = { change, dragAmount ->
                        change.consume()
                        totalDragHorizontal += dragAmount
                    },
                    onDragEnd = {
                        when {
                            totalDragHorizontal < thresholdHorizontal -> {
                                swipeToTheLeft()
                            }

                            totalDragHorizontal > thresholdHorizontal -> {
                                swipeToTheRight()
                            }
                        }
                        totalDragHorizontal = 0f
                    }
                )
            }
            .pointerInput(Unit) {
                awaitPointerEventScope {
                    while (true) {
                        val event = awaitPointerEvent()
                        val pointers = event.changes
                        when (pointers.size) {
                            1 -> {
                                oneTap()
                            }

                            2 -> {
                                twoTap()
                            }

                            else -> {
                                moreTap()
                            }
                        }
                    }
                }
            }
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        tryAwaitRelease()
                        onFinish()
                    }
                )
            }
    )
}