package com.scaffold.screens.language

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.scaffold.compositions.TemplateText
import com.scaffold.view_models.LanguageViewModel

@Composable
fun All_Languages(
    viewModel: LanguageViewModel
) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 16.dp)
            .verticalScroll(state = rememberScrollState())
    ) {
        Column {
            when {
                uiState.isLoading -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(
                            color = Color.Black
                        )
                    }
                }

                uiState.error.isNotEmpty() -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        TemplateText(
                            value = uiState?.error.toString(),
                            colors = Color.Black,
                            fontSize = 23.sp,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.ExtraBold
                        )
                    }
                }

                else -> {
                    uiState?.data?.let {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                TemplateText(
                                    value = "اللغات المُتاحة",
                                    colors = Color.Black,
                                    fontSize = 30.sp,
                                    textAlign = TextAlign.Center,
                                    fontWeight = FontWeight.ExtraBold
                                )
                                it?.languageModel?.forEach { languageModel ->
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(height = 50.dp)
                                            .padding(all = 8.dp),
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        TemplateText(
                                            value = languageModel?.language.toString(),
                                            colors = Color.Black,
                                            fontSize = 17.sp,
                                            textAlign = TextAlign.End
                                        )
                                        TemplateText(
                                            value = languageModel?.native.toString(),
                                            colors = Color.Black,
                                            fontSize = 17.sp,
                                            textAlign = TextAlign.Start
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}