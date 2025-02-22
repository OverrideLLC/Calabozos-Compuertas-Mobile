package com.controller.components

import androidx.compose.foundation.gestures.detectHorizontalDragGestures
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
import com.controller.ControllerViewModel
import com.controller.ControllerState
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ControllerComponent(
    viewModel: ControllerViewModel = koinViewModel(),
    navController: NavHostController,
    state: ControllerState,
    swipeToTheLeft: () -> Boolean,
    swipeToTheRight: () -> Boolean,
) {
    val density = LocalDensity.current
    var totalDragHorizontal by remember { mutableStateOf(0f) }
    val thresholdHorizontal = with(density) { 100.dp.toPx() }

    Box(
        modifier = Modifier
            .fillMaxSize()
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