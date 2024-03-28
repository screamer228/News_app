package com.example.news_app.data.repository.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.news_app.model.DetailNews

@Dao
interface NewsDao {

    @Query("SELECT * FROM news")
    fun getFavoriteNews(): List<DetailNews>?

    @Insert
    fun insertFavoriteNews(news: DetailNews)
}