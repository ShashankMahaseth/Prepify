package com.example.prepify.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.prepify.presentation.screens.HomeScreen
import com.example.prepify.presentation.screens.LoginScreen
import com.example.prepify.presentation.screens.SplashScreen

@Composable
fun AppNavigation() {
    val backStack = rememberNavBackStack(SplashScreen)

    NavDisplay(
        backStack = backStack,
        entryProvider = entryProvider {
            entry<SplashScreen> {
                SplashScreen(modifier = Modifier){
                    backStack.clear()
                    backStack.add(LoginScreen)
                }

            }
            entry<LoginScreen> {
                LoginScreen(){
                    backStack.clear()
                    backStack.add(HomeScreen)
                }

            }
            entry<HomeScreen> {
                HomeScreen()
            }
        }
    )
}
