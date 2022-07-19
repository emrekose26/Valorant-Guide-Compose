package com.emrekose.valorantguide.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.emrekose.valorantguide.R

// Set of Material typography styles to start with
val ValorantFont = FontFamily(
    Font(R.font.valorantfont)
)

val Typography = Typography(
    body1 = TextStyle(
        fontFamily = ValorantFont,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
)