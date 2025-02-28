package com.logic_book.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
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
import com.logic_book.ui.components.PagGates
import com.logic_book.ui.components.TextLogicGatePag
import com.logic_book.ui.components.TextPag
import com.logic_book.ui.components.TutorialComponent
import com.resources.LottieAnimationCommon
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun LogicGatesScreen(platformContext: PlatformContext) = Screen(platformContext = platformContext)

@Composable
private fun Screen(platformContext: PlatformContext) {
    val viewModelLogicGates = koinViewModel<LogicGatesViewModel>()
    var isLoading by remember { mutableStateOf(true) }
    val state by viewModelLogicGates.state.collectAsState()
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
        Components(
            viewModelLogicGates = viewModelLogicGates,
            state = state,
        )
    }
}

@Composable
private fun Components(
    viewModelLogicGates: LogicGatesViewModel,
    state: LogicGatesData,
) {
    val navController = rememberNavController()
    val controllerViewModel = koinViewModel<ControllerViewModel>()
    val stateController by controllerViewModel.state.collectAsState()
    var intro by remember { mutableStateOf(true) }
    if (stateController.indexActual == 0 && intro) {
        Box(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.background)
                .fillMaxSize(),
            content = {
                TextPag(
                    text = """
        Los rumores eran ciertos en el reino de Itsu. Una cueva más antigua que la tierra misma del hombre existe en las profundidades de la montaña llamada "Sistema", y guarda un tesoro más valioso que todo el oro de los reyes de la tierra. Este lugar es conocido como "Lógica".
        
        Sin embargo, abundan las leyendas sobre la cueva, pues se dice que en su interior reina una terrible oscuridad causada por una maldición inquebrantable. La luz solo puede ser invocada por los más sabios de los Nueve Reinos.
        
        A pesar de haber escuchado las horrendas historias de la cueva de Lógica, dos caballeros de Itsu, llenos de valentía, decidieron templar su espíritu y adentrarse en el gran peligro...
                    """.trimIndent(),
                    onTerminus = { intro = false }
                )
            }
        )
    } else {
        NavControllerLogicGates(
            navController = navController,
            directionNavigation = stateController.directionNavigation,
            illuminate = state.illumiGate
        )
        ControllerComponent(
            swipeToTheLeft = {
                if (stateController.indexActual < state.logicGates.size - 1 && stateController.isPagComplete) {
                    state.logicGates[stateController.indexActual].routeNext.let {
                        navController.popBackStack()
                        navController.navigate(it)
                        viewModelLogicGates.reset()
                        controllerViewModel.update {
                            copy(
                                directionNavigation = true,
                                indexActual = indexActual.plus(1),
                                isPagComplete = false
                            )
                        }
                    }
                }
            },
            swipeToTheRight = {
                if (stateController.indexActual > 0) {
                    state.logicGates[stateController.indexActual].routePrevious.let {
                        navController.popBackStack()
                        navController.navigate(it)
                        controllerViewModel.update {
                            copy(
                                directionNavigation = false,
                                indexActual = indexActual.minus(1)
                            )
                        }
                    }
                }
            },
            swipeToTheUp = {
                println("Swipe to the up")
            },
            swipeToTheDown = {
                viewModelLogicGates.update { copy(isExpanded = true) }
            },
            oneTap = {
                viewModelLogicGates.tapController(
                    stateController = stateController,
                    viewModelController = controllerViewModel,
                    activeWire = true,
                    activeNot = true,
                    activeOr = true,
                    activeAnd = false,
                    activeXor = true,
                    activeLatch = false,
                )
            },
            twoTap = {
                viewModelLogicGates.tapController(
                    stateController = stateController,
                    viewModelController = controllerViewModel,
                    activeWire = false,
                    activeNot = false,
                    activeOr = true,
                    activeAnd = true,
                    activeXor = false,
                    activeLatch = true,
                )
            },
            moreTap = {
                viewModelLogicGates.update {
                    copy(
                        activeWire = false,
                        activeNot = false,
                        activeOr = false,
                        activeAnd = false,
                        activeXor = false,
                        activeLatch = false,
                        illumiGate = !illumiGate
                    )
                }
            },
            onFinish = {
                viewModelLogicGates.reset()
            }
        )
        TutorialComponent(
            stateController = stateController,
            viewModel = controllerViewModel
        )
        TextLogicGatePag(
            images = state.logicGates,
            indexActual = stateController.indexActual
        )
        AnimatedVisibility(
            visible = state.isExpanded && stateController.indexActual < state.logicGatesExpanded.size - 2,
            enter = slideInVertically(),
            exit = slideOutVertically(targetOffsetY = { -it })
        ) {
            PagGates(
                imageGate = state.logicGatesExpanded[stateController.indexActual],
                onClick = { viewModelLogicGates.update { copy(isExpanded = false) } }
            )
        }
    }
}
