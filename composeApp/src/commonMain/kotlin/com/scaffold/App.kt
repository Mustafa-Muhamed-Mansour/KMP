package com.scaffold

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.scaffold.screens.home.HomeScreen

@Composable
fun App() {
    Navigator(screen = HomeScreen)
}


