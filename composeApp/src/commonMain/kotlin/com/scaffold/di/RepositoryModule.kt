package com.scaffold.di

import com.scaffold.repositories.LanguageRepository
import org.koin.dsl.module


val repositoryModule = module {
    single { LanguageRepository(apiService = get()) }
}