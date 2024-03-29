package com.example.news_app.presentation.detail_screen

sealed class DetailUiEvent {
    data class LikeClick(val isFavorite: Boolean): DetailUiEvent()
    data object BackClick: DetailUiEvent()
}