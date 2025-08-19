package com.navigation.drawer

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.scaffold.App
import com.scaffold.di.initKoin


@OptIn(ExperimentalMaterialApi::class)
fun main() {
    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "KMP",
        ) {
            App()
        }
    }
}