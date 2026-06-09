package com.example.prepify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.prepify.presentation.navigation.AppNavigation
import com.example.prepify.ui.theme.PrepifyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PrepifyTheme {

                AppNavigation()

            }
        }
    }
}

