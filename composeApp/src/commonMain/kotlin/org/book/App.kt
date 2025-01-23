package org.book

import androidx.compose.runtime.Composable
import org.book.ui.navigation.NavigationStart
import org.book.ui.theme.MaterialThemeBook
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() = MaterialThemeBook { NavigationStart() }