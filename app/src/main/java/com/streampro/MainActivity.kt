package com.streampro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.streampro.presentation.features.home.HomeScreen
import com.streampro.presentation.features.player.PlayerScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Manage Theme State
            val isSystemDark = androidx.compose.foundation.isSystemInDarkTheme()
            var isDarkTheme by androidx.compose.runtime.remember { androidx.compose.runtime.mutableStateOf(isSystemDark) }

            com.streampro.presentation.theme.StreamProTheme(darkTheme = isDarkTheme) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    StreamProApp(
                        isDarkTheme = isDarkTheme,
                        onThemeChange = { isDarkTheme = it }
                    )
                }
            }
        }
    }
}

@Composable
fun StreamProApp(
    isDarkTheme: Boolean,
    onThemeChange: (Boolean) -> Unit
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(
                onMovieClick = { cloudKey ->
                    navController.navigate("player/$cloudKey")
                },
                onSettingsClick = {
                    navController.navigate("settings")
                }
            )
        }
        composable("player/{cloudKey}") { backStackEntry ->
            val cloudKey = backStackEntry.arguments?.getString("cloudKey") ?: ""
            PlayerScreen(cloudKey = cloudKey)
        }
        composable("settings") {
            com.streampro.presentation.features.settings.SettingsScreen(
                isDarkTheme = isDarkTheme,
                onThemeChange = onThemeChange,
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}
