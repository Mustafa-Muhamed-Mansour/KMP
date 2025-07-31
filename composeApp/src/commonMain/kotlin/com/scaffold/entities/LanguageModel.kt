package com.scaffold.entities

import kotlinx.serialization.Serializable

@Serializable
data class LanguageModel(
    val language: String,
    val native: String,
    val locale: String
)