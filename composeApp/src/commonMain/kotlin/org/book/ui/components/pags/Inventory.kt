package org.book.ui.components.pags

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import org.book.utils.enum.InventoryObject
import org.jetbrains.compose.resources.painterResource

@Composable
fun Inventory(
    runeSelection: (InventoryObject) -> Unit,
    runeSelectionActual: InventoryObject? = null
) {
    var offsetTarget by remember { mutableStateOf(600.dp) }
    val animatedOffset by animateDpAsState(
        targetValue = offsetTarget,
        animationSpec = tween(
            durationMillis = 300,
            easing = FastOutSlowInEasing
        )
    )
    var isExpanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .offset {
                animatedOffset.value.toInt().let { IntOffset(0, it) }
            },
        contentAlignment = Alignment.BottomCenter,
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .size(width = 500.dp, height = 230.dp)
                .clickable {
                    offsetTarget = if (offsetTarget == 600.dp) (-10).dp else 600.dp
                    isExpanded = !isExpanded
                }
                .background(
                    color = colorScheme.background.copy(alpha = 0.5f),
                    shape = RoundedCornerShape(16.dp)
                ),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            content = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.Center,
                    content = {
                        Icon(
                            imageVector = if (isExpanded) Icons.Default.KeyboardArrowDown else Icons.Default.KeyboardArrowUp,
                            contentDescription = "ArrowUp",
                            tint = colorScheme.tertiary
                        )
                    }
                )
                Spacer(modifier = Modifier.weight(1f))
                LazyVerticalStaggeredGrid(
                    columns = StaggeredGridCells.Fixed(3),
                    verticalItemSpacing = 5.dp,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    items(InventoryObject.entries.toList()) { figure ->
                        if (runeSelectionActual?.form != figure.form) {
                            IconButton(
                                onClick = {
                                    runeSelection(figure)
                                },
                                content = {
                                    Icon(
                                        painter = painterResource(figure.image),
                                        contentDescription = figure.form,
                                        tint = colorScheme.tertiary
                                    )
                                }
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.weight(1f))
            }
        )
    }
}