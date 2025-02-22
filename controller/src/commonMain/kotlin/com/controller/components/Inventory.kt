package com.controller.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
import com.controller.ControllerViewModel
import com.controller.ControllerState
import com.shared.enum.InventoryObject
import com.shared.enum.RunesEnum

@Composable
fun InventoryComponent(
    state: ControllerState,
    viewModel: ControllerViewModel,
    comparative: () -> Unit
) {
    var offsetTarget by remember { mutableStateOf(550.dp) }
    var isExpanded by remember { mutableStateOf(false) }
    val animatedOffset by animateDpAsState(
        targetValue = offsetTarget,
        animationSpec = tween(
            durationMillis = 300,
            easing = FastOutSlowInEasing
        )
    )
    if (state.indexActual >= 1) {
        ObjectInventoryComponent(
            state = state,
            viewModel = viewModel,
            comparation = comparative
        )
    }

    viewModel.update { copy(isSelectedRune = state.selectedItems.isNotEmpty()) }

    AnimatedVisibility(
        visible = state.indexActual >= 1 && state.indexActual < state.rune.size - 1,
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
                    .offset { animatedOffset.value.toInt().let { IntOffset(0, it) } },
                contentAlignment = Alignment.BottomCenter,
            ) {
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .size(width = 500.dp, height = 230.dp)
                        .background(
                            color = colorScheme.background.copy(0.6f),
                            shape = RoundedCornerShape(16.dp)
                        )
                        .clickable {
                            offsetTarget = if (offsetTarget == 550.dp) (-10).dp else 550.dp
                            isExpanded = !isExpanded
                            if (state.runeActual == RunesEnum.entries[1]) viewModel.update {
                                copy(
                                    isClicked = true
                                )
                            }
                        },
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
                                    tint = colorScheme.tertiary,
                                    modifier = Modifier.size(30.dp)
                                )
                            }
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        LazyVerticalStaggeredGrid(
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
                                    Image(
                                        painter = rememberAsyncImagePainter(item.imageUrl),
                                        contentDescription = item.name,
                                        modifier = Modifier.size(90.dp).clip(CircleShape)
                                    )
                                }
                            }
                        }
                        Spacer(modifier = Modifier.weight(1f))
                    }
                )
            }
        }
    )
}