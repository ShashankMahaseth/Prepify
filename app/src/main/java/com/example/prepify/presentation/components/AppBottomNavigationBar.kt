package com.example.prepify.presentation.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import androidx.navigation3.runtime.NavKey
import com.example.prepify.R
import com.example.prepify.ui.theme.DiamondPurple
import com.example.prepify.ui.theme.appColors
import com.example.prepify.ui.theme.dimensions

data class NavigationItem(
    val title: String,
    val icon: Any,
    val destination: NavKey,
    val isLottie: Boolean = false
)

@Composable
fun AppBottomNavigationBar(
    items: List<NavigationItem>,
    currentDestination: NavKey?,
    onItemClick: (NavigationItem) -> Unit,
    modifier: Modifier = Modifier
) {
    val selectedGradient = Brush.linearGradient(
        colors = listOf(
            Color(0xFF800080),
            Color(0xFF8B008B),
            Color(0xFFFF00FF),
            Color(0xFFDDA0DD)
        )
    )

    NavigationBar(
        modifier = modifier,
        contentColor = MaterialTheme.colorScheme.onSurface,
        tonalElevation = MaterialTheme.dimensions.medium,
        containerColor = MaterialTheme.colorScheme.surfaceContainerLowest
    ) {
        items.forEach { item ->
            val isSelected = currentDestination == item.destination

            NavigationBarItem(

                selected = isSelected,
                onClick = { onItemClick(item) },
                icon = {
                    if (item.isLottie) {
                        PremiumLottieIcon(isSelected = isSelected)
                    } else {
                        val iconScale by animateFloatAsState(
                            targetValue = if (isSelected) 1.1f else 1f,
                            label = "icon_scale"
                        )
                        Icon(
                            imageVector = item.icon as ImageVector,
                            contentDescription = item.title,
                            modifier = Modifier
                                .size(26.dp)
                                .scale(iconScale)
                        )
                    }
                },
                label = {
                    Text(
                        text = item.title,
                        style = if (isSelected && item.isLottie) {
                            MaterialTheme.typography.labelSmall.copy(brush = selectedGradient)
                        } else {
                            MaterialTheme.typography.labelSmall
                        }
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.appColors.bottomNavSelected,
                    selectedTextColor = if (item.isLottie) Color.Unspecified else MaterialTheme.appColors.bottomNavSelected,
                    unselectedIconColor = MaterialTheme.appColors.bottomNavUnselected,
                    unselectedTextColor =  MaterialTheme.appColors.bottomNavUnselected,
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}

@Composable
private fun PremiumLottieIcon(isSelected: Boolean) {
    val composition by rememberLottieComposition(LottieCompositionSpec.Asset("diamonds.json"))
    val lottieScale by animateFloatAsState(
        targetValue = if (isSelected) 1.6f else 1.4f,
        label = "lottie_scale"
    )

    LottieAnimation(
        composition = composition,
        iterations = LottieConstants.IterateForever,
        modifier = Modifier
            .size(26.dp)
            .scale(lottieScale),
        isPlaying = isSelected,
        restartOnPlay = false
    )
}
