package com.example.prepify.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class AppColors(
    val success: Color,
    val onSuccess: Color,
    val warning: Color,
    val onWarning: Color,
    val info: Color,
    val onInfo: Color,
    val divider: Color,
    val skeleton: Color,
    val shimmer: Color,
    // Add more custom semantic colors here
)

val LightAppColors = AppColors(
    success = Color(0xFF4CAF50),
    onSuccess = Color.White,
    warning = Color(0xFFFFC107),
    onWarning = Color.Black,
    info = Color(0xFF2196F3),
    onInfo = Color.White,
    divider = Color(0xFFEEEEEE),
    skeleton = Color(0xFFE0E0E0),
    shimmer = Color(0xFFF5F5F5)
)

val DarkAppColors = AppColors(
    success = Color(0xFF81C784),
    onSuccess = Color.Black,
    warning = Color(0xFFFFD54F),
    onWarning = Color.Black,
    info = Color(0xFF64B5F6),
    onInfo = Color.Black,
    divider = Color(0xFF373737),
    skeleton = Color(0xFF424242),
    shimmer = Color(0xFF484848)
)

val LocalAppColors = staticCompositionLocalOf {
    LightAppColors
}
