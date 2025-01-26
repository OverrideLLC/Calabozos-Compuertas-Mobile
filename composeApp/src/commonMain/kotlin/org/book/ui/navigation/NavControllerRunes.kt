package org.book.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.book.ui.screen.rune.Pag
import org.book.utils.enum.RunesEnum
import org.book.utils.routes.RoutesRunes

@Composable
fun NavControllerRunes() {
    val navController = rememberNavController()
    val listRune = RunesEnum.entries
    NavHost(
        navController = navController,
        startDestination = RoutesRunes.Pag1.route,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(RoutesRunes.Pag1.route) {
            Pag(dataRune = listRune[0])
        }
        composable(RoutesRunes.Pag2.route) {
            Pag(dataRune = listRune[1])
        }
        composable(RoutesRunes.Pag3.route) {
            Pag(dataRune = listRune[2])
        }
        composable(RoutesRunes.Pag4.route) {
            Pag(dataRune = listRune[3])
        }
        composable(RoutesRunes.Pag5.route) {
            Pag(dataRune = listRune[4])
        }
        composable(RoutesRunes.Pag6.route) {
            Pag(dataRune = listRune[5])
        }
        composable(RoutesRunes.Pag7.route) {
            Pag(dataRune = listRune[6])
        }
        composable(RoutesRunes.Pag8.route) {
            Pag(dataRune = listRune[7])
        }
        composable(RoutesRunes.Pag9.route) {
            Pag(dataRune = listRune[8])
        }
        composable(RoutesRunes.Pag10.route) {
            Pag(dataRune = listRune[9])
        }
    }
}