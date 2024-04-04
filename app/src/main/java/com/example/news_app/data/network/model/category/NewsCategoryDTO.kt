package com.example.news_app.data.network.model.category

import com.example.news_app.data.base.BaseModelDTO

data class NewsCategoryDTO(
    val sources: List<Source>,
    val status: String
)
//    : BaseModelDTO