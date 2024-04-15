package com.example.news_app.presentation.detail_screen.uistate

import com.example.news_app.presentation.model.DetailNews

data class DetailUiState(
    val news: DetailNews = DetailNews(
        "",
        "https://s0.rbk.ru/v6_top_pics/media/img/3/81/755719504466813.jpeg",
        "",
        "",
        ""
    ),
    val isFavorite: Boolean = false,
    val isLoading: Boolean = true
)
