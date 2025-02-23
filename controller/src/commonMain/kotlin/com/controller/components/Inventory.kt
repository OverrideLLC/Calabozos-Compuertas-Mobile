package com.controller.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.controller.ControllerState
import com.controller.ControllerViewModel
import com.shared.enum.InventoryObject

@Composable
fun InventoryComponent(
    state: ControllerState,
    viewModel: ControllerViewModel,
    comparative: () -> Unit
) {
    val animatedOffset by animateDpAsState(
        targetValue = if (state.isExpandedInventory) (-10).dp else 550.dp,
        animationSpec = tween(300, easing = FastOutSlowInEasing)
    )
    if (state.indexActual >= 1) {
        ObjectInventoryComponent(
            state = state,
            viewModel = viewModel,
            comparator = comparative
        )
    }
    viewModel.update { copy(isSelectedRune = state.selectedItems.isNotEmpty()) }
    AnimatedVisibility(
        visible = state.isExpandedInventory && state.indexActual >= 1,
        enter = slideInVertically(
            initialOffsetY = { it },
            animationSpec = tween(durationMillis = 300)
        ),
        exit = slideOutVertically(
            targetOffsetY = { it },
            animationSpec = tween(durationMillis = 300)
        ),
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .pointerInput(Unit) {
                        detectTapGestures(
                            onTap = {
                                viewModel.update { copy(isExpandedInventory = false) }
                            }
                        )
                    }
                    .offset { animatedOffset.value.toInt().let { IntOffset(0, it) } },
                contentAlignment = Alignment.BottomCenter,
            ) {
                LazyVerticalStaggeredGrid(
                    modifier = Modifier
                        .padding(10.dp)
                        .size(width = 500.dp, height = 230.dp)
                        .background(
                            color = colorScheme.background.copy(0.6f),
                            shape = RoundedCornerShape(16.dp)
                        ),
                    verticalItemSpacing = 10.dp,
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    columns = StaggeredGridCells.Fixed(3)
                ) {
                    items(InventoryObject.entries) { item ->
                        IconButton(
                            onClick = { viewModel.toggleSelection(item) },
                            modifier = Modifier
                                .wrapContentSize()
                                .padding(5.dp)
                                .background(
                                    color = if (state.selectedItems.contains(item)) colorScheme.primary else Color.Transparent,
                                    shape = RoundedCornerShape(64.dp)
                                )
                        ) {
                            AsyncImage(
                                model = item.imageUrl,
                                contentDescription = item.name,
                                modifier = Modifier.size(90.dp).clip(CircleShape)
                            )
                        }
                    }
                }
            }
        }
    )
}