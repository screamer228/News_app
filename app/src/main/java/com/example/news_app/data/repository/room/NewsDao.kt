package com.example.news_app.data.repository.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.news_app.model.DetailNews

@Dao
interface NewsDao {

    @Query("SELECT * FROM news")
    fun getFavoriteNews(): List<DetailNews>?

    @Query("SELECT * FROM news WHERE title = :title")
    fun getNewsByTitle(title: String): DetailNews?

    @Insert
    fun insertFavoriteNews(news: DetailNews)

    @Delete
    fun deleteFavoriteNews(news: DetailNews)
}