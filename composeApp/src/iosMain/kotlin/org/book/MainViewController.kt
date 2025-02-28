package org.book

import androidx.compose.ui.window.ComposeUIViewController
import coil3.compose.LocalPlatformContext
import org.book.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = { initKoin() }
) {
    App(LocalPlatformContext.current)
}

