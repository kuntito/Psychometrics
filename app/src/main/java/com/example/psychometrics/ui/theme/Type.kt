package com.example.psychometrics.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

val baseTextStyle = TextStyle(
    fontSize = 8.sp,
    fontWeight = FontWeight.Medium,
    color = color100,
)

val baseBoldStyle = baseTextStyle.copy(
    fontWeight = FontWeight.Bold
)

val baseSemiBoldStyle = baseTextStyle.copy(
    fontWeight = FontWeight.SemiBold
)

const val size50 = 40
const val size100 = 32
const val size200 = 24
const val size300 = 20
const val size400 = 16
const val size500 = 12

val ts100 = baseTextStyle.copy(
    fontSize = size100.sp
)
val ts200 = baseTextStyle.copy(
    fontSize = size200.sp
)
val ts300 = baseTextStyle.copy(
    fontSize = size300.sp
)
val ts400 = baseTextStyle.copy(
    fontSize = size400.sp
)
val ts500 = baseTextStyle.copy(
    fontSize = size500.sp
)

val h1_50 = baseBoldStyle.copy(
    fontSize = size50.sp
)
val h1_100 = baseBoldStyle.copy(
    fontSize = size100.sp
)
val h1_200 = baseBoldStyle.copy(
    fontSize = size200.sp
)

val h2_200 = baseSemiBoldStyle.copy(
    fontSize = size200.sp
)

val h2_300 = baseSemiBoldStyle.copy(
    fontSize = size300.sp
)

val h2_400 = baseSemiBoldStyle.copy(
    fontSize = size400.sp
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)