package com.scaffold

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.bottomSheet.LocalBottomSheetNavigator
import com.scaffold.compositions.TemplateIcon
import com.scaffold.screens.hello.HelloScreen
import com.scaffold.screens.language.LanguageScreen
import com.scaffold.screens.sebha.SebhaScreen
import com.scaffold.screens.setting.SettingScreen
import com.scaffold.utils.NavItems
import compose.icons.FeatherIcons
import compose.icons.TablerIcons
import compose.icons.feathericons.Home
import compose.icons.feathericons.Settings
import compose.icons.tablericons.CircleDotted
import compose.icons.tablericons.World
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    val navItems = listOf(
        NavItems(title = "Home", icon = FeatherIcons.Home),
        NavItems(title = "Sebha", icon = TablerIcons.CircleDotted),
        NavItems(title = "Language", icon = TablerIcons.World),
    )
    var selectItem by remember { mutableIntStateOf(value = 0) }
    val bottomSheetNavigator = LocalBottomSheetNavigator.current


    Scaffold(
        bottomBar = {
            NavigationBar {
                navItems.forEachIndexed { index, navItems ->
                    NavigationBarItem(
                        selected = selectItem == index,
                        onClick = {
                            selectItem = index
                        },
                        icon = {
                            TemplateIcon(
                                imageVector = navItems.icon,
                                contentDescription = "icon"
                            )
                        },
                        label = {
                            Text(
                                text = navItems.title,
                                fontSize = 15.sp,
                                color = Color.Black
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.DarkGray,
                            unselectedIconColor = Color.LightGray
                        )
                    )
                }
            }
        },
        floatingActionButton = {
            androidx.compose.material.FloatingActionButton(
                onClick = {
                    bottomSheetNavigator.show(screen = SettingScreen)
                }, content = {
                    TemplateIcon(
                        imageVector = FeatherIcons.Settings,
                        contentDescription = "icon setting"
                    )
                },
                backgroundColor = Color.White
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            selectItemOfNavigation(selectItem = selectItem)
        }
    }
}

@Composable
fun selectItemOfNavigation(selectItem: Int) {
    when (selectItem) {
        0 -> Navigator(screen = HelloScreen)
        1 -> Navigator(screen = SebhaScreen)
        2 -> Navigator(screen = LanguageScreen)
    }
}
