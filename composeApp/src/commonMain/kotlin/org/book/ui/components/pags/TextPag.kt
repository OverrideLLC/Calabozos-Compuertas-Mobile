package org.book.ui.components.pags

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import org.book.utils.enum.RunesEnum
import org.book.utils.routes.RoutesRunes

@Composable
fun TextPag(
    text: String,
    color: Color = Color.White,
    contentAlignment: Alignment = Alignment.TopStart,
    delayMillis: Long = 0
) {
    var displayedText by remember { mutableStateOf("") }
    LaunchedEffect(text) {
        delay(delayMillis)
        text.forEachIndexed { index, _ ->
            displayedText = text.take(index + 1)
            delay(20)
        }
    }
    Box(
        modifier = Modifier.fillMaxSize().padding(10.dp),
        contentAlignment = contentAlignment
    ) {
        Text(
            text = displayedText,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily.Serif,
            color = color,
            textAlign = TextAlign.Left
        )
    }
}

@Composable
fun TextRune(
    rune: List<RunesEnum>,
    indexActual: Int,
) {
    val runeActual = rune.getOrNull(indexActual)!!
    when (runeActual.dataRuneNavigation.routeRuneActual) {
        RoutesRunes.Pag1.route -> {
            TextPag(
                text = runeActual.texts["text1"] ?: "",
                color = colorScheme.tertiary,
                contentAlignment = Alignment.TopStart
            )
        }

        RoutesRunes.Pag2.route -> {
            TextPag(
                text = runeActual.texts["text1"] ?: "",
                color = colorScheme.tertiary,
                contentAlignment = Alignment.BottomStart
            )
        }

        RoutesRunes.Pag3.route -> {
            TextPag(
                text = runeActual.texts["text1"] ?: "",
                color = colorScheme.tertiary,
                contentAlignment = Alignment.TopStart
            )
        }

        RoutesRunes.Pag4.route -> {
            TextPag(
                text = runeActual.texts["text1"] ?: "",
                color = colorScheme.tertiary,
                contentAlignment = Alignment.TopStart
            )
            TextPag(
                text = runeActual.texts["text2"] ?: "",
                color = Color.White,
                contentAlignment = Alignment.BottomCenter,
                delayMillis = 2000
            )
        }

        RoutesRunes.Pag5.route -> {
            TextPag(
                text = runeActual.texts["text1"] ?: "",
                color = colorScheme.tertiary,
                contentAlignment = Alignment.TopStart
            )
            TextPag(
                text = runeActual.texts["text2"] ?: "",
                color = Color.Black,
                contentAlignment = Alignment.CenterEnd,
                delayMillis = 2000
            )
        }

        RoutesRunes.Pag6.route -> {
            TextPag(
                text = runeActual.texts["text1"] ?: "",
                color = colorScheme.tertiary,
                contentAlignment = Alignment.TopStart
            )
        }

        RoutesRunes.Pag7.route -> {
            TextPag(
                text = runeActual.texts["text1"] ?: "",
                color = colorScheme.tertiary,
                contentAlignment = Alignment.TopStart
            )
        }

        RoutesRunes.Pag8.route -> {
            TextPag(
                text = runeActual.texts["text1"] ?: "",
                color = colorScheme.tertiary,
                contentAlignment = Alignment.TopStart
            )
            TextPag(
                text = runeActual.texts["text2"] ?: "",
                color = colorScheme.tertiary,
                contentAlignment = Alignment.TopEnd,
                delayMillis = 1000
            )
            TextPag(
                text = runeActual.texts["text3"] ?: "",
                color = colorScheme.tertiary,
                contentAlignment = Alignment.CenterEnd,
                delayMillis = 2000
            )
            TextPag(
                text = runeActual.texts["text4"] ?: "",
                color = colorScheme.tertiary,
                contentAlignment = Alignment.BottomStart,
                delayMillis = 6500
            )
        }

        RoutesRunes.Pag9.route -> {
            TextPag(
                text = runeActual.texts["text1"] ?: "",
                color = colorScheme.tertiary,
                contentAlignment = Alignment.TopStart
            )
        }

        RoutesRunes.Pag10.route -> {
            TextPag(
                text = runeActual.texts["text1"] ?: "",
                color = colorScheme.tertiary,
                contentAlignment = Alignment.CenterEnd
            )
        }
    }
}
