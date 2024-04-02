package com.example.news_app.domain.usecase

import com.example.news_app.presentation.favorite_screen.FavoriteUiState
import com.example.news_app.presentation.model.ColumnNews

interface GetFavoriteNewsUseCase {

    suspend fun getFavoriteNews() : FavoriteUiState

}