package com.example.news_app.data.repository

import com.example.news_app.data.room.NewsDao
import com.example.news_app.model.DetailNews
import com.example.news_app.presentation.favorite_screen.FavoriteUiState
import javax.inject.Inject

class RoomRepositoryImpl @Inject constructor(
    private val newsDao: NewsDao
) : RoomRepository {

    override fun getFavoriteNews(): FavoriteUiState {
        val news = newsDao.getFavoriteNews()

        if (news != null) return FavoriteUiState(news)
        else return FavoriteUiState(listOf())
    }

    override fun getNewsByTitle(title: String): DetailNews? {
        return newsDao.getNewsByTitle(title)
    }

    override fun insertFavoriteNews(news: DetailNews) {
        newsDao.insertFavoriteNews(news)
    }

    override fun deleteFavoriteNews(news: DetailNews) {
        newsDao.deleteFavoriteNews(news)
    }
}