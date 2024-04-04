package com.example.news_app.presentation.favorite_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.news_app.presentation.favorite_screen.viewmodel.FavoriteViewModel
import com.example.news_app.presentation.feeds_screen.NewsLazyColumn

@Composable
fun FavoriteScreen(
    viewModel: FavoriteViewModel = hiltViewModel(),
    navController: NavController
) {

    val uiState by viewModel.uiState.collectAsState()

    viewModel.getFavoritesList()

    Column(
        modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        .padding(
            start = 16.dp,
            top = 16.dp,
            end = 16.dp
        )
    ) {
        if (uiState.news.isEmpty()) {
            Text(
                text = "Nothing was found"
            )
        }
        else {
            Text(
                text = "Favorite Screen"
            )
            NewsLazyColumn(
                news = uiState.news,
                navController
            )
        }
    }
}
