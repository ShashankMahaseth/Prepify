package com.example.prepify.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

@Immutable
data class AppShapes(
    val extraSmall: Shape = RoundedCornerShape(4.dp),
    val small: Shape = RoundedCornerShape(8.dp),
    val medium: Shape = RoundedCornerShape(12.dp),
    val large: Shape = RoundedCornerShape(16.dp),
    val extraLarge: Shape = RoundedCornerShape(24.dp),
    val full: Shape = RoundedCornerShape(100),
    val cornerShape1: Shape = RoundedCornerShape(topStart = 16.dp, bottomEnd = 16.dp),
    val cornerShape2: Shape = RoundedCornerShape(topEnd = 16.dp, bottomStart = 16.dp),
)

val LocalAppShapes = staticCompositionLocalOf { AppShapes() }
