package org.book.ui.screen.rune

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.book.ui.components.pags.Controller
import org.book.ui.components.pags.TextRune
import org.book.ui.navigation.NavControllerRunes
import org.book.utils.enum.RunesEnum
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun RuneScreen() = Screen()

@Composable
private fun Screen(viewModel: RuneViewModel = koinViewModel()) {
    val navController = rememberNavController()
    val state by viewModel.state.collectAsState()
    Controller(
        viewModel = viewModel,
        navController = navController,
        runeActual = state.rune[state.indexActual],
        swipeLeft = { state.indexActual < state.rune.size - 1 },
        swipeRight = { state.indexActual > 0 }
    )
    Content(
        navController = navController,
        rune = state.rune,
        indexActual = state.indexActual
    )
    TextRune(
        rune = state.rune,
        indexActual = state.indexActual
    )
}

@Composable
private fun Content(navController: NavHostController, rune: List<RunesEnum>, indexActual: Int) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorScheme.background),
        contentAlignment = Alignment.Center,
        content = { NavControllerRunes(navController, rune, indexActual) },
    )
}