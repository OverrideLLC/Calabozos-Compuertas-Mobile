package com.logic_book.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import coil3.PlatformContext
import com.controller.ControllerViewModel
import com.controller.components.ControllerComponent
import com.logic_book.ui.components.NavControllerLogicGates
import com.resources.LottieAnimationCommon
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun LogicGatesScreen(platformContext: PlatformContext) = Screen(platformContext = platformContext)

@Composable
private fun Screen(platformContext: PlatformContext) {
    val viewModelLogicGates = koinViewModel<LogicGatesViewModel>()
    var isLoading by remember { mutableStateOf(true) }
    viewModelLogicGates.preloadImages(
        platformContext = platformContext,
        isComplete = { isLoading = !it }
    )
    if (isLoading) {
        Box(
            modifier = Modifier.background(color = Color.White),
            content = {
                LottieAnimationCommon()
            }
        )
    } else {
        Components(viewModelLogicGates = viewModelLogicGates)
    }
}

@Composable
private fun Components(
    viewModelLogicGates: LogicGatesViewModel,
) {
    val viewModelController = koinViewModel<ControllerViewModel>()
    val stateController by viewModelController.state.collectAsState()
    val stateLogicGates by viewModelLogicGates.state.collectAsState()
    val navController = rememberNavController()

    viewModelController.update { copy(p = "Logic Gates") }


    NavControllerLogicGates(
        navController = navController,
        navigationDirection = stateController.directionNavigation,
    )
    ControllerComponent(
        swipeToTheLeft = {
            println("Swipe to the left")
            if (stateController.indexActual < stateLogicGates.logicGates.size - 1 && stateController.isPagComplete) {
                viewModelController.update { copy(directionNavigation = true) }
                viewModelController.indexPlus()
                viewModelLogicGates.update {
                    println(stateController.indexActual)
                    copy(logicGatesActual = this.logicGates[stateController.indexActual])
                }
                navController.popBackStack()
                navController.navigate(stateLogicGates.logicGatesActual.routeNext)
            }
        },
        swipeToTheRight = {
            println("Swipe to the right")
            if (stateController.indexActual > 0) {
                viewModelController.update { copy(directionNavigation = false) }
                viewModelController.indexMinus()
                viewModelLogicGates.update {
                    println(stateController.indexActual)
                    copy(logicGatesActual = this.logicGates[stateController.indexActual])
                }
                navController.popBackStack()
                navController.navigate(stateLogicGates.logicGatesActual.routePrevious)
            }
        },
        swipeToTheUp = {
            println("Swipe to the up")
        },
        swipeToTheDown = {
            println("Swipe to the down")
        },
    )
}
