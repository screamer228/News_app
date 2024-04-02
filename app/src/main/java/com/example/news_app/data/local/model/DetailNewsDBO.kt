package com.example.news_app.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news")
data class DetailNewsDBO(
    @PrimaryKey val title: String,
    val imageUrl: String?,
    val author: String,
    val publishedAt: String,
    val description: String
)
