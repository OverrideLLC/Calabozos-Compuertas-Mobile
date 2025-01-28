package org.book.ui.screen.start

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class StartViewModel : ViewModel() {
    data class StartState(
        val isLoading: Boolean = false,
        val error: String? = null,
        val music: Boolean = true,
        val visible: Boolean = false
    )

    private val _state = MutableStateFlow(StartState())
    val state = _state.asStateFlow()

    fun update(update: StartState.() -> StartState) {
        _state.value = _state.value.update()
    }
}