package com.calabozos_compuertas.runes_book.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil3.ImageLoader
import coil3.PlatformContext
import coil3.request.CachePolicy
import coil3.request.ImageRequest
import com.calabozos_compuertas.runes_book.utils.RunesState
import com.controller.ControllerState
import com.shared.enum.ComparisonOperator
import com.shared.enum.InventoryObject
import com.shared.enum.RunesEnum
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class RuneViewModel : ViewModel() {
    private val _state: MutableStateFlow<RunesState> = MutableStateFlow(RunesState())
    val state: StateFlow<RunesState> = _state.asStateFlow()

    fun update(update: RunesState.() -> RunesState) {
        _state.value = update(_state.value)
    }

    fun performComparison(): Boolean {
        val (operator, items) = _state.value.run { comparisonOperator to selectedItems }
        if (operator == null || items.size != 2) return false

        val (first, second) = items.first() to items.last()
        return when (operator) {
            ComparisonOperator.EQUAL -> first.value == second.value
            ComparisonOperator.NOT_EQUAL -> first.value != second.value
            ComparisonOperator.LESS_THAN -> first.value < second.value
            ComparisonOperator.GREATER_THAN -> first.value > second.value
            ComparisonOperator.LESS_EQUAL -> first.value <= second.value
            ComparisonOperator.GREATER_EQUAL -> first.value >= second.value
            ComparisonOperator.OR -> true || first.value == second.value
            ComparisonOperator.AND -> true && first.value == second.value
        }
    }

    fun preloadImages(
        platformContext: PlatformContext,
        isComplete: (Boolean) -> Unit
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            val imageLoader = ImageLoader(context = platformContext)
            RunesEnum.entries.forEach { rune ->
                val request = ImageRequest.Builder(context = platformContext)
                    .data(rune.imageUrl)
                    .diskCachePolicy(CachePolicy.ENABLED)
                    .memoryCachePolicy(CachePolicy.ENABLED)
                    .build()
                imageLoader.execute(request)
            }

            InventoryObject.entries.forEach { inventory ->
                val request = ImageRequest.Builder(context = platformContext)
                    .data(inventory.imageUrl)
                    .diskCachePolicy(CachePolicy.ENABLED)
                    .memoryCachePolicy(CachePolicy.ENABLED)
                    .build()
                imageLoader.execute(request)
            }

            ComparisonOperator.entries.forEach { operator ->
                val request = ImageRequest.Builder(context = platformContext)
                    .data(operator.icon)
                    .diskCachePolicy(CachePolicy.ENABLED)
                    .memoryCachePolicy(CachePolicy.ENABLED)
                    .build()
                imageLoader.execute(request)
            }
        }.invokeOnCompletion {
            isComplete(true)
        }
    }

    fun toggleSelection(item: InventoryObject) {
        _state.update { current ->
            val newSelection = when {
                item in current.selectedItems -> current.selectedItems - item
                current.selectedItems.size < 2 -> current.selectedItems + item
                else -> current.selectedItems.drop(1) + item
            }
            current.copy(selectedItems = newSelection)
        }
    }
}