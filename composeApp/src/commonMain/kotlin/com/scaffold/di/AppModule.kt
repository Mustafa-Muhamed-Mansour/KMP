package com.scaffold.di

import org.koin.core.context.startKoin
import org.koin.core.logger.PrintLogger
import org.koin.dsl.KoinAppDeclaration


fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        logger(PrintLogger())
        config?.invoke(this)
        modules(
            apiModule,
            repositoryModule,
            viewModelModule
        )
    }
}