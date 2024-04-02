package com.example.news_app.presentation.model

data class ColumnNewsState(
    val columnNews: List<ColumnNews> = listOf(),
    val totalResults: Int = 0
)
