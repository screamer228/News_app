package com.example.news_app.domain.usecase.savefavoritenews

import com.example.news_app.presentation.model.DetailNews

interface SaveFavoriteNewsUseCase {

    suspend fun saveFavoriteNews(news: DetailNews)

}