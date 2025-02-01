package org.book.ui.components.pags

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.book.ui.screen.rune.RuneViewModel
import org.book.utils.data.RuneState
import org.book.utils.enum.ComparisonOperator
import org.jetbrains.compose.resources.painterResource

@Composable
fun ObjectInventoryComponent(state: RuneState, viewModel: RuneViewModel) {
    viewModel.update {
        copy(
            comparisonOperator = when (state.indexActual) {
                2 -> ComparisonOperator.EQUAL
                3 -> ComparisonOperator.LESS_THAN
                4 -> ComparisonOperator.GREATER_EQUAL
                5 -> ComparisonOperator.LESS_EQUAL
                6 -> ComparisonOperator.NOT_EQUAL
                else -> null
            }
        )
    }

    val comparison = viewModel.performComparison()
    val colorComparison = if (comparison) Color.Green else Color.Red
    viewModel.update { copy(isPagComplete = comparison) }

    AnimatedVisibility(
        visible = state.selectedItems.isNotEmpty()
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            if (state.selectedItems.isNotEmpty()) {
                ContentInventory(
                    state = state,
                    colorComparison = colorComparison,
                )
            }
        }
    }
}

@Composable
fun ContentInventory(
    state: RuneState,
    colorComparison: Color
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(Modifier.weight(1f))
        Icon(
            painter = painterResource(state.selectedItems.first().image),
            contentDescription = state.selectedItems.first().form,
            tint = colorComparison,
            modifier = Modifier.size(50.dp)
        )
        Spacer(Modifier.weight(1f))
        if (state.selectedItems.size > 1) {
            Text(
                text = state.comparisonOperator?.symbol ?: "",
                color = colorComparison,
                fontWeight = FontWeight.Bold,
                fontSize = 50.sp,
            )
            Spacer(Modifier.weight(1f))
            Icon(
                painter = painterResource(state.selectedItems.last().image),
                contentDescription = state.selectedItems.last().form,
                tint = colorComparison,
                modifier = Modifier.size(50.dp)
            )
            Spacer(Modifier.weight(1f))
        }
    }
}
