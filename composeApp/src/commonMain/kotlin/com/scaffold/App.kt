package com.scaffold

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Tab
import androidx.compose.material.TabRowDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.bottomSheet.LocalBottomSheetNavigator
import com.scaffold.compositions.TemplateIcon
import com.scaffold.compositions.TemplateText
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

@OptIn(ExperimentalAnimationApi::class)
@Composable
@Preview
fun App() {
    val navItems = remember {
        listOf(
            NavItems(title = "Home", icon = FeatherIcons.Home),
            NavItems(title = "Sebha", icon = TablerIcons.CircleDotted),
            NavItems(title = "Language", icon = TablerIcons.World),
        )
    }
    var selectItem by remember { mutableIntStateOf(value = 0) }
    val bottomSheetNavigator = LocalBottomSheetNavigator.current


    Scaffold(
        topBar = {
            TabRow(
                selectedTabIndex = selectItem,
                modifier = Modifier
                    .height(height = 80.dp),
                indicator = { tabPositions ->
                    TabRowDefaults.Indicator(
                        modifier = Modifier
                            .tabIndicatorOffset(tabPositions[selectItem]),
                        color = Color.Gray,
                    )
                }
            ) {
                navItems.forEachIndexed { index, tab ->
                    Tab(
                        selected = selectItem == index,
                        onClick = { selectItem = index },
                        content = {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                TemplateIcon(
                                    imageVector = tab.icon,
                                    contentDescription = tab.title,
                                    tint = Color.Black
                                )

                                Spacer(modifier = Modifier.height(height = 8.dp))

                                TemplateText(
                                    value = tab.title,
                                    fontSize = 17.sp,
                                    colors = Color.Black
                                )
                            }
                        },
                    )
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    bottomSheetNavigator.show(screen = SettingScreen)
                }, content = {
                    TemplateIcon(
                        imageVector = FeatherIcons.Settings,
                        contentDescription = "icon setting",
                        tint = Color.Black
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


