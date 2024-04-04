package com.example.news_app.data.network.model.news

import com.example.news_app.data.base.BaseModelDTO

data class NewsDTO(
    val articles: List<Article>,
    val status: String = "",
    val totalResults: Int = 0
)
//    : BaseModelDTO