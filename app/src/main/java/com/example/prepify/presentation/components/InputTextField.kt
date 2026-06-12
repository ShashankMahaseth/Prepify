package com.example.prepify.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.prepify.ui.theme.appColors
import com.example.prepify.ui.theme.dimensions

@Composable
fun InputTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
        .padding(vertical = MaterialTheme.dimensions.medium),
    isOutlined: Boolean = false,
    label: String? = null,
    placeholder: String? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = true,
    isError: Boolean = false,
    errorMessage: String? = null,
    containerColor: Color = MaterialTheme.appColors.inputBackground,
    shape: Shape = MaterialTheme.shapes.small
) {
    val labelComponent: @Composable (() -> Unit)? = label?.let { { Text(text = it) } }
    val placeholderComponent: @Composable (() -> Unit)? = placeholder?.let {
        { Text(
            text = it,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.outline
        ) }
    }

    Column {
        if (isOutlined) {
            OutlinedTextField(
                value = value,
                onValueChange = onValueChange,
                modifier = modifier.fillMaxWidth(),
                label = labelComponent,
                placeholder = placeholderComponent,
                leadingIcon = leadingIcon,
                trailingIcon = trailingIcon,
                visualTransformation = visualTransformation,
                keyboardOptions = keyboardOptions,
                keyboardActions = keyboardActions,
                singleLine = singleLine,
                isError = isError,
                shape = shape,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = containerColor,
                    unfocusedContainerColor = containerColor,
                    disabledContainerColor = containerColor,
                    errorContainerColor = containerColor,
                )
            )
        } else {
            TextField(
                value = value,
                onValueChange = onValueChange,
                modifier = modifier.fillMaxWidth(),
                label = labelComponent,
                placeholder = placeholderComponent,
                leadingIcon = leadingIcon,
                trailingIcon = trailingIcon,
                visualTransformation = visualTransformation,
                keyboardOptions = keyboardOptions,
                keyboardActions = keyboardActions,
                singleLine = singleLine,
                isError = isError,
                shape = shape,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = containerColor,
                    unfocusedContainerColor = containerColor,
                    disabledContainerColor = containerColor,
                    errorContainerColor = containerColor,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent
                )
            )
        }

        if (isError && errorMessage != null) {
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.padding(start = 16.dp, top = 4.dp)
            )
        }
    }
}
