package com.scaffold.utils

import com.scaffold.response.LanguageResponse


data class LanguageStates(
    val isLoading: Boolean = false,
    val error: String = "",
    val data: LanguageResponse ?= null
)

