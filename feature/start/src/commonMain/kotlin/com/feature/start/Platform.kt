package com.feature.start

import androidx.compose.runtime.Composable

expect fun platform(): String

expect class View(){
    @Composable
    fun Web()
}