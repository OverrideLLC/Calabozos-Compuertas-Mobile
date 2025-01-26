package org.book.ui.screen.rune

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import org.book.utils.enum.RunesEnum
import org.jetbrains.compose.resources.painterResource

@Composable
fun Pag(dataRune: RunesEnum) {
    Image(
        painter = painterResource(dataRune.image),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
}