package com.example.news_app.presentation.detail_screen.uistate

import com.example.news_app.presentation.model.DetailNews

data class DetailUiState(
    val news: DetailNews = DetailNews(
        "abcabc",
        null,
        "",
        "",
        ""
    ),
    val isFavorite: Boolean = false
)
