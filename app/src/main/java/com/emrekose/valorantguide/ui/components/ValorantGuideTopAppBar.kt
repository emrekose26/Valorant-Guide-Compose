package com.emrekose.valorantguide.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.emrekose.valorantguide.ui.theme.ValorantGuideTheme

@Composable
fun ValorantGuideTopAppBar(
    title: String,
    backgroundColor: Color,
    contentColor: Color,
    isNavigationIconVisible: Boolean,
    onNavigationIconClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .height(56.dp)
            .fillMaxHeight()
            .background(color = backgroundColor)
    ) {
        if (isNavigationIconVisible) {
            Icon(
                Icons.Filled.KeyboardArrowLeft,
                contentDescription = "Back",
                tint = contentColor,
                modifier = Modifier
                    .height(56.dp)
                    .size(36.dp)
                    .fillMaxHeight()
                    .padding(start = 8.dp)
                    .clickable { onNavigationIconClick() }
            )
        }
        Text(
            text = title,
            fontSize = 24.sp,
            color = contentColor,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
        )
    }

}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    ValorantGuideTheme {
        ValorantGuideTopAppBar(
            title = "Valorant",
            backgroundColor = Color.Black,
            contentColor = Color.White,
            isNavigationIconVisible = true,
            onNavigationIconClick = {}
        )
    }
}