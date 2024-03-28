package com.example.news_app.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news")
data class DetailNews(
    @PrimaryKey val title: String,
    val imageUrl: String?,
    val author: String,
    val publishedAt: String,
    val description: String
)
