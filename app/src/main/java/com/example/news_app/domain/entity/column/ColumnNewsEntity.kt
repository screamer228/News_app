package com.example.news_app.domain.entity.column

import com.example.news_app.domain.base.BaseEntity

data class ColumnNewsEntity(
    val title: String = "",
    val imageUrl: String? = "",
    val author: String? = "",
    val publishedAt: String = "",
)
//    : BaseEntity
