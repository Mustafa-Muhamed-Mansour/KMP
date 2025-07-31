package com.scaffold.screens.language

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import com.scaffold.view_models.LanguageViewModel
import org.koin.compose.viewmodel.koinViewModel


object LanguageScreen : Screen {
    @Composable
    override fun Content() {
        val viewModel = koinViewModel<LanguageViewModel>()
        All_Languages(viewModel = viewModel)
    }
}