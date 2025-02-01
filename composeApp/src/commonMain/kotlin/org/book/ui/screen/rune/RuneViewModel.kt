package org.book.ui.screen.rune

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.book.utils.data.RuneState
import org.book.utils.enum.InventoryObject

class RuneViewModel : ViewModel() {
    private val _state: MutableStateFlow<RuneState> = MutableStateFlow(RuneState())
    val state: StateFlow<RuneState> = _state.asStateFlow()

    fun update(update: RuneState.() -> RuneState) {
        _state.value = update(_state.value)
    }

    fun toggleSelection(item: InventoryObject) {
        _state.update { currentState ->
            val newSelection = currentState.selectedItems.toMutableSet()
            if (newSelection.contains(item))
                newSelection.remove(item)
            else
                if (newSelection.size < 2)
                    newSelection.add(item)
                else {
                    newSelection.remove(newSelection.first())
                    newSelection.add(item)
                }

            currentState.copy(selectedItems = newSelection)
        }
    }

    fun comparison(): Boolean {
        if (_state.value.comparison != "" && _state.value.selectedItems.size == 2)
            return when (_state.value.comparison) {
                "==" -> _state.value.selectedItems.first().form == _state.value.selectedItems.last().form
                "<" -> _state.value.selectedItems.first().value < _state.value.selectedItems.last().value
                ">" -> _state.value.selectedItems.first().value > _state.value.selectedItems.last().value
                "<=" -> if (_state.value.selectedItems.first().value < _state.value.selectedItems.last().value) {
                    true
                } else {
                    _state.value.selectedItems.first().value == _state.value.selectedItems.last().value
                }

                ">=" -> if (_state.value.selectedItems.first().value > _state.value.selectedItems.last().value) {
                    true
                } else {
                    _state.value.selectedItems.first().value == _state.value.selectedItems.last().value
                }

                "!=" -> _state.value.selectedItems.first().form != _state.value.selectedItems.last().form
                "||" -> _state.value.selectedItems.first().form == _state.value.selectedItems.last().form
                "&&" -> _state.value.selectedItems.first().form == _state.value.selectedItems.last().form
                else -> false
            }
        else
            return false
    }
}