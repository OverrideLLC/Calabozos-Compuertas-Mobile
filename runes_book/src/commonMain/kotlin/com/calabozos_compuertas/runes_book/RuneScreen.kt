package com.calabozos_compuertas.runes_book

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import coil3.PlatformContext
import com.controller.ControllerViewModel
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
) {
    val viewModel = koinViewModel<RuneViewModel>()
    var isLoading by remember { mutableStateOf(true) }
    viewModel.preloadImages(
        platformContext = platformContext,
        isComplete = { isLoading = !it }
    )
    if (isLoading) {
        Box(
            modifier = Modifier.background(color = Color.White),
            content = {
                LottieAnimationCommon()
            }
        )
    } else {
        Screen(viewModel)
    }
}

@Composable
private fun Screen(viewModel: RuneViewModel) {
    val navController = rememberNavController()
    val controllerViewModel = koinViewModel<ControllerViewModel>()
    val stateController by controllerViewModel.state.collectAsState()

    NavControllerRunes(
        navController = navController,
        listRune = RunesEnum.entries,
        indexActual = stateController.indexActual,
        navigationDirection = stateController.directionNavigation
    )
    ControllerComponent(
        navController = navController,
        state = stateController,
        viewModel = controllerViewModel,
        swipeToTheLeft = {
            if (stateController.indexActual < stateController.rune.size - 1 && stateController.isPagComplete) {
                controllerViewModel.update {
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
            if (stateController.indexActual > 0) {
                controllerViewModel.update {
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
        state = stateController,
        viewModel = controllerViewModel,
        comparative = { viewModel.performComparison() }
    )
    TutorialComponent(state = stateController, controllerViewModel)
    TextRune(rune = stateController.rune, indexActual = stateController.indexActual)
}
