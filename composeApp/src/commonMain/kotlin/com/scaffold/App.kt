package com.scaffold

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.bottomSheet.LocalBottomSheetNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
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
import compose.icons.feathericons.Menu
import compose.icons.tablericons.CircleDotted
import compose.icons.tablericons.World
import kotlinx.coroutines.launch
import navigationdrawer.composeapp.generated.resources.Res
import navigationdrawer.composeapp.generated.resources.languages
import navigationdrawer.composeapp.generated.resources.settings
import navigationdrawer.composeapp.generated.resources.side_menu
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
//    val navItems = listOf(
//        NavItems(title = "Home", icon = FeatherIcons.Home),
//        NavItems(title = "Sebha", icon = TablerIcons.CircleDotted),
//        NavItems(title = "Language", icon = TablerIcons.World),
//    )
    var selectItem by remember { mutableIntStateOf(value = 0) }
//    val bottomSheetNavigator = LocalBottomSheetNavigator.current

    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    val navigator = LocalNavigator.currentOrThrow

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = false,
        drawerContent = {
            ModalDrawerSheet {
                TemplateText(
                    value = stringResource(resource = Res.string.side_menu),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 23.sp,
                    textAlign = TextAlign.Center,
                    colors = Color.Black
                )
                NavigationDrawerItem(
                    label = {
                        TemplateText(
                            value = stringResource(resource = Res.string.languages),
                            fontSize = 17.sp,
                            colors = Color.Black
                        )
                    },
                    selected = false,
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                            navigator.push(item = LanguageScreen)
                        }
                    })
                NavigationDrawerItem(
                    label = {
                        TemplateText(
                            value = stringResource(resource = Res.string.settings),
                            fontSize = 17.sp,
                            colors = Color.Black
                        )
                    },
                    selected = false,
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                            navigator.push(item = SettingScreen)
                        }
                    })
            }
        },
        content = {
            Scaffold(
                topBar = {
                    TemplateIcon(
                        modifier = Modifier
                            .padding(all = 16.dp),
                        click = {
                            coroutineScope.launch { drawerState.open() }
                        },
                        imageVector = FeatherIcons.Menu,
                        contentDescription = "icon menu to open drawer"
                    )
                },
                floatingActionButton = {
                    FloatingActionButton(
                        onClick = {
                            coroutineScope.launch {
                                drawerState.close()
                                navigator.push(item = SebhaScreen)
                            }
                        },
                        content = {
                            TemplateIcon(
                                imageVector = TablerIcons.CircleDotted,
                                contentDescription = "icon sebha"
                            )
                        },
                        containerColor = Color.White
                    )
                },
                floatingActionButtonPosition = androidx.compose.material3.FabPosition.End
            ) { innerPadding ->
                Box(
                    modifier = Modifier
                        .padding(innerPadding)
                ) {
                    selectItemOfNavigation(selectItem = selectItem)
                }
            }
        }
    )

}

@Composable
fun selectItemOfNavigation(selectItem: Int) {
    when (selectItem) {
        0 -> Navigator(screen = HelloScreen)
        1 -> Navigator(screen = SebhaScreen)
        2 -> Navigator(screen = LanguageScreen)
    }
}
