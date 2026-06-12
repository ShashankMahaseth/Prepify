package com.example.prepify.presentation.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.node.DelegatableNode
import androidx.compose.ui.node.DrawModifierNode
import androidx.compose.ui.res.painterResource
import com.example.prepify.ui.theme.AppTheme
import com.example.prepify.ui.theme.appColors
import com.example.prepify.ui.theme.elevation
import androidx.compose.foundation.IndicationNodeFactory
import com.example.prepify.ui.theme.dimensions

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopAppBar(
    modifier: Modifier = Modifier,
    title: Any? = null,
    titleModifier: Modifier = Modifier.size(AppTheme.dimensions.iconSizeMedium),
    titleTint: Color = MaterialTheme.appColors.topAppBarTitle,
    navigationIcon: Any? = null,
    navigationIconModifier: Modifier = Modifier.size(AppTheme.dimensions.iconSizeSmall),
    isNavigationIconSelected: Boolean = false,
    navigationIconSelectedTint: Color = MaterialTheme.appColors.bottomNavSelected,
    navigationIconContentDescription: String? = null,
    onNavigationClick: () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    colors: TopAppBarColors? = null,
    scrollBehavior: TopAppBarScrollBehavior? = null,
) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.surface.copy(alpha = 0.98f),
    ) {
        CenterAlignedTopAppBar(
            title = {
                title?.let { icon ->
                    AppIcon(
                        icon = icon,
                        contentDescription = null,
                        modifier = titleModifier,
                        tint = titleTint
                    )
                }
            },
            navigationIcon = {
                navigationIcon?.let { icon ->
                    AppTopBarIconButton(
                        onClick = onNavigationClick,
                        isSelected = isNavigationIconSelected,
                        selectedTint = navigationIconSelectedTint,
                        unselectedTint = MaterialTheme.appColors.bottomNavUnselected
                    ) {
                        AppIcon(
                            icon = icon,
                            contentDescription = navigationIconContentDescription,
                            modifier = navigationIconModifier,
                            tint = MaterialTheme.appColors.bottomNavUnselected
                        )
                    }
                }
            },
            actions = actions,
            colors = colors ?: TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Color.Transparent, // Surface handles the color
                titleContentColor = MaterialTheme.appColors.topAppBarTitle,
                navigationIconContentColor = MaterialTheme.appColors.topAppBarIcon,
                actionIconContentColor = MaterialTheme.appColors.topAppBarIcon,
            ),
            scrollBehavior = scrollBehavior
        )
    }
}

@Composable
fun AppTopBarIconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    selectedTint: Color = MaterialTheme.appColors.bottomNavSelected,
    unselectedTint: Color = MaterialTheme.appColors.bottomNavUnselected,
    content: @Composable () -> Unit
) {
    val iconScale by animateFloatAsState(
        targetValue = if (isSelected) 1.2f else 1.0f,
        label = "icon_scale"
    )

    CompositionLocalProvider(
        LocalContentColor provides if (isSelected) selectedTint else unselectedTint,
        LocalIndication provides NoIndication
    ) {
        IconButton(
            onClick = onClick,
            modifier = modifier.scale(iconScale),
            interactionSource = remember { MutableInteractionSource() }
        ) {
            content()
        }
    }
}

@Composable
fun AppIcon(
    icon: Any,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current
) {
    when (icon) {
        is ImageVector -> {
            if (tint == Color.Unspecified) {
                Image(
                    imageVector = icon,
                    contentDescription = contentDescription,
                    modifier = modifier
                )
            } else {
                Icon(
                    imageVector = icon,
                    contentDescription = contentDescription,
                    modifier = modifier,
                    tint = tint
                )
            }
        }

        is Painter -> {
            if (tint == Color.Unspecified) {
                Image(
                    painter = icon,
                    contentDescription = contentDescription,
                    modifier = modifier
                )
            } else {
                Icon(
                    painter = icon,
                    contentDescription = contentDescription,
                    modifier = modifier,
                    tint = tint
                )
            }
        }

        is Int -> {
            val painter = painterResource(id = icon)
            if (tint == Color.Unspecified) {
                Image(
                    painter = painter,
                    contentDescription = contentDescription,
                    modifier = modifier
                )
            } else {
                Icon(
                    painter = painter,
                    contentDescription = contentDescription,
                    modifier = modifier,
                    tint = tint
                )
            }
        }
    }
}

private object NoIndication : IndicationNodeFactory {
    override fun create(interactionSource: InteractionSource): DelegatableNode {
        return object : Modifier.Node(), DrawModifierNode {
            override fun ContentDrawScope.draw() {
                drawContent()
            }
        }
    }

    override fun equals(other: Any?): Boolean = other === this
    override fun hashCode(): Int = System.identityHashCode(this)
}
