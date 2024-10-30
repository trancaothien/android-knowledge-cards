package com.studio35.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class AppDimensions (
    // Custom dimensions here
    val spacing2XSmall: Dp = 4.dp,
    val spacingXSmall: Dp = 8.dp,
    val spacingSmall: Dp = 12.dp,
    val spacingMedium: Dp = 16.dp,
    val spacingLarge: Dp = 20.dp,
    val spacingXLarge: Dp = 24.dp,
    val spacing2XLarge: Dp = 28.dp,
    val spacing3XLarge: Dp = 32.dp,
)

val LocalAppDimensions = staticCompositionLocalOf { AppDimensions() }
