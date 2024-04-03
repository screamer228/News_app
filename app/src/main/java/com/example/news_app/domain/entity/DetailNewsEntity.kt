package com.example.news_app.domain.entity

data class DetailNewsEntity(
    val title: String = "",
    val imageUrl: String? = null,
    val author: String = "",
    val publishedAt: String = "",
    val description: String = ""
)