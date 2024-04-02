package com.example.news_app.presentation.model

data class DetailNews(
    val title: String,
    val imageUrl: String?,
    val author: String,
    val publishedAt: String,
    val description: String
)
