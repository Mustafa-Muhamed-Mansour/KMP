package com.scaffold.network

import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object KtorClient {
    val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(json = Json {
                prettyPrint = true
                ignoreUnknownKeys = true
                isLenient = true
                coerceInputValues = true
            })
        }

        install(HttpTimeout) {
            socketTimeoutMillis = 3000
            connectTimeoutMillis = 3000
            requestTimeoutMillis = 3000
        }
    }
}