package com.scaffold.di

import com.scaffold.network.ApiService
import com.scaffold.network.KtorClient
import org.koin.dsl.module

val apiModule = module {
    single { ApiService(httpClient = KtorClient.httpClient) }
}