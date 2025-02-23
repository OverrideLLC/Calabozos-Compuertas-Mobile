package com.controller.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.compose.rememberAsyncImagePainter
import com.controller.ControllerState
import com.controller.ControllerViewModel
import com.shared.enum.ComparisonOperator
import com.shared.enum.InventoryObject
import com.shared.routes.RoutesRunes

@Composable
fun ObjectInventoryComponent(
    state: ControllerState,
    viewModel: ControllerViewModel,
    comparator: () -> Unit
) {
    viewModel.update {
        copy(
            comparisonOperator = when (state.indexActual) {
                2 -> ComparisonOperator.EQUAL
                3 -> ComparisonOperator.LESS_THAN
                4 -> ComparisonOperator.GREATER_EQUAL
                5 -> ComparisonOperator.LESS_EQUAL
                6 -> ComparisonOperator.NOT_EQUAL
                7 -> ComparisonOperator.OR
                8 -> ComparisonOperator.AND
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

            ContentInventory(state = state, comparator = comparator)
        }
    }
}

@Composable
fun ContentInventory(
    state: ControllerState,
    comparator: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .background(if (state.isPagComplete) Color.Green.copy(0.3f) else Color.Red.copy(0.3f))
    ) {
        if (state.selectedItems.isNotEmpty() && (state.runeActual.dataRuneNavigation.routeRuneActual == RoutesRunes.Pag8.route || state.runeActual.dataRuneNavigation.routeRuneActual == RoutesRunes.Pag9.route)) {
            ComparatorOperatorCommons(state = state, comparator = comparator)
        } else if (state.selectedItems.isNotEmpty()) {
            OperatorCommon(
                state = state,
                comparator = comparator
            )
        }
    }
}

@Composable
fun OperatorCommon(
    state: ControllerState,
    comparator: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(if (state.isPagComplete) Color.Green.copy(0.3f) else Color.Red.copy(0.3f)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(Modifier.weight(1f))
        AsyncImage(
            model = state.selectedItems.first().imageUrl,
            contentDescription = state.selectedItems.first().name,
            modifier = Modifier.size(140.dp).clip(CircleShape)
        )
        Spacer(Modifier.weight(1f))
        if (state.selectedItems.size > 1) {
            comparator()
            AsyncImage(
                model = state.comparisonOperator?.icon ?: ComparisonOperator.AND.icon,
                contentDescription = state.comparisonOperator?.symbol,
                modifier = Modifier.size(140.dp)
            )
            Spacer(Modifier.weight(1f))
            AsyncImage(
                model = state.selectedItems.last().imageUrl,
                contentDescription = state.selectedItems.last().name,
                modifier = Modifier.size(140.dp).clip(CircleShape)
            )
            Spacer(Modifier.weight(1f))
        }
    }
}

@Composable
fun ComparatorOperatorCommons(
    state: ControllerState,
    size: Dp = 100.dp,
    comparator: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(if (state.isPagComplete) Color.Green.copy(0.3f) else Color.Red.copy(0.3f)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(Modifier.weight(1f))
        AsyncImage(
            model = InventoryObject.NUMBER2.imageUrl,
            contentDescription = InventoryObject.NUMBER2.name,
            modifier = Modifier.size(size).clip(CircleShape)
        )
        Spacer(Modifier.weight(1f))
        AsyncImage(
            model = if (state.runeActual.dataRuneNavigation.routeRuneActual == RoutesRunes.Pag8.route) ComparisonOperator.GREATER_EQUAL.icon else ComparisonOperator.GREATER_EQUAL.icon,
            contentDescription = ComparisonOperator.LESS_THAN.name,
            modifier = Modifier.size(size)
        )
        Spacer(Modifier.weight(1f))
        AsyncImage(
            model = InventoryObject.NUMBER1.imageUrl,
            contentDescription = InventoryObject.NUMBER1.imageUrl,
            modifier = Modifier.size(size).clip(CircleShape)
        )
        Spacer(Modifier.weight(1f))
        AsyncImage(
            model = (if (RoutesRunes.Pag8.route == state.runeActual.dataRuneNavigation.routeRuneActual) ComparisonOperator.OR.icon else ComparisonOperator.AND.icon),
            contentDescription = state.comparisonOperator?.symbol,
            modifier = Modifier.size(size)
        )
        Spacer(Modifier.weight(1f))
        AsyncImage(
            model = (state.selectedItems.first().imageUrl),
            contentDescription = state.selectedItems.first().name,
            modifier = Modifier.size(size).clip(CircleShape)
        )
        Spacer(Modifier.weight(1f))
        AsyncImage(
            model = (ComparisonOperator.EQUAL.icon),
            contentDescription = ComparisonOperator.EQUAL.name,
            modifier = Modifier.size(size)
        )
        if (state.selectedItems.size > 1){
            Spacer(Modifier.weight(1f))
            comparator()
            AsyncImage(
                model = (state.selectedItems.last().imageUrl),
                contentDescription = state.selectedItems.last().name,
                modifier = Modifier.size(size).clip(CircleShape)
            )
        }
        Spacer(Modifier.weight(1f))
    }
}