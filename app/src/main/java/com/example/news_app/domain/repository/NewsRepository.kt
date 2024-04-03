package com.example.news_app.domain.repository

import com.example.news_app.domain.entity.CategoryNewsEntity
import com.example.news_app.domain.entity.DetailNewsEntity
import com.example.news_app.domain.entity.LatestNewsEntity
import com.example.news_app.domain.entity.column.ColumnNewsEntity
import com.example.news_app.domain.entity.column.ColumnNewsListEntity

interface NewsRepository {

    suspend fun getLatestNews(country: String): List<LatestNewsEntity>

    suspend fun getColumnNews(title: String): ColumnNewsListEntity

    suspend fun getCategoryNews(category: String): List<ColumnNewsEntity>

    suspend fun getDetailNews(title: String): DetailNewsEntity?
}