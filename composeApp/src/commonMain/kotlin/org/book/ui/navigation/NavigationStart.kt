package org.book.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.book.ui.screen.rune.RuneScreen
import org.book.ui.screen.start.StartScreen
import org.book.utils.routes.RoutesStart

@Composable
fun NavigationStart() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = RoutesStart.Start.route,
    ) {
        composable(RoutesStart.Start.route) { StartScreen(navController) }
        composable(RoutesStart.RunesBook.route) { RuneScreen() }
        composable(RoutesStart.LogicBook.route) {
            Box(
                modifier = Modifier.fillMaxSize().background(colorScheme.background),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Coming soon...",
                    color = colorScheme.tertiary,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp
                )
            }
        }
    }
}