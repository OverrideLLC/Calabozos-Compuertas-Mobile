package org.book

import androidx.compose.runtime.Composable
import org.book.ui.navigation.NavigationStart
import org.book.ui.theme.MaterialThemeBook
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext

@Composable
@Preview
fun App() {
    KoinContext {
        MaterialThemeBook {
            NavigationStart()
        }
    }
}