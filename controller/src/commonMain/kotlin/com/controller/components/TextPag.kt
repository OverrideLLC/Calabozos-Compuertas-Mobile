package com.controller.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import com.shared.enum.RunesEnum
import com.shared.routes.RoutesRunes
import kotlinx.coroutines.delay

@Composable
fun TextPag(
    text: String,
    color: Color = Color.White,
    contentAlignment: Alignment = Alignment.TopStart,
) {
    var displayedText by remember { mutableStateOf("") }
    var isFinalText by remember { mutableStateOf(false) }
    var delayMillisText by remember { mutableStateOf(20L) }
    var doubleClick by remember { mutableStateOf(false) }
    LaunchedEffect(text) {
        text.forEachIndexed { index, _ ->
            displayedText = text.take(index + 1)
            delay(delayMillisText)
        }
        doubleClick = true
    }
    AnimatedVisibility(
        visible = !isFinalText,
        enter = slideInVertically { it } + fadeIn(tween(1000)),
        exit = slideOutVertically { -it } + fadeOut(tween(1000))
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    if (isFinalText) Color.Transparent else colorScheme.background.copy(
                        alpha = 0.8f
                    )
                )
                .clickable {
                    delayMillisText = 2L
                    if (doubleClick) isFinalText = true
                    doubleClick = true
                },
            contentAlignment = contentAlignment
        ) {
            Text(
                text = displayedText,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = FontFamily.Serif,
                color = color,
                textAlign = TextAlign.Left,
                modifier = Modifier.padding(10.dp)
            )
        }
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
                contentAlignment = Alignment.TopStart,
            )
        }

        RoutesRunes.Pag2.route -> {
            TextPag(
                text = runeActual.texts["text1"] ?: "",
                color = colorScheme.tertiary,
                contentAlignment = Alignment.BottomStart,
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
        }

        RoutesRunes.Pag5.route -> {
            TextPag(
                text = runeActual.texts["text1"] ?: "",
                color = colorScheme.tertiary,
                contentAlignment = Alignment.TopStart
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
