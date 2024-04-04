package com.example.news_app.domain.entity.column

data class ColumnNewsListEntity(
    val news: List<ColumnNewsEntity>,
    val totalResults: Int
)