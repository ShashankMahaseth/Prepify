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
    val card: Color,
    val screenBackground: Color,
    val primaryButton: Color,
    val onPrimaryButton: Color,
    val inputBackground: Color,
    val secondaryButtonBackground: Color,
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
    shimmer = Color(0xFFF5F5F5),
    card = Color.White,
    screenBackground = Color(0xFFF2F2F7),
    primaryButton = Color(0xFF9365E2),
    onPrimaryButton = Color.White,
    inputBackground = Color(0xFFF2F2F7),
    secondaryButtonBackground = Color(0xFFF2F2F7)
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
    shimmer = Color(0xFF484848),
    card = Color(0xFF1C1C1E),
    screenBackground = Color(0xFF000000),
    primaryButton = Color(0xFF9365E2),
    onPrimaryButton = Color.White,
    inputBackground = Color(0xFF2C2C2E),
    secondaryButtonBackground = Color(0xFF2C2C2E)
)

val LocalAppColors = staticCompositionLocalOf {
    LightAppColors
}
