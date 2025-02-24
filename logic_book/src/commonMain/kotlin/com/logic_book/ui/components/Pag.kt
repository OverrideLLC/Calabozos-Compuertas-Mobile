package com.logic_book.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage
import com.logic_book.utils.enums.ImagesBook

@Composable
fun Pag(imageBook: ImagesBook) {
    AsyncImage(
        model = imageBook.imageUrl,
        contentDescription = imageBook.name,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
}