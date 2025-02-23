package com.controller.components

import androidx.compose.foundation.gestures.detectHorizontalDragGestures
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
import androidx.navigation.NavHostController
import com.controller.ControllerState
import com.controller.ControllerViewModel

@Composable
fun ControllerComponent(
    viewModel: ControllerViewModel,
    navController: NavHostController,
    state: ControllerState,
    swipeToTheLeft: () -> Boolean,
    swipeToTheRight: () -> Boolean,
    swipeToTheUp: () -> Unit,
    swipeToTheDown: () -> Unit,
) {
    val density = LocalDensity.current
    var totalDragHorizontal by remember { mutableStateOf(0f) }
    val thresholdHorizontal = with(density) { 100.dp.toPx() }
    var totalDragVertical by remember { mutableStateOf(0f) }
    val thresholdVertical = with(density) { 200.dp.toPx() }

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
                                if (swipeToTheLeft()) {
                                    viewModel.update {
                                        copy(
                                            indexActual = indexActual + 1,
                                            runeActual = rune[indexActual + 1]
                                        )
                                    }
                                    navController.popBackStack()
                                    navController.navigate(state.runeActual.dataRuneNavigation.routeRuneNext)
                                }
                            }

                            totalDragHorizontal > thresholdHorizontal -> {
                                if (swipeToTheRight()) {
                                    viewModel.update {
                                        copy(
                                            indexActual = indexActual - 1,
                                            runeActual = rune[indexActual - 1]
                                        )
                                    }
                                    navController.popBackStack()
                                    navController.navigate(state.runeActual.dataRuneNavigation.routeRunePrevious)
                                }
                            }
                        }
                        totalDragHorizontal = 0f
                    }
                )
            }
    )
}