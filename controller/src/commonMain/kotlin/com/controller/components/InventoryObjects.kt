package com.controller.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
import com.controller.ControllerViewModel
import com.controller.ControllerState
import com.shared.enum.ComparisonOperator
import com.shared.enum.InventoryObject
import com.shared.routes.RoutesRunes

@Composable
fun ObjectInventoryComponent(
    state: ControllerState,
    viewModel: ControllerViewModel,
    comparation: () -> Unit
) {
    viewModel.update {
        copy(
            comparisonOperator = when (state.indexActual) {
                2 -> ComparisonOperator.EQUAL
                3 -> ComparisonOperator.LESS_THAN
                4 -> ComparisonOperator.GREATER_EQUAL
                5 -> ComparisonOperator.LESS_EQUAL
                6 -> ComparisonOperator.NOT_EQUAL
                7 -> ComparisonOperator.AND
                8 -> ComparisonOperator.OR
                else -> null
            }
        )
    }
    AnimatedVisibility(
        visible = state.selectedItems.isNotEmpty(),
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            if (state.selectedItems.isNotEmpty()) {
                ContentInventory(
                    state = state,
                    viewModel = viewModel,
                    comparation = comparation
                )
            }
        }
    }
}

@Composable
fun ContentInventory(
    state: ControllerState,
    viewModel: ControllerViewModel,
    comparation: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .background(if (state.isPagComplete) Color.Green.copy(0.3f) else Color.Red.copy(0.3f))
    ) {
        if (state.runeActual.dataRuneNavigation.routeRuneActual == RoutesRunes.Pag8.route || state.runeActual.dataRuneNavigation.routeRuneActual == RoutesRunes.Pag9.route) {
            Spacer(Modifier.weight(1f))
            Image(
                painter = rememberAsyncImagePainter(if (RoutesRunes.Pag8.route == state.runeActual.dataRuneNavigation.routeRuneActual) InventoryObject.NUMBER2.imageUrl else InventoryObject.NUMBER1.imageUrl),
                contentDescription = "",
                modifier = Modifier.size(140.dp).clip(CircleShape)
            )
            Spacer(Modifier.weight(1f))
            Image(
                painter = rememberAsyncImagePainter(InventoryObject.NUMBER0),
                contentDescription = state.comparisonOperator?.symbol,
                modifier = Modifier.size(140.dp)
            )
            Spacer(Modifier.weight(1f))
            Image(
                painter = rememberAsyncImagePainter(InventoryObject.NUMBER1.imageUrl),
                contentDescription = "",
                modifier = Modifier.size(140.dp).clip(CircleShape)
            )
            Spacer(Modifier.weight(1f))
            Image(
                painter = rememberAsyncImagePainter(if (RoutesRunes.Pag8.route == state.runeActual.dataRuneNavigation.routeRuneActual) ComparisonOperator.OR.icon else ComparisonOperator.AND.icon),
                contentDescription = state.comparisonOperator?.symbol,
                modifier = Modifier.size(140.dp)
            )
            Spacer(Modifier.weight(1f))
            Image(
                painter = rememberAsyncImagePainter(state.selectedItems.first().imageUrl),
                contentDescription = state.selectedItems.first().name,
                modifier = Modifier.size(140.dp).clip(CircleShape)
            )
            Spacer(Modifier.weight(1f))
            if (state.selectedItems.size > 1) {
                comparation()
                Image(
                    painter = rememberAsyncImagePainter(ComparisonOperator.AND.icon),
                    contentDescription = state.comparisonOperator?.symbol,
                    modifier = Modifier.size(140.dp)
                )
                Spacer(Modifier.weight(1f))
                Image(
                    painter = rememberAsyncImagePainter(state.selectedItems.last().imageUrl),
                    contentDescription = state.selectedItems.last().name,
                    modifier = Modifier.size(140.dp).clip(CircleShape)
                )
                Spacer(Modifier.weight(1f))
            }
        } else {
            Spacer(Modifier.weight(1f))
            Image(
                painter = rememberAsyncImagePainter(state.selectedItems.first().imageUrl),
                contentDescription = state.selectedItems.first().name,
                modifier = Modifier.size(140.dp).clip(CircleShape)
            )
            Spacer(Modifier.weight(1f))
            if (state.selectedItems.size > 1) {
                comparation()
                Image(
                    painter = rememberAsyncImagePainter(
                        state.comparisonOperator?.icon ?: ComparisonOperator.AND.icon
                    ),
                    contentDescription = state.comparisonOperator?.symbol,
                    modifier = Modifier.size(140.dp)
                )
                Spacer(Modifier.weight(1f))
                Image(
                    painter = rememberAsyncImagePainter(state.selectedItems.last().imageUrl),
                    contentDescription = state.selectedItems.last().name,
                    modifier = Modifier.size(140.dp).clip(CircleShape)
                )
                Spacer(Modifier.weight(1f))
            }
        }
    }
}
