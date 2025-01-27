package org.book.ui.screen.rune

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.book.utils.data.RuneState

class RuneViewModel : ViewModel() {
    private val _state = MutableStateFlow(RuneState())
    val state = _state.asStateFlow()

    fun update(update: RuneState.() -> RuneState) { _state.value = update(_state.value) }
}