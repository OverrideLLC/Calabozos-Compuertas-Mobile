package org.book.ui.screen.rune

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.book.ui.components.pags.Controller
import org.book.ui.components.pags.Inventory
import org.book.ui.components.pags.TextRune
import org.book.ui.components.pags.Tutorial
import org.book.ui.navigation.NavControllerRunes
import org.book.utils.data.RuneState
import org.book.utils.enum.RunesEnum
import org.jetbrains.compose.resources.painterResource
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
        swipeLeft = {
            viewModel.update {
                copy(
                    directionNavigation = true,
                    selectedItems = emptySet(),
                    isPagComplete = false
                )
            }
            state.indexActual < state.rune.size - 1
        },
        swipeRight = {
            val aux = state.isPagComplete
            viewModel.update {
                copy(
                    directionNavigation = true,
                    selectedItems = emptySet(),
                    isPagComplete = false
                )
            }
            state.indexActual > 0 && aux
        },
    )

    Content(
        navController = navController,
        rune = state.rune,
        indexActual = state.indexActual,
        directionNavigation = state.directionNavigation
    )

    if (state.rune[state.indexActual] == RunesEnum.entries[1] && state.rune[state.indexActual] >= RunesEnum.entries[3]) {
        ObjectInventory(
            state = state,
            viewModel = viewModel
        )
    }
    if (state.rune[state.indexActual] == RunesEnum.entries[2]){
        ObjectInventory(
            state = state,
            viewModel = viewModel
        )
    }

    AnimatedVisibility(
        visible = state.rune[state.indexActual] >= RunesEnum.entries[1],
        enter = slideInVertically(
            initialOffsetY = { it },
            animationSpec = tween(durationMillis = 300)
        ),
        exit = slideOutVertically(
            targetOffsetY = { it },
            animationSpec = tween(durationMillis = 300)
        )
    ) {
        Inventory(
            runeState = state,
            onItemSelected = { viewModel.toggleSelection(it) },
            isClick = {
                if (state.rune[state.indexActual] == RunesEnum.entries[1]) {
                    viewModel.update { copy(isClicked = true) }
                }
            }
        )
    }

    when {
        state.rune[state.indexActual] == RunesEnum.entries[0] -> Tutorial(1)
        state.rune[state.indexActual] == RunesEnum.entries[1] && !state.isClicked -> Tutorial(2)
    }

    TextRune(
        rune = state.rune,
        indexActual = state.indexActual
    )

    if (state.selectedItems.isNotEmpty()) {
        viewModel.update { copy(isSelectedRune = true) }
    } else {
        viewModel.update { copy(isSelectedRune = false) }
    }
}

@Composable
private fun ObjectInventory(state: RuneState, viewModel: RuneViewModel) {
    viewModel.update {
        copy(
            comparison = when (state.indexActual) {
                2 -> "=="
                3 -> "<"
                4 -> ">="
                5 -> "<="
                6 -> "!="
                7 -> "||"
                8 -> "&&"
                else -> ""
            }
        )
    }

    val comparison = viewModel.comparison()
    val colorComparison = if (comparison) Color.Green else Color.Red
    viewModel.update { copy(isPagComplete = comparison) }

    AnimatedVisibility(
        visible = state.selectedItems.isNotEmpty()
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            ContentInventory(
                state = state,
                colorComparison = colorComparison
            )
        }
    }
}

@Composable
private fun ContentInventory(
    state: RuneState,
    colorComparison: Color
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(Modifier.weight(1f))
        Icon(
            painter = painterResource(state.selectedItems.first().image),
            contentDescription = state.selectedItems.first().form,
            tint = colorComparison,
            modifier = Modifier.size(50.dp)
        )
        Spacer(Modifier.weight(1f))
        if (state.selectedItems.size > 1) {
            Text(
                text = state.comparison,
                color = colorComparison,
                fontWeight = FontWeight.Bold,
                fontSize = 50.sp,
            )
            Spacer(Modifier.weight(1f))
            Icon(
                painter = painterResource(state.selectedItems.last().image),
                contentDescription = state.selectedItems.last().form,
                tint = colorComparison,
                modifier = Modifier.size(50.dp)
            )
            Spacer(Modifier.weight(1f))
        }
    }
}


@Composable
private fun Content(
    navController: NavHostController,
    rune: List<RunesEnum>,
    indexActual: Int,
    directionNavigation: Boolean
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorScheme.background),
        contentAlignment = Alignment.Center,
        content = {
            NavControllerRunes(
                navController = navController,
                listRune = rune,
                indexActual = indexActual,
                navigationDirection = directionNavigation
            )
        }
    )
}