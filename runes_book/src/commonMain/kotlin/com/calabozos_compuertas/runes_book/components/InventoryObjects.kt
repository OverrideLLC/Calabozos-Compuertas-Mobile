package com.calabozos_compuertas.runes_book.components

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
import com.calabozos_compuertas.runes_book.screen.RuneViewModel
import com.calabozos_compuertas.runes_book.utils.RunesState
import com.controller.ControllerState
import com.shared.enum.ComparisonOperator
import com.shared.enum.InventoryObject
import com.shared.routes.RoutesRunes

@Composable
fun ObjectInventoryComponent(
    stateController: ControllerState,
    stateRune: RunesState,
    viewModel: RuneViewModel,
    comparator: () -> Unit
) {
    viewModel.update {
        copy(
            comparisonOperator = when (stateController.indexActual) {
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
        visible = stateRune.selectedItems.isNotEmpty(),
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {

            ContentInventory(
                stateController = stateController,
                comparator = comparator,
                stateRune = stateRune
            )
        }
    }
}

@Composable
fun ContentInventory(
    stateController: ControllerState,
    stateRune: RunesState,
    comparator: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .background(if (stateController.isPagComplete) Color.Green.copy(0.3f) else Color.Red.copy(0.3f))
    ) {
        if (stateRune.selectedItems.isNotEmpty() && (stateController.indexActual == 7 || stateController.indexActual == 8)) {
            ComparatorOperatorCommons(
                stateController = stateController,
                comparator = comparator,
                stateRune = stateRune
            )
        } else if (stateRune.selectedItems.isNotEmpty()) {
            OperatorCommon(
                stateController = stateController,
                stateRune = stateRune,
                comparator = comparator
            )
        }
    }
}

@Composable
fun OperatorCommon(
    stateController: ControllerState,
    stateRune: RunesState,
    comparator: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(if (stateController.isPagComplete) Color.Green.copy(0.3f) else Color.Red.copy(0.3f)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(Modifier.weight(1f))
        AsyncImage(
            model = stateRune.selectedItems.first().imageUrl,
            contentDescription = stateRune.selectedItems.first().name,
            modifier = Modifier.size(140.dp).clip(CircleShape)
        )
        Spacer(Modifier.weight(1f))
        if (stateRune.selectedItems.size > 1) {
            comparator()
            AsyncImage(
                model = stateRune.comparisonOperator?.icon ?: ComparisonOperator.AND.icon,
                contentDescription = stateRune.comparisonOperator?.symbol,
                modifier = Modifier.size(140.dp)
            )
            Spacer(Modifier.weight(1f))
            AsyncImage(
                model = stateRune.selectedItems.last().imageUrl,
                contentDescription = stateRune.selectedItems.last().name,
                modifier = Modifier.size(140.dp).clip(CircleShape)
            )
            Spacer(Modifier.weight(1f))
        }
    }
}

@Composable
fun ComparatorOperatorCommons(
    stateController: ControllerState,
    stateRune: RunesState,
    size: Dp = 100.dp,
    comparator: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(if (stateController.isPagComplete) Color.Green.copy(0.3f) else Color.Red.copy(0.3f)),
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
            model = if (stateRune.runeActual.dataRuneNavigation.routeRuneActual == RoutesRunes.Pag8.route) ComparisonOperator.GREATER_EQUAL.icon else ComparisonOperator.GREATER_EQUAL.icon,
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
            model = (if (RoutesRunes.Pag8.route == stateRune.runeActual.dataRuneNavigation.routeRuneActual) ComparisonOperator.AND.icon else ComparisonOperator.OR.icon),
            contentDescription = stateRune.comparisonOperator?.symbol,
            modifier = Modifier.size(size)
        )
        Spacer(Modifier.weight(1f))
        AsyncImage(
            model = (stateRune.selectedItems.first().imageUrl),
            contentDescription = stateRune.selectedItems.first().name,
            modifier = Modifier.size(size).clip(CircleShape)
        )
        Spacer(Modifier.weight(1f))
        AsyncImage(
            model = (ComparisonOperator.EQUAL.icon),
            contentDescription = ComparisonOperator.EQUAL.name,
            modifier = Modifier.size(size)
        )
        if (stateRune.selectedItems.size > 1){
            Spacer(Modifier.weight(1f))
            comparator()
            AsyncImage(
                model = (stateRune.selectedItems.last().imageUrl),
                contentDescription = stateRune.selectedItems.last().name,
                modifier = Modifier.size(size).clip(CircleShape)
            )
        }
        Spacer(Modifier.weight(1f))
    }
}