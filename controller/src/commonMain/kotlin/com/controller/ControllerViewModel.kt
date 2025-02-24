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
}