package com.feature.dashboard.screen

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.feature.dashboard.components.BottomBar
import com.feature.dashboard.components.Content
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun DashboardRoot(viewModel: DashboardViewModel = koinViewModel()) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    DashboardScreen(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
internal fun DashboardScreen(
    state: DashboardState,
    onAction: (DashboardAction) -> Unit,
) {
    Scaffold(
        content = { Content() },
        bottomBar = { BottomBar() }
    )
}