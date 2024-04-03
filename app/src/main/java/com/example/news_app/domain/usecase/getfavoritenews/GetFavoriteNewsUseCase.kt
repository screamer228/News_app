package com.example.news_app.domain.usecase.getfavoritenews

import com.example.news_app.presentation.model.DetailNews

interface GetFavoriteNewsUseCase {

    suspend fun getFavoriteNews(title: String) : DetailNews?

}