package org.book.ui.screen.rune

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.rememberNavController
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
private fun Screen(viewModel: RuneViewModel = koinViewModel()) {
    val navController = rememberNavController()
    val state by viewModel.state.collectAsState()

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
    )
    InventoryComponent(
        state = state,
        viewModel = viewModel
    )
    TutorialComponent(
        state = state,
        viewModel = viewModel
    )
    TextRune(
        rune = state.rune,
        indexActual = state.indexActual
    )
}
