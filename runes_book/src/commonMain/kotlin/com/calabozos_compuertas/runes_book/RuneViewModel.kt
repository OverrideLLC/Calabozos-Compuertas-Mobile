package com.calabozos_compuertas.runes_book

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil3.ImageLoader
import coil3.PlatformContext
import coil3.request.CachePolicy
import coil3.request.ImageRequest
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
    private val _state: MutableStateFlow<ControllerState> = MutableStateFlow(ControllerState())
    val state: StateFlow<ControllerState> = _state.asStateFlow()

    fun update(update: ControllerState.() -> ControllerState) {
        _state.value = update(_state.value)
    }

    fun performComparison() {
        val (operator, items) = _state.value.run { comparisonOperator to selectedItems }
        if (operator == null || items.size != 2) return update { copy(isPagComplete = false) }

        val (first, second) = items.first() to items.last()
        _state.update { current ->
            current.copy(
                isPagComplete = when (operator) {
                    ComparisonOperator.EQUAL -> first.value == second.value
                    ComparisonOperator.NOT_EQUAL -> first.value != second.value
                    ComparisonOperator.LESS_THAN -> first.value < second.value
                    ComparisonOperator.GREATER_THAN -> first.value > second.value
                    ComparisonOperator.LESS_EQUAL -> first.value <= second.value
                    ComparisonOperator.GREATER_EQUAL -> first.value >= second.value
                    ComparisonOperator.OR -> first.name == second.name || first.value == second.value
                    ComparisonOperator.AND -> first.name == second.name && first.value == second.value
                }
            )
        }
    }
    fun preloadImages(platformContext: PlatformContext) {
        update { copy(isLoading = true) }
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
            update { copy(isLoading = false) }
        }
    }
}