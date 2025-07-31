package com.scaffold.network

import com.scaffold.response.LanguageResponse
import com.scaffold.utils.Constants.BASE_URL
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url

class ApiService(
    private val httpClient: HttpClient
) {
    suspend fun getAllLanguages(): LanguageResponse {
        return httpClient
            .get {
                url(urlString = "${BASE_URL}/languages")
            }.body<LanguageResponse>()
    }
}
