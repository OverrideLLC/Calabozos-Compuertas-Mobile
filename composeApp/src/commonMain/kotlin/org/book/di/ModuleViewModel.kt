package org.book.di

import org.book.ui.screen.start.StartViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val moduleViewModel = module {
    viewModelOf(::StartViewModel)
}