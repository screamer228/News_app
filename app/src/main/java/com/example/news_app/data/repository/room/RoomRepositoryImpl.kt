package com.example.news_app.data.repository.room

import com.example.news_app.data.local.NewsDao
import com.example.news_app.domain.repository.RoomRepository
import com.example.news_app.data.local.model.DetailNewsDBO
import com.example.news_app.data.mapper.ColumnNewsMapper
import com.example.news_app.domain.entity.column.ColumnNewsEntity
import com.example.news_app.presentation.favorite_screen.FavoriteUiState
import javax.inject.Inject

class RoomRepositoryImpl @Inject constructor(
    private val newsDao: NewsDao,
    private val columnNewsMapper: ColumnNewsMapper
) : RoomRepository {

    override suspend fun getFavoriteNews(): List<ColumnNewsEntity> {
        val news = newsDao.getFavoriteNews()

        if (news != null) return columnNewsMapper.mapDboToDomainList(news)
        else return listOf()
    }

    override suspend fun getNewsByTitle(title: String): DetailNewsDBO? {
        return newsDao.getNewsByTitle(title)
    }

    override suspend fun insertFavoriteNews(news: DetailNewsDBO) {
        newsDao.insertFavoriteNews(news)
    }

    override suspend fun deleteFavoriteNews(news: DetailNewsDBO) {
        newsDao.deleteFavoriteNews(news)
    }
}