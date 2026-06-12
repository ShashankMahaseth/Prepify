package com.example.prepify.presentation.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.prepify.ui.theme.appColors
import com.example.prepify.ui.theme.dimensions

@Composable
fun IconLabelButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier.fillMaxWidth(),
    shape: Shape = RoundedCornerShape(MaterialTheme.dimensions.small),
    @DrawableRes img: Int? = null,
    label: String,
    enabled: Boolean = true,
    style: TextStyle = MaterialTheme.typography.labelLarge,
    @StringRes contentDescription: Int? = null,
    containerColor: Color = MaterialTheme.appColors.secondaryButtonBackground,
    contentColor: Color = MaterialTheme.colorScheme.onSurface,
    iconTint: Color = Color.Unspecified,
    iconSize: Dp = MaterialTheme.dimensions.iconSizeLarge
) {


    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        shape = shape,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor
        ),
        contentPadding = PaddingValues(
            horizontal = MaterialTheme.dimensions.medium,
            vertical = 12.dp
        ),
        enabled = enabled
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            img?.let {
                Icon(
                    painter = painterResource(it),
                    contentDescription = contentDescription?.let { res -> stringResource(res) },
                    modifier = Modifier.size(iconSize),
                    tint = iconTint
                )
            }

            if (img != null && label != null) {
                Spacer(modifier = Modifier.width(MaterialTheme.dimensions.small))
            }

            Text(
                text = label,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}
