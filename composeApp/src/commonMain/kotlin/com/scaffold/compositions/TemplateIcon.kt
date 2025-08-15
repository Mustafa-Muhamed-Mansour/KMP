package com.scaffold.compositions

import androidx.compose.foundation.clickable
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun TemplateIcon(
    imageVector: ImageVector,
    contentDescription: String,
    click: (() -> Unit) ?= null,
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current
) {
    Icon(
        modifier = if (click != null) {
            modifier.clickable { click() }
        } else {
            modifier
        },
        imageVector = imageVector,
        contentDescription = contentDescription,
        tint = tint
    )
}