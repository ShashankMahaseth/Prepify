package com.example.prepify.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.composables.icons.lucide.Eye
import com.composables.icons.lucide.EyeOff
import com.composables.icons.lucide.LockKeyhole
import com.composables.icons.lucide.Lucide
import com.composables.icons.lucide.Mail
import com.example.prepify.R
import com.example.prepify.presentation.components.IconLabelButton
import com.example.prepify.presentation.components.InputTextField
import com.example.prepify.presentation.components.LinkTextButton
import com.example.prepify.presentation.components.ScreenDivider
import com.example.prepify.ui.theme.appColors
import com.example.prepify.ui.theme.appShapes
import com.example.prepify.ui.theme.dimensions
import com.example.prepify.ui.theme.elevation

@Composable
fun LoginScreen(onNavigateToHome: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        Card(
            modifier = Modifier.padding(MaterialTheme.dimensions.medium),
            shape = MaterialTheme.appShapes.medium,
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceContainerLowest
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = MaterialTheme.elevation.card
            )
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(
                    MaterialTheme.dimensions.medium
                )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.prepifytexticon),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .padding(vertical = MaterialTheme.dimensions.medium)
                        .scale(0.6f)
                )
                IconLabelButton(
                    img = R.drawable.google,
                    contentDescription = R.string.google_logo,
                    label = stringResource(R.string.google_button_label),
                    onClick = {},
                    modifier = Modifier
                        .height(MaterialTheme.dimensions.buttonHeight)
                )

                Spacer(modifier = Modifier.height(MaterialTheme.dimensions.medium))

                ScreenDivider(
                    modifier = Modifier
                        .weight(1f)
                        .padding(vertical = MaterialTheme.dimensions.medium),
                    text = "Or sign in with email"
                )

                InputTextField(
                    value = email,
                    onValueChange = { email = it },
                    modifier = Modifier.padding(vertical = MaterialTheme.dimensions.medium),
                    isOutlined = false,
                    placeholder = "Email",
                    leadingIcon = {
                        Icon(
                            imageVector = Lucide.Mail,
                            contentDescription = "email"
                        )
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = { focusManager.moveFocus(FocusDirection.Down) }
                    )
                )
                InputTextField(
                    value = password,
                    onValueChange = { password = it },
                    modifier = Modifier,
                    isOutlined = false,
                    placeholder = "Password",
                    leadingIcon = {
                        Icon(
                            imageVector = Lucide.LockKeyhole,
                            contentDescription = "password"
                        )
                    },
                    trailingIcon = {
                        val image = if (passwordVisible)
                            Lucide.Eye
                        else Lucide.EyeOff

                        val description = if (passwordVisible) "Hide password" else "Show password"

                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(
                                imageVector = image,
                                contentDescription = description,
                            )
                        }
                    },
                    visualTransformation = if (passwordVisible) VisualTransformation.None
                    else PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            focusManager.clearFocus()
                        }
                    )
                )

                LinkTextButton(
                    text="Forgot Password?",
                    onClick = {},
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.align(Alignment.End).padding(vertical = MaterialTheme.dimensions.medium),

                )

                IconLabelButton(
                    label = "Login",
                    contentDescription = R.string.login_button_label,
                    onClick = onNavigateToHome,
                    modifier = Modifier
                        .padding(vertical = MaterialTheme.dimensions.medium)
                        .height(
                            MaterialTheme.dimensions.buttonHeight
                        ),
                    containerColor = MaterialTheme.appColors.primaryButton,
                    contentColor = MaterialTheme.appColors.onPrimaryButton,

                )

            }

        }

    }
}
