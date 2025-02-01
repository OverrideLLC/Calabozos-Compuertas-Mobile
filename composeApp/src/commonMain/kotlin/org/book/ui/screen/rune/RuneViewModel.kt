package org.book.ui.screen.rune

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.book.utils.data.RuneState
import org.book.utils.enum.ComparisonOperator
import org.book.utils.enum.InventoryObject

class RuneViewModel : ViewModel() {
    private val _state: MutableStateFlow<RuneState> = MutableStateFlow(RuneState())
    val state: StateFlow<RuneState> = _state.asStateFlow()

    fun update(update: RuneState.() -> RuneState) {
        _state.value = update(_state.value)
    }

    fun toggleSelection(item: InventoryObject) {
        _state.update { current ->
            val newSelection = when {
                item in current.selectedItems -> current.selectedItems - item
                current.selectedItems.size < 2 -> current.selectedItems + item
                else ->
                    current.selectedItems.drop(1) + item
            }
            current.copy(selectedItems = newSelection)
        }
    }
    fun performComparison(): Boolean {
        val (operator, items) = _state.value.run { comparisonOperator to selectedItems }
        if (operator == null || items.size != 2) return false

        val (first, second) = items.first() to items.last()
        return when (operator) {
            ComparisonOperator.EQUAL -> first.form == second.form
            ComparisonOperator.NOT_EQUAL -> first.form != second.form
            ComparisonOperator.LESS_THAN -> first.value < second.value
            ComparisonOperator.GREATER_THAN -> first.value > second.value
            ComparisonOperator.LESS_EQUAL -> first.value <= second.value
            ComparisonOperator.GREATER_EQUAL -> first.value >= second.value
        }
    }
}