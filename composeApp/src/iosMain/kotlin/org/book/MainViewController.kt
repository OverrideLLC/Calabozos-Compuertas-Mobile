package org.book

import androidx.compose.ui.window.ComposeUIViewController
import coil3.compose.LocalPlatformContext

fun MainViewController() = ComposeUIViewController { App(LocalPlatformContext.current) }