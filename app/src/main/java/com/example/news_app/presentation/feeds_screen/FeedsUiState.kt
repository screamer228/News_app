package com.example.news_app.presentation.feeds_screen

import com.example.news_app.model.ColumnNews
import com.example.news_app.model.LatestNews

data class FeedsUiState(
    val latestNews: List<LatestNews> = listOf(),
    val columnNews: List<ColumnNews> = listOf()
)
