package com.scaffold.repositories

import com.scaffold.network.ApiService
import com.scaffold.response.LanguageResponse
import org.koin.core.component.KoinComponent

class LanguageRepository(
    private val apiService: ApiService
): KoinComponent {
    private suspend fun getLanguages(): LanguageResponse {
        return apiService.getAllLanguages()
    }
    suspend fun fetchAllLanguages(): Result<LanguageResponse> {
        val result = this.getLanguages()
        return try {
            Result.success(value = result)
        } catch (e: Exception) {
            Result.failure(exception = e)
        }
    }
}