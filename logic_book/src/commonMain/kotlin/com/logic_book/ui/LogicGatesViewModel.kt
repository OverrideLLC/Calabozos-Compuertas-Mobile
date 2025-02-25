package com.logic_book.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil3.ImageLoader
import coil3.PlatformContext
import coil3.request.CachePolicy
import coil3.request.ImageRequest
import com.controller.ControllerState
import com.controller.ControllerViewModel
import com.logic_book.utils.enums.ImagesBook
import com.logic_book.utils.enums.ImagesLogicGates
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LogicGatesViewModel : ViewModel() {
    private val _state = MutableStateFlow(LogicGatesData())
    val state = _state.asStateFlow()

    fun update(update: LogicGatesData.() -> LogicGatesData) {
        _state.value = update(_state.value)
    }

    fun preloadImages(
        platformContext: PlatformContext,
        isComplete: (Boolean) -> Unit
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            val imageLoader = ImageLoader(context = platformContext)
            ImagesLogicGates.entries.forEach { images ->
                val request = ImageRequest.Builder(context = platformContext)
                    .data(images.imageUrl)
                    .diskCachePolicy(CachePolicy.ENABLED)
                    .memoryCachePolicy(CachePolicy.ENABLED)
                    .build()
                imageLoader.execute(request)
            }

            ImagesBook.entries.forEach { images ->
                val request = ImageRequest.Builder(context = platformContext)
                    .data(images.imageUrl)
                    .diskCachePolicy(CachePolicy.ENABLED)
                    .memoryCachePolicy(CachePolicy.ENABLED)
                    .build()
                imageLoader.execute(request)
            }
        }.invokeOnCompletion {
            isComplete(true)
        }
    }

    fun tapController(
        stateController: ControllerState,
        viewModelController: ControllerViewModel,
        activeWire: Boolean,
        activeNot: Boolean,
        activeOr: Boolean,
        activeAnd: Boolean,
        activeXor: Boolean,
        activeLatch: Boolean,
    ) {
        when (stateController.indexActual) {
            0 -> {
                update { copy(activeWire = activeWire) }
                if (activeWire) {
                    viewModelController.update { copy(isPagComplete = true) }
                    update { copy(illumiGate = true) }
                } else {
                    viewModelController.update { copy(isPagComplete = false) }
                    update { copy(illumiGate = false) }
                }
            }

            1 -> {
                update { copy(activeNot = activeNot) }
                if (activeNot) {
                    viewModelController.update { copy(isPagComplete = true) }
                    update { copy(illumiGate = true) }
                } else {
                    viewModelController.update { copy(isPagComplete = false) }
                    update { copy(illumiGate = false) }
                }
            }

            2 -> {
                update { copy(activeOr = activeOr) }
                if (activeOr) {
                    viewModelController.update { copy(isPagComplete = true) }
                    update { copy(illumiGate = true) }
                } else {
                    viewModelController.update { copy(isPagComplete = false) }
                    update { copy(illumiGate = false) }
                }
            }

            3 -> {
                update { copy(activeAnd = activeAnd) }
                if (activeAnd) {
                    viewModelController.update { copy(isPagComplete = true) }
                    update { copy(illumiGate = true) }
                } else {
                    viewModelController.update { copy(isPagComplete = false) }
                    update { copy(illumiGate = false) }
                }
            }

            4 -> {
                update { copy(activeXor = activeXor) }
                if (activeXor) {
                    viewModelController.update { copy(isPagComplete = true) }
                    update { copy(illumiGate = true) }
                } else {
                    viewModelController.update { copy(isPagComplete = false) }
                    update { copy(illumiGate = false) }
                }
            }

            5 -> {
                update { copy(activeLatch = activeLatch) }
                if (activeLatch) {
                    viewModelController.update { copy(isPagComplete = true) }
                    update { copy(illumiGate = true) }
                } else {
                    viewModelController.update { copy(isPagComplete = false) }
                    update { copy(illumiGate = false) }
                }
            }
        }
    }

    fun reset() {
        _state.update {
            it.copy(
                activeWire = false,
                activeNot = false,
                activeOr = false,
                activeAnd = false,
                activeXor = false,
                activeLatch = false,
                illumiGate = false
            )
        }
    }
}