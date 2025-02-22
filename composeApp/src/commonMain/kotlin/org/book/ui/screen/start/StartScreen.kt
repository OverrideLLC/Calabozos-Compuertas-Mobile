package org.book.ui.screen.start

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.resources.Res
import com.resources.graph_1_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
import com.resources.portada_logic
import com.resources.portada_runes
import com.resources.volume_off_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
import com.resources.volume_up_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
import com.shared.routes.RoutesStart
import org.book.ui.components.BackgroundAnimated
import org.book.ui.components.CardBook
import org.book.ui.components.IconCrossfade
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun StartScreen(
    navController: NavController
) = Screen(
    viewModel = koinViewModel(),
    navController = navController
)

@Composable
private fun Screen(viewModel: StartViewModel, navController: NavController) {
    val state by viewModel.state.collectAsState()
    LaunchedEffect(Unit) { viewModel.update { copy(visible = true) } }

    Scaffold(
        containerColor = Color.Transparent,
        modifier = Modifier.background(
            BackgroundAnimated(
                colorScheme.primary,
                colorScheme.background
            )
        ),
        content = { content(navController, state) },
        bottomBar = { Bottom(viewModel, state) }
    )
}

@Composable
private fun content(
    navController: NavController,
    state: StartViewModel.StartState
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        AnimatedVisibility(
            visible = state.visible,
            enter = fadeIn() + slideInHorizontally(
                initialOffsetX = { fullWidth -> -fullWidth / 2 },
                animationSpec = tween(durationMillis = 700, delayMillis = 700)
            ),
            modifier = Modifier.weight(1f)
        ) {
            CardBook(
                image = Res.drawable.portada_runes,
                onClick = { navController.navigate(RoutesStart.RunesBook.route) }
            )
        }
        Spacer(modifier = Modifier.padding(16.dp))

        AnimatedVisibility(
            visible = state.visible,
            enter = fadeIn() + slideInHorizontally(
                initialOffsetX = { fullWidth -> fullWidth / 2 },
                animationSpec = tween(durationMillis = 700, delayMillis = 700)
            ),
            modifier = Modifier.weight(1f)
        ) {
            CardBook(
                image = Res.drawable.portada_logic,
                onClick = { navController.navigate(RoutesStart.LogicBook.route) }
            )
        }
    }
}

@Composable
private fun Bottom(
    viewModel: StartViewModel,
    state: StartViewModel.StartState
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth().padding(16.dp)
    ) {
        IconButton(
            onClick = { viewModel.update { copy(music = !music) } },
            content = {
                IconCrossfade(
                    targetState = state.music,
                    label = "music",
                    iconActual = Res.drawable.volume_up_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24,
                    iconNew = Res.drawable.volume_off_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
                )
            }
        )
        IconButton(
            onClick = {},
            content = {
                Icon(
                    painter = painterResource(Res.drawable.graph_1_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24),
                    contentDescription = "",
                    tint = colorScheme.tertiary
                )
            }
        )
    }
}