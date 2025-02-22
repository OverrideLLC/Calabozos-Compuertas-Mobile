package com.controller

import androidx.lifecycle.ViewModel
import com.shared.enum.InventoryObject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ControllerViewModel : ViewModel() {
    private val _state = MutableStateFlow(ControllerState())
    val state = _state.asStateFlow()

    fun update(update: ControllerState.() -> ControllerState) {
        _state.value = update(_state.value)
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