package org.book.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.book.utils.routes.RoutesRunes

@Composable
fun NavControllerRunes() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = RoutesRunes.Pag1.route,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(RoutesRunes.Pag1.route) {
            Text(
                text = "Página 1",
                color = Color.White,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
        composable(RoutesRunes.Pag2.route) { }
        composable(RoutesRunes.Pag3.route) { }
        composable(RoutesRunes.Pag4.route) { }
        composable(RoutesRunes.Pag5.route) { }
        composable(RoutesRunes.Pag6.route) { }
        composable(RoutesRunes.Pag7.route) { }
        composable(RoutesRunes.Pag8.route) { }
        composable(RoutesRunes.Pag9.route) { }
    }
}