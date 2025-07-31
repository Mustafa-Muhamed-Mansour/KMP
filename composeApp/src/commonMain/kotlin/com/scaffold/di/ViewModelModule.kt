package com.scaffold.di

import com.scaffold.view_models.LanguageViewModel
import org.koin.compose.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel { LanguageViewModel(languageRepository = get()) }
}