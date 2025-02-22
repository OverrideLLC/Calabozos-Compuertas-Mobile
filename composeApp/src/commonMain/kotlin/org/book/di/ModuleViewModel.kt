package org.book.di

import com.calabozos_compuertas.runes_book.RuneViewModel
import com.controller.ControllerViewModel
import org.book.ui.screen.start.StartViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val moduleViewModel = module {
    viewModelOf(::StartViewModel)
    viewModelOf(::RuneViewModel)
    viewModelOf(::ControllerViewModel)
}