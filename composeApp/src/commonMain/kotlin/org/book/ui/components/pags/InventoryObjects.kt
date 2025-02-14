package org.book.ui.components.pags

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
import book.composeapp.generated.resources.NUMERO1
import book.composeapp.generated.resources.NUMERO2
import book.composeapp.generated.resources.RUNAAND
import book.composeapp.generated.resources.RUNAIGUALDAD
import book.composeapp.generated.resources.RUNAOR
import book.composeapp.generated.resources.Res
import org.book.ui.screen.rune.RuneViewModel
import org.book.utils.data.RuneState
import org.book.utils.enum.ComparisonOperator
import org.book.utils.routes.RoutesRunes
import org.jetbrains.compose.resources.painterResource

@Composable
fun ObjectInventoryComponent(state: RuneState, viewModel: RuneViewModel, comparation: () -> Unit) {
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
    state: RuneState,
    viewModel: RuneViewModel,
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
                painter = painterResource(if (RoutesRunes.Pag8.route == state.runeActual.dataRuneNavigation.routeRuneActual) Res.drawable.NUMERO2 else Res.drawable.NUMERO1),
                contentDescription = "",
                modifier = Modifier.size(140.dp).clip(CircleShape)
            )
            Spacer(Modifier.weight(1f))
            Image(
                painter = painterResource(Res.drawable.RUNAIGUALDAD),
                contentDescription = state.comparisonOperator?.symbol,
                modifier = Modifier.size(140.dp)
            )
            Spacer(Modifier.weight(1f))
            Image(
                painter = painterResource(Res.drawable.NUMERO1),
                contentDescription = "",
                modifier = Modifier.size(140.dp).clip(CircleShape)
            )
            Spacer(Modifier.weight(1f))
            Image(
                painter = painterResource(if (RoutesRunes.Pag8.route == state.runeActual.dataRuneNavigation.routeRuneActual) Res.drawable.RUNAOR else Res.drawable.RUNAAND),
                contentDescription = state.comparisonOperator?.symbol,
                modifier = Modifier.size(140.dp)
            )
            Spacer(Modifier.weight(1f))
            Image(
                painter = painterResource(state.selectedItems.first().image),
                contentDescription = state.selectedItems.first().form,
                modifier = Modifier.size(140.dp).clip(CircleShape)
            )
            Spacer(Modifier.weight(1f))
            if (state.selectedItems.size > 1) {
                comparation()
                Image(
                    painter = painterResource(Res.drawable.RUNAIGUALDAD),
                    contentDescription = state.comparisonOperator?.symbol,
                    modifier = Modifier.size(140.dp)
                )
                Spacer(Modifier.weight(1f))
                Image(
                    painter = painterResource(state.selectedItems.last().image),
                    contentDescription = state.selectedItems.last().form,
                    modifier = Modifier.size(140.dp).clip(CircleShape)
                )
                Spacer(Modifier.weight(1f))
            }
        } else {
            Spacer(Modifier.weight(1f))
            Image(
                painter = painterResource(state.selectedItems.first().image),
                contentDescription = state.selectedItems.first().form,
                modifier = Modifier.size(140.dp).clip(CircleShape)
            )
            Spacer(Modifier.weight(1f))
            if (state.selectedItems.size > 1) {
                comparation()
                Image(
                    painter = painterResource(
                        state.comparisonOperator?.icon ?: Res.drawable.RUNAOR
                    ),
                    contentDescription = state.comparisonOperator?.symbol,
                    modifier = Modifier.size(140.dp)
                )
                Spacer(Modifier.weight(1f))
                Image(
                    painter = painterResource(state.selectedItems.last().image),
                    contentDescription = state.selectedItems.last().form,
                    modifier = Modifier.size(140.dp).clip(CircleShape)
                )
                Spacer(Modifier.weight(1f))
            }
        }
    }
}
