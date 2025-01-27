package org.book.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.book.ui.components.pags.Pag
import org.book.utils.enum.RunesEnum
import org.book.utils.routes.RoutesRunes

@Composable
fun NavControllerRunes(
    navController: NavHostController,
    listRune: List<RunesEnum>,
    indexActual: Int
) {
    NavHost(
        navController = navController,
        startDestination = RoutesRunes.Pag1.route,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(RoutesRunes.Pag1.route) {
            Pag(dataRune = listRune[indexActual])
        }
        composable(RoutesRunes.Pag2.route) {
            Pag(dataRune = listRune[indexActual])
        }
        composable(RoutesRunes.Pag3.route) {
            Pag(dataRune = listRune[indexActual])
        }
        composable(RoutesRunes.Pag4.route) {
            Pag(dataRune = listRune[indexActual])
        }
        composable(RoutesRunes.Pag5.route) {
            Pag(dataRune = listRune[indexActual])
        }
        composable(RoutesRunes.Pag6.route) {
            Pag(dataRune = listRune[indexActual])
        }
        composable(RoutesRunes.Pag7.route) {
            Pag(dataRune = listRune[indexActual])
        }
        composable(RoutesRunes.Pag8.route) {
            Pag(dataRune = listRune[indexActual])
        }
        composable(RoutesRunes.Pag9.route) {
            Pag(dataRune = listRune[indexActual])
        }
        composable(RoutesRunes.Pag10.route) {
            Pag(dataRune = listRune[indexActual])
        }
    }
}