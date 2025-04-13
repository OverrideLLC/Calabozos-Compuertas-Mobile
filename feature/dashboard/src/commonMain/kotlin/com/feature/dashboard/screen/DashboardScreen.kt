package com.feature.dashboard.screen

import androidx.compose.foundation.background
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.feature.dashboard.components.BackgroundAnimated
import com.feature.dashboard.components.Content
import com.feature.dashboard.components.TopBar

@Composable
fun DashboardScreen(navController: NavController) = Screen(navController)

@Composable
private fun Screen(navController: NavController) {
    Scaffold(
        topBar = { TopBar() },
        content = { paddingValues -> Content(navController, paddingValues) },
        containerColor = Color.Transparent,
        modifier = Modifier
            .background(
                brush = BackgroundAnimated(
                    colorPrimary = Color(0xffffffff),
                    colorSecondary = Color(0xffdbdbdb)
                )
            )
    )
}

