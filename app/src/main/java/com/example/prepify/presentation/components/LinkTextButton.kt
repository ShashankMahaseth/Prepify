package com.example.prepify.presentation.components
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration

@Composable
fun LinkTextButton(
    text: String,
    modifier: Modifier,
    onClick: () -> Unit = {},
    style: TextStyle = MaterialTheme.typography.bodyMedium,
    color: Color = MaterialTheme.colorScheme.primary
){

    Text(
        text = text,
        style = style,
        color = color,
        textDecoration = TextDecoration.Underline,
        modifier = modifier.clickable(
            indication = null,
            interactionSource = remember { MutableInteractionSource() }
        ) {
            onClick()
        }
    )

}