package com.scaffold.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.scaffold.repositories.LanguageRepository
import com.scaffold.utils.LanguageStates
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent

class LanguageViewModel(
    private val languageRepository: LanguageRepository
) : ViewModel(), KoinComponent {
    private val _uiState = MutableStateFlow(value = LanguageStates())
    val uiState = _uiState.asStateFlow()

    init {
        fetchLanguages()
    }

    private fun fetchLanguages() = viewModelScope.launch {
        _uiState.update { LanguageStates(isLoading = true) }
        val response = languageRepository.fetchAllLanguages()
        if (response.isSuccess) {
            _uiState.update {
                LanguageStates(
                    isLoading = false,
                    data = response.getOrNull()
                )
            }
        } else {
            _uiState.update {
                LanguageStates(
                    isLoading = false,
                    error = response?.exceptionOrNull()?.message ?: "حدث خطأ غير معروف"
                )
            }
        }
    }

}