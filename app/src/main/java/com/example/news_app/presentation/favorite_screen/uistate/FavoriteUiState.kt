package com.example.news_app.presentation.favorite_screen.uistate

import com.example.news_app.data.local.model.DetailNewsDBO
import com.example.news_app.presentation.model.ColumnNews

data class FavoriteUiState(
    val news: List<ColumnNews>
)
