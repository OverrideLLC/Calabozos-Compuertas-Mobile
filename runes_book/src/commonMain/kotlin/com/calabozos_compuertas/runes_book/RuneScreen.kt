package com.calabozos_compuertas.runes_book

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import coil3.PlatformContext
import com.controller.ControllerState
import com.controller.components.ControllerComponent
import com.controller.components.InventoryComponent
import com.controller.components.TextRune
import com.controller.components.TutorialComponent
import com.resources.LottieAnimationCommon
import com.shared.enum.RunesEnum
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun RuneScreen(
    platformContext: PlatformContext,
    viewModel: RuneViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsState()
    viewModel.preloadImages(platformContext)
    Crossfade(
        targetState = state.isLoading,
        content = { f ->
            if (f) {
                Box(
                    modifier = Modifier.background(color = Color.White),
                    content = {
                        LottieAnimationCommon()
                    }
                )
            } else {
                Screen(viewModel, state)
            }
        }
    )
}

@Composable
private fun Screen(viewModel: RuneViewModel, state: ControllerState) {
    val navController = rememberNavController()

    NavControllerRunes(
        navController = navController,
        listRune = RunesEnum.entries,
        indexActual = state.indexActual,
        navigationDirection = state.directionNavigation
    )
    ControllerComponent(
        navController = navController,
        state = state,
        swipeToTheLeft = {
            if (state.indexActual < state.rune.size - 1 && state.isPagComplete) {
                viewModel.update {
                    copy(
                        directionNavigation = true,
                        selectedItems = emptyList(),
                        isPagComplete = false
                    )
                }
                true
            } else {
                false
            }
        },
        swipeToTheRight = {
            if (state.indexActual > 0 && state.isPagComplete) {
                viewModel.update {
                    copy(
                        directionNavigation = false,
                        selectedItems = emptyList(),
                        isPagComplete = false
                    )
                }
                true
            } else {
                false
            }
        }
    )
    InventoryComponent(
        state = state,
        comparative = { viewModel.performComparison() }
    )
    TutorialComponent(state = state)
    TextRune(rune = state.rune, indexActual = state.indexActual)
}
