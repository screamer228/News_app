package com.example.news_app.domain.usecase.deletefavoritenews

import com.example.news_app.presentation.model.DetailNews

interface DeleteFavoriteNewsUseCase {

    suspend fun deleteFavoriteNews(news: DetailNews)

}