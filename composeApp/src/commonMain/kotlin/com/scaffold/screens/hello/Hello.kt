package com.scaffold.screens.hello

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.scaffold.compositions.TemplateText
import navigationdrawer.composeapp.generated.resources.Res
import navigationdrawer.composeapp.generated.resources.hello_app
import org.jetbrains.compose.resources.stringResource

@Composable
fun Hello() {
    TemplateText(
        value = stringResource(resource = Res.string.hello_app),
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .wrapContentSize(align = Alignment.Center),
        fontWeight = FontWeight.ExtraBold,
        fontSize = 37.sp,
        textAlign = TextAlign.Center,
        colors = Color.Black
    )
}