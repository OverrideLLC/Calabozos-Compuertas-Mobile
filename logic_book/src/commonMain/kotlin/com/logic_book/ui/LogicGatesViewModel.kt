package com.logic_book.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil3.ImageLoader
import coil3.PlatformContext
import coil3.request.CachePolicy
import coil3.request.ImageRequest
import com.logic_book.utils.enums.ImagesBook
import com.logic_book.utils.enums.ImagesLogicGates
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
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
}