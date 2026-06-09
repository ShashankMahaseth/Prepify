package com.example.prepify.ui.theme

import androidx.compose.material3.adaptive.currentWindowSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp

@Immutable
enum class WindowSize {
    Compact, Medium, Expanded
}

@Immutable
data class AppWindowSizeClass(
    val widthSizeClass: WindowSize,
    val heightSizeClass: WindowSize
)

val LocalAppWindowSizeClass = staticCompositionLocalOf {
    AppWindowSizeClass(WindowSize.Compact, WindowSize.Compact)
}

@Composable
fun rememberWindowSizeClass(): AppWindowSizeClass {
    val configuration = LocalConfiguration.current
    val widthDp = configuration.screenWidthDp.dp
    val heightDp = configuration.screenHeightDp.dp

    val widthClass = when {
        widthDp < 600.dp -> WindowSize.Compact
        widthDp < 840.dp -> WindowSize.Medium
        else -> WindowSize.Expanded
    }

    val heightClass = when {
        heightDp < 480.dp -> WindowSize.Compact
        heightDp < 900.dp -> WindowSize.Medium
        else -> WindowSize.Expanded
    }

    return AppWindowSizeClass(widthClass, heightClass)
}
