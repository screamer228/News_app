package com.example.news_app.domain.entity.column

data class ColumnNewsEntity(
    val title: String = "",
    val imageUrl: String? = "",
    val author: String? = "",
    val publishedAt: String = "",
)