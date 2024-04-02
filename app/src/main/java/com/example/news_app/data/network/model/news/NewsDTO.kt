package com.example.news_app.data.network.model.news

data class NewsDTO(
    val articles: List<Article>,
    val status: String = "",
    val totalResults: Int = 0
)