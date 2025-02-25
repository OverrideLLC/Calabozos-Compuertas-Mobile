package com.calabozos_compuertas.runes_book.components

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.shared.enum.RunesEnum
import com.shared.routes.RoutesRunes

@Composable
fun NavControllerRunes(
    navController: NavHostController,
    listRune: List<RunesEnum>,
    indexActual: Int,
    navigationDirection: Boolean
) {
    NavHost(
        navController = navController,
        startDestination = RoutesRunes.Pag1.route,
        modifier = Modifier.fillMaxSize().background(Color.Black),
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = {
                    if (navigationDirection) {
                        it
                    } else {
                        -it
                    }
                },
                animationSpec = tween(500)
            ) + fadeIn(animationSpec = tween(3500))
        },
        exitTransition = {
            slideOutHorizontally(
                targetOffsetX = {
                    if (navigationDirection) -it else it
                },
                animationSpec = tween(500)
            ) + fadeOut(animationSpec = tween(3500))
        }
    ) {
        composable(RoutesRunes.Pag1.route) { Pag(dataRune = listRune[indexActual]) }
        composable(RoutesRunes.Pag2.route) { Pag(dataRune = listRune[indexActual]) }
        composable(RoutesRunes.Pag3.route) { Pag(dataRune = listRune[indexActual]) }
        composable(RoutesRunes.Pag4.route) { Pag(dataRune = listRune[indexActual]) }
        composable(RoutesRunes.Pag5.route) { Pag(dataRune = listRune[indexActual]) }
        composable(RoutesRunes.Pag6.route) { Pag(dataRune = listRune[indexActual]) }
        composable(RoutesRunes.Pag7.route) { Pag(dataRune = listRune[indexActual]) }
        composable(RoutesRunes.Pag8.route) { Pag(dataRune = listRune[indexActual]) }
        composable(RoutesRunes.Pag9.route) { Pag(dataRune = listRune[indexActual]) }
        composable(RoutesRunes.Pag10.route) { Pag(dataRune = listRune[indexActual]) }
    }
}

