package com.example.prepify.ui.theme

import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf

@Immutable
data class AppMotion(
    val durationFast: Int = 150,
    val durationMedium: Int = 300,
    val durationSlow: Int = 500,
    val easingStandard: Easing = FastOutSlowInEasing,
    val easingAccelerate: Easing = LinearOutSlowInEasing,
    val easingDecelerate: Easing = FastOutSlowInEasing
)

val LocalAppMotion = staticCompositionLocalOf { AppMotion() }
