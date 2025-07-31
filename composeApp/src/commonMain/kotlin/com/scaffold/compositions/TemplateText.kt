package com.scaffold.compositions

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun TemplateText(
    value: String,
    modifier: Modifier = Modifier,
    colors: Color = Color.White,
    fontSize: TextUnit = 10.sp,
    textAlign: TextAlign = TextAlign.Center,
    fontWeight: FontWeight = FontWeight.Normal
) {
    Text(
        text = value,
        modifier = modifier,
        color = colors,
        fontSize = fontSize,
        textAlign = textAlign,
        fontWeight = fontWeight
    )
}