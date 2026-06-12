package com.example.prepify.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.navigation3.runtime.NavKey
import com.composables.icons.lucide.Bell
import com.composables.icons.lucide.CircleUser
import com.composables.icons.lucide.House
import com.composables.icons.lucide.List
import com.composables.icons.lucide.Lucide
import com.composables.icons.lucide.Settings
import com.composables.icons.lucide.Users
import com.example.prepify.R
import com.example.prepify.presentation.components.AppBottomNavigationBar
import com.example.prepify.presentation.components.AppTopAppBar
import com.example.prepify.presentation.components.AppTopBarIconButton
import com.example.prepify.presentation.components.NavigationItem
import com.example.prepify.presentation.navigation.AlarmScreen
import com.example.prepify.presentation.navigation.CommunityScreen
import com.example.prepify.presentation.navigation.HomeScreen as HomeNavKey
import com.example.prepify.presentation.navigation.PremiumScreen
import com.example.prepify.presentation.navigation.SettingsScreen
import com.example.prepify.ui.theme.dimensions

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    var currentScreen by remember { mutableStateOf<NavKey>(HomeNavKey) }

    val navigationItems = remember {
        listOf(
            NavigationItem("Home", Lucide.House, HomeNavKey),
            NavigationItem("Discussion", Lucide.Users, CommunityScreen),
            NavigationItem("premium", "loading.json", PremiumScreen, isLottie = true),
            NavigationItem("Notification", Lucide.Bell, AlarmScreen),
            NavigationItem("Settings", Lucide.Settings, SettingsScreen)
        )
    }

    Scaffold(
        topBar = {
            AppTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.surfaceContainerLowest,),
                title = R.drawable.prepifytexticon,
                titleModifier = Modifier.scale(0.6f),
                titleTint = Color.Unspecified,
                navigationIcon = Lucide.List,
                navigationIconModifier = Modifier.size(MaterialTheme.dimensions.iconSizeLarge),
                onNavigationClick = {
                    // TODO: Handle menu click
                },
                actions = {
                    AppTopBarIconButton(
                        onClick = { /* TODO: Profile click */ },
                        isSelected = false // You can control this with state
                    ) {
                        Icon(
                            imageVector = Lucide.CircleUser,
                            contentDescription = "Profile",
                            modifier = Modifier.size(MaterialTheme.dimensions.iconSizeLarge),
                        )
                    }
                },
            )
        },
        bottomBar = {
            AppBottomNavigationBar(
                items = navigationItems,
                currentDestination = currentScreen,
                onItemClick = { item ->
                    currentScreen = item.destination
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when (currentScreen) {
                HomeNavKey -> Text("Home Content", modifier = Modifier.align(Alignment.Center))
                CommunityScreen -> Text("Community Content", modifier = Modifier.align(Alignment.Center))
                PremiumScreen -> Text("Premium Content", modifier = Modifier.align(Alignment.Center))
                AlarmScreen -> Text("Alarm Content", modifier = Modifier.align(Alignment.Center))
                SettingsScreen -> Text("Settings Content", modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}
