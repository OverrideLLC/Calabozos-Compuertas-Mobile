package org.book.ui.components.pags

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil3.compose.rememberAsyncImagePainter
import org.book.utils.enum.RunesEnum
import org.jetbrains.compose.resources.painterResource

@Composable
fun Pag(dataRune: RunesEnum) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Image(
            painter = rememberAsyncImagePainter(dataRune.imageUrl),
            contentDescription = "",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxSize()
        )
    }
}