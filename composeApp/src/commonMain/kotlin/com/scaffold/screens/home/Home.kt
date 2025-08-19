package com.scaffold.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.scaffold.compositions.TemplateIcon
import com.scaffold.compositions.TemplateText
import com.scaffold.manual_test.languageAvailable
import com.scaffold.manual_test.testLanguageAvailable
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
        floatingActionButtonPosition = FabPosition.End

    ) { innerPadding ->
        Column {
            TemplateText(
                modifier = Modifier
                    .padding(paddingValues = innerPadding),
                value = languageAvailable(language = "Arabic"),
                fontSize = 17.sp,
                colors = Color.Black
            )
            TemplateText(
                modifier = Modifier
                    .padding(paddingValues = innerPadding),
                value = testLanguageAvailable().toString(),
                fontSize = 17.sp,
                colors = Color.Black
            )
        }
    }

}