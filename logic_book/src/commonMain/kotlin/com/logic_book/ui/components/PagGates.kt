package com.logic_book.ui.components

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import coil3.compose.AsyncImage
import com.logic_book.utils.enums.ImagesLogicGates

@Composable
fun PagGates(
    imageGate: ImagesLogicGates,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        content = {
            AsyncImage(
                model = imageGate.imageUrl,
                contentDescription = imageGate.name,
                modifier = Modifier
                    .fillMaxSize()
                    .pointerInput(Unit) { detectTapGestures(onTap = { onClick() }) }
            )
        }
    )
}