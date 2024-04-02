package com.example.news_app.domain.repository

import com.example.news_app.data.local.model.DetailNewsDBO
import com.example.news_app.domain.entity.column.ColumnNewsEntity
import com.example.news_app.presentation.favorite_screen.FavoriteUiState

interface RoomRepository {

    suspend fun getFavoriteNews(): List<ColumnNewsEntity>

    suspend fun getNewsByTitle(title: String): DetailNewsDBO?

    suspend fun insertFavoriteNews(news: DetailNewsDBO)

    suspend fun deleteFavoriteNews(news: DetailNewsDBO)
}