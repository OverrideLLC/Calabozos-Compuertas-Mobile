package com.calabozos_compuertas.runes_book.screen

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
import com.calabozos_compuertas.runes_book.components.InventoryComponent
import com.calabozos_compuertas.runes_book.components.NavControllerRunes
import com.calabozos_compuertas.runes_book.components.TextRune
import com.calabozos_compuertas.runes_book.components.TutorialComponent
import com.calabozos_compuertas.runes_book.utils.RunesState
import com.controller.ControllerViewModel
import com.controller.components.ControllerComponent
import com.resources.LottieAnimationCommon
import com.shared.enum.RunesEnum
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun RuneScreen(
    platformContext: PlatformContext,
) {
    val viewModel = koinViewModel<RuneViewModel>()
    var isLoading by remember { mutableStateOf(true) }
    val state by viewModel.state.collectAsState()
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
        Screen(viewModel, state)
    }
}

@Composable
private fun Screen(viewModel: RuneViewModel, stateRune: RunesState) {
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
        viewModel = controllerViewModel,
        swipeToTheLeft = {
            println("Swipe to the left")
            if (stateController.indexActual < stateRune.rune.size - 1 && stateController.isPagComplete) {
                controllerViewModel.update {
                    copy(
                        directionNavigation = true,
                        isPagComplete = false,
                    )
                }
                viewModel.update {
                    copy(
                        selectedItems = emptyList(),
                        runeActual = rune[stateController.indexActual]
                    )
                }
                true
            } else {
                false
            }
        },
        swipeToTheRight = {
            println("Swipe to the right")
            if (stateController.indexActual > 0) {
                controllerViewModel.update {
                    copy(
                        directionNavigation = false,
                        isPagComplete = false,
                    )
                }
                viewModel.update {
                    copy(
                        selectedItems = emptyList(),
                        runeActual = rune[stateController.indexActual],
                    )
                }
                true
            } else {
                false
            }
        },
        swipeToTheUp = {
            println("Swipe to the up")
            viewModel.update { copy(isExpandedInventory = true) }
        },
        swipeToTheDown = {
            println("Swipe to the down")
            viewModel.update { copy(isExpandedInventory = false) }
        },
        nav = {
            println("Nav")
            if (it == "left") {
                navController.popBackStack()
                navController.navigate(stateRune.runeActual.dataRuneNavigation.routeRuneNext)
            } else {
                navController.popBackStack()
                navController.navigate(stateRune.runeActual.dataRuneNavigation.routeRunePrevious)
            }
        }
    )
    InventoryComponent(
        stateRune = stateRune,
        viewModel = viewModel,
        stateController = stateController,
        comparative = {
            viewModel.performComparison().also {
                controllerViewModel.update { copy(isPagComplete = it) }
            }
        }
    )
    TutorialComponent(
        stateRune = stateRune,
        stateController = stateController,
        viewModel = controllerViewModel
    )
    TextRune(rune = stateRune.rune, indexActual = stateController.indexActual)
}
