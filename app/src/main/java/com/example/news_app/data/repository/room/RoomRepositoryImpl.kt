package com.example.news_app.data.repository.room

import com.example.news_app.data.local.NewsDao
import com.example.news_app.domain.repository.RoomRepository
import com.example.news_app.data.mapper.ColumnNewsMapper
import com.example.news_app.data.mapper.DetailNewsMapper
import com.example.news_app.domain.entity.DetailNewsEntity
import com.example.news_app.domain.entity.column.ColumnNewsEntity
import javax.inject.Inject

class RoomRepositoryImpl @Inject constructor(
    private val newsDao: NewsDao,
    private val columnNewsMapper: ColumnNewsMapper,
    private val detailNewsMapper: DetailNewsMapper
) : RoomRepository {

    override suspend fun getFavoriteNews(): List<ColumnNewsEntity> {
        val news = newsDao.getFavoriteNews()

        if (news != null) return columnNewsMapper.mapDboToDomainList(news)
        else return listOf()
    }

    override suspend fun getNewsByTitle(title: String): DetailNewsEntity? {
        val news = newsDao.getNewsByTitle(title)
        return detailNewsMapper.mapDataToDomain(news)
    }

    override suspend fun insertFavoriteNews(news: DetailNewsEntity) {
        newsDao.insertFavoriteNews(detailNewsMapper.mapDomainToData(news))
    }

    override suspend fun deleteFavoriteNews(news: DetailNewsEntity) {
        newsDao.deleteFavoriteNews(detailNewsMapper.mapDomainToData(news))
    }
}