package org.book.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.book.ui.screen.start.StartScreen
import org.book.utils.routes.RoutesStart

@Composable
fun NavigationStart() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = RoutesStart.Start.route) {
        composable(RoutesStart.Start.route) { StartScreen() }
    }
}