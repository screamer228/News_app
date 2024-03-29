package com.example.news_app.presentation.detail_screen

import com.example.news_app.model.DetailNews

data class DetailUiState(
    val news: DetailNews = DetailNews(
        "",
        null,
        "",
        "",
        ""
    ),
    val isFavorite: Boolean = false
)
