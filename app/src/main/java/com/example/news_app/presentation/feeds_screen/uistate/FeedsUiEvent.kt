package com.example.news_app.presentation.feeds_screen.uistate

sealed class FeedsUiEvent {
    data class ButtonCategoryClick(val category: String) : FeedsUiEvent()
    data object SeeAllClick : FeedsUiEvent()
}