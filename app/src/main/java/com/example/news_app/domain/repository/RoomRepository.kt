package com.example.news_app.domain.repository

import com.example.news_app.domain.entity.DetailNewsEntity
import com.example.news_app.domain.entity.column.ColumnNewsEntity

interface RoomRepository {

    suspend fun getFavoriteNews(): List<ColumnNewsEntity>

    suspend fun getNewsByTitle(title: String): DetailNewsEntity?

    suspend fun insertFavoriteNews(news: DetailNewsEntity)

    suspend fun deleteFavoriteNews(news: DetailNewsEntity)
}