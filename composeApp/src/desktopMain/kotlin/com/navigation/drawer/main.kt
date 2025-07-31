package com.navigation.drawer

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import cafe.adriel.voyager.navigator.Navigator
import com.scaffold.App
import com.scaffold.di.initKoin
import com.scaffold.screens.hello.HelloScreen


@OptIn(ExperimentalMaterialApi::class)
fun main() {
    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "KMP",
        ) {
            Navigator(screen = HelloScreen) {
                App()
            }
        }
    }
}