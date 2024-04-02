package com.example.news_app.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.news_app.data.local.model.DetailNewsDBO

@Dao
interface NewsDao {

    @Query("SELECT * FROM news")
    fun getFavoriteNews(): List<DetailNewsDBO>?

    @Query("SELECT * FROM news WHERE title = :title")
    fun getNewsByTitle(title: String): DetailNewsDBO?

    @Insert
    fun insertFavoriteNews(news: DetailNewsDBO)

    @Delete
    fun deleteFavoriteNews(news: DetailNewsDBO)
}