package com.example.bookshelf.presentation.core.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.bookshelf.R

val gabarito = FontFamily(
    Font(resId = R.font.gabarito)
)

val lato = FontFamily(
    Font(resId = R.font.latoregular)
)

// Set of Material typography styles to start with
val Typography = Typography(
    titleMedium = TextStyle(
        fontFamily = gabarito,
        fontSize = 28.sp,
        fontWeight = FontWeight.Normal
    ),
    bodyLarge = TextStyle(
        fontFamily = gabarito,
        fontSize = 48.sp,
        fontWeight = FontWeight.Normal
    ),
    bodyMedium = TextStyle(
        fontFamily = lato,
        fontSize = 26.sp,
        fontWeight = FontWeight.Bold,
        letterSpacing = 2.sp
    ),
    bodySmall = TextStyle(
        fontFamily = gabarito,
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal
    ),
    labelLarge = TextStyle(
        fontFamily = lato,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal
    ),
    labelMedium = TextStyle(
        fontFamily = lato,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        textAlign = TextAlign.Justify,
        lineHeight = 32.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)