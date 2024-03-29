package com.example.news_app.presentation.host

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.news_app.navigation.Navigation
import com.example.news_app.navigation.Screen
import com.example.news_app.ui.theme.News_appTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HostActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            News_appTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()
                    val bottomItems = listOf(
                        Screen.Feeds,
                        Screen.Favorite,
                        Screen.Profile
                    )

                    Navigation(
                        navController,
                        bottomItems
                    )
                }
            }
        }
    }
}

