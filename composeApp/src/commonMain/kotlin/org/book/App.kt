package org.book

import androidx.compose.runtime.Composable
import coil3.PlatformContext
import org.book.ui.navigation.NavigationStart
import org.book.ui.theme.MaterialThemeBook
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext

@Composable
@Preview
fun App(context: PlatformContext) {
    KoinContext {
        MaterialThemeBook {
            NavigationStart(context)
        }
    }
}