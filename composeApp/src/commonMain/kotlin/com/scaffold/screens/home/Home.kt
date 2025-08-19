package com.scaffold.screens.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.FloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.scaffold.compositions.TemplateIcon
import com.scaffold.screens.language.LanguageScreen
import compose.icons.TablerIcons
import compose.icons.tablericons.World

@Composable
fun Home() {
    val navigator = LocalNavigator.currentOrThrow
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navigator.push(item = LanguageScreen)
                },
                content = {
                    TemplateIcon(
                        imageVector = TablerIcons.World,
                        contentDescription = "icon world"
                    )
                },
                backgroundColor = Color.White
            )
        },
        floatingActionButtonPosition = FabPosition.End,
        content = {}
    )

}