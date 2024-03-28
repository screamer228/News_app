package com.example.news_app.data.repository

import com.example.news_app.data.repository.room.NewsDao
import com.example.news_app.model.DetailNews
import javax.inject.Inject

class RoomRepositoryImpl @Inject constructor(
    private val newsDao: NewsDao
): RoomRepository {

    override fun getFavoriteNews(): List<DetailNews>? {
        return newsDao.getFavoriteNews()
    }

    override fun insertFavoriteNews(news: DetailNews) {
        newsDao.insertFavoriteNews(news)
    }
}