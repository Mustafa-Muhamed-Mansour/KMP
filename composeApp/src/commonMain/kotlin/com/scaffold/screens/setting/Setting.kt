package com.scaffold.screens.setting

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.scaffold.compositions.TemplateText
import navigationdrawer.composeapp.generated.resources.Res
import navigationdrawer.composeapp.generated.resources.settings
import org.jetbrains.compose.resources.stringResource

@Composable
fun Setting() {
    TemplateText(
        value = stringResource(resource = Res.string.settings),
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .wrapContentSize(align = Alignment.Center),
        fontSize = 17.sp,
        textAlign = TextAlign.Center,
        colors = Color.Black
    )
}