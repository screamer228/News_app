package com.example.news_app.domain.repository

import com.example.news_app.domain.entity.category.CategoryNewsListEntity
import com.example.news_app.domain.entity.column.ColumnNewsListEntity
import com.example.news_app.domain.entity.latest.LatestNewsListEntity

interface NewsRepository {

    suspend fun getLatestNews(country: String) : LatestNewsListEntity

    suspend fun getColumnNews(title: String) : ColumnNewsListEntity

    suspend fun getCategoryNews(category: String) : CategoryNewsListEntity

}