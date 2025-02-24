package org.book.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil3.PlatformContext
import coil3.compose.LocalPlatformContext
import com.calabozos_compuertas.runes_book.screen.RuneScreen
import com.logic_book.ui.LogicGatesScreen
import com.shared.routes.RoutesStart
import org.book.ui.screen.start.StartScreen

@Composable
fun NavigationStart(context: PlatformContext) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = RoutesStart.Start.route,
    ) {
        composable(RoutesStart.Start.route) { StartScreen(navController) }
        composable(RoutesStart.RunesBook.route) { RuneScreen(context) }
        composable(RoutesStart.LogicBook.route) { LogicGatesScreen(context) }
    }
}