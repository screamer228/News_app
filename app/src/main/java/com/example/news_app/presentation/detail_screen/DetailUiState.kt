package com.example.news_app.presentation.detail_screen

import com.example.news_app.data.local.model.DetailNewsDBO

data class DetailUiState(
    val news: DetailNewsDBO = DetailNewsDBO(
        "",
        null,
        "",
        "",
        ""
    ),
    val isFavorite: Boolean = false
)
