package com.example.news_app.data.repository

import com.example.news_app.model.DetailNews
import com.example.news_app.presentation.favorite_screen.FavoriteUiState

interface RoomRepository {

    fun getFavoriteNews(): FavoriteUiState

    fun getNewsByTitle(title: String): DetailNews?

    fun insertFavoriteNews(news: DetailNews)

    fun deleteFavoriteNews(news: DetailNews)
}