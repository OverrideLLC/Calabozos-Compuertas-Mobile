package com.logic_book.ui.components

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
import com.logic_book.utils.enums.ImagesBook
import com.logic_book.utils.routes.RoutesLogic

@Composable
fun NavControllerLogicGates(
    navController: NavHostController,
    directionNavigation: Boolean,
    illuminate: Boolean = false
) {
    NavHost(
        navController = navController,
        startDestination = RoutesLogic.PAG1.route,
        modifier = Modifier.fillMaxSize().background(color = Color.Black),
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { if (directionNavigation) it else -it },
                animationSpec = tween(500)
            ) + fadeIn(animationSpec = tween(3500))
        },
        exitTransition = {
            slideOutHorizontally(
                targetOffsetX = { if (directionNavigation) -it else it },
                animationSpec = tween(500)
            ) + fadeOut(animationSpec = tween(3500))
        }
    ) {
        composable(RoutesLogic.PAG1.route) {
            Pag(
                imageBook = ImagesBook.PAG1,
                illuminate = illuminate
            )
        }
        composable(RoutesLogic.PAG2.route) {
            Pag(
                imageBook = ImagesBook.PAG2,
                illuminate = illuminate
            )
        }
        composable(RoutesLogic.PAG3.route) {
            Pag(
                imageBook = ImagesBook.PAG3,
                illuminate = illuminate
            )
        }
        composable(RoutesLogic.PAG4.route) {
            Pag(
                imageBook = ImagesBook.PAG4,
                illuminate = illuminate
            )
        }
        composable(RoutesLogic.PAG5.route) {
            Pag(
                imageBook = ImagesBook.PAG5,
                illuminate = illuminate
            )
        }
        composable(RoutesLogic.PAG6.route) {
            Pag(
                imageBook = ImagesBook.PAG6,
                illuminate = illuminate
            )
        }
        composable(RoutesLogic.PAG7.route) {
            Pag(
                imageBook = ImagesBook.PAG7,
                illuminate = illuminate
            )
        }
    }
}