package org.book.ui.screen.rune

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.rememberNavController
import coil3.compose.LocalPlatformContext
import org.book.ui.components.pags.ControllerComponent
import org.book.ui.components.pags.InventoryComponent
import org.book.ui.components.pags.TextRune
import org.book.ui.components.pags.TutorialComponent
import org.book.ui.navigation.NavControllerRunes
import org.book.utils.enum.RunesEnum
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun RuneScreen() = Screen()

@Composable
private fun Screen() {
    val viewModel = koinViewModel<RuneViewModel>()
    val navController = rememberNavController()
    val state by viewModel.state.collectAsState()

    viewModel.preloadImages(platformContext = LocalPlatformContext.current)

    NavControllerRunes(
        navController = navController,
        listRune = RunesEnum.entries,
        indexActual = state.indexActual,
        navigationDirection = state.directionNavigation
    )
    ControllerComponent(
        viewModel = viewModel,
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
        viewModel = viewModel,
        comparative = { viewModel.performComparison() }
    )
    TutorialComponent(state = state, viewModel = viewModel)
    TextRune(rune = state.rune, indexActual = state.indexActual)
}
