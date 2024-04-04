package com.example.news_app.presentation.feeds_screen.uistate

import com.example.news_app.presentation.model.ColumnNews
import com.example.news_app.presentation.model.LatestNews

data class FeedsUiState(
    val latestNews: List<LatestNews> = listOf(),
    val categoryNews: List<ColumnNews> = listOf()
)
