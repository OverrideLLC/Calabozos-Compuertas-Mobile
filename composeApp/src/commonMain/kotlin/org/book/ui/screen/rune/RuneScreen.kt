package org.book.ui.screen.rune

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.book.ui.navigation.NavControllerRunes

@Composable
fun RuneScreen() = Screen()

@Composable
private fun Screen() {
    Scaffold(
        content = { NavControllerRunes() },
        containerColor = Color.Transparent,
        modifier = Modifier
            .fillMaxSize()
            .background(colorScheme.background),
    )
}