package com.scaffold.screens.hello

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen

object HelloScreen: Screen {
    @Composable
    override fun Content() {
        Hello()
    }
}

