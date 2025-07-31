package com.scaffold.response

import com.scaffold.entities.LanguageModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LanguageResponse(
    @SerialName("language")
    val languageModel: List<LanguageModel>
)