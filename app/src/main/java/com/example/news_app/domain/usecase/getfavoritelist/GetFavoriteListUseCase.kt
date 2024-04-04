package com.example.news_app.domain.usecase.getfavoritelist

import com.example.news_app.presentation.favorite_screen.uistate.FavoriteUiState

interface GetFavoriteListUseCase {

    suspend fun getFavoriteList(): FavoriteUiState

}