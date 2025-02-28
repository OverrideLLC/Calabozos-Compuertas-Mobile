package org.book.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle

private val DarkColorScheme = darkColorScheme(
    primary = Primary,
    secondary = Secondary,
    tertiary = tertiary,
    background = background,
    error = error
)

@Composable
fun typography(): Typography = Typography(
    titleLarge = TextStyle(fontFamily = TitleThematic()),
    bodyMedium = TextStyle(fontFamily = BodyRailway())
)

@Composable
fun MaterialThemeBook(content: @Composable () -> Unit) =
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = typography(),
        content = content
    )