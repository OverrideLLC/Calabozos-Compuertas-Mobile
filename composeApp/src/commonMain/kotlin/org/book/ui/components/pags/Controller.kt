package org.book.ui.components.pags

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
import org.book.ui.screen.rune.RuneViewModel
import org.book.utils.enum.RunesEnum

@Composable
fun Controller(
    swipeLeft: () -> Boolean,
    swipeRight: () -> Boolean,
    runeActual: RunesEnum,
    viewModel: RuneViewModel,
    navController: NavHostController
) {
    var totalDrag by remember { mutableStateOf(0f) }
    val density = LocalDensity.current
    val threshold = with(density) { 100.dp.toPx() } // Umbral en píxeles equivalentes a 100dp

    Box(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectHorizontalDragGestures(
                    onDragStart = {
                        totalDrag = 0f // Reinicia el acumulador al iniciar el gesto
                    },
                    onHorizontalDrag = { change, dragAmount ->
                        change.consume() // Evita interferencias con otros gestos

                        totalDrag += dragAmount // Acumula la distancia horizontal
                    },
                    onDragEnd = {
                        println("DEBUG: totalDrag = $totalDrag || threshold = $threshold") // Debug clave
                        when {
                            totalDrag < threshold -> { // Deslizamiento hacia la izquierda
                                if (swipeLeft()) {
                                    navController.navigate(runeActual.dataRuneNavigation.routeRuneNext)
                                    viewModel.update { copy(indexActual = this.indexActual + 1) }
                                }
                            }

                            totalDrag > threshold -> { // Deslizamiento hacia la derecha
                                if (swipeRight()) {
                                    navController.navigate(runeActual.dataRuneNavigation.routeRunePrevious)
                                    viewModel.update { copy(indexActual = this.indexActual - 1) }
                                    navController.popBackStack()
                                }
                            }
                        }
                        totalDrag = 0f // Reinicia para el próximo gesto
                    }
                )
            }
    )
}