package com.example.news_app.data.repository.news

import com.example.news_app.data.mapper.CategoryNewsMapper
import com.example.news_app.data.mapper.ColumnNewsMapper
import com.example.news_app.data.mapper.DetailNewsMapper
import com.example.news_app.data.mapper.LatestNewsMapper
import com.example.news_app.data.network.NewsApi
import com.example.news_app.domain.entity.DetailNewsEntity
import com.example.news_app.domain.entity.column.ColumnNewsListEntity
import com.example.news_app.domain.entity.LatestNewsEntity
import com.example.news_app.domain.entity.column.ColumnNewsEntity
import com.example.news_app.domain.repository.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsApi: NewsApi,
    private val latestNewsMapper: LatestNewsMapper,
    private val columnNewsMapper: ColumnNewsMapper,
    private val categoryNewsMapper: CategoryNewsMapper,
    private val detailNewsMapper: DetailNewsMapper
) : NewsRepository {

    override suspend fun getLatestNews(country: String): List<LatestNewsEntity> {
        val response = newsApi.getLatestNews(country)
        if (response.isSuccessful) {
            val newsResult = response.body()!!
            return latestNewsMapper.mapDataToDomainList(newsResult)
        }
        return listOf()
    }

    override suspend fun getCategoryNews(category: String): List<ColumnNewsEntity> {
        val response = newsApi.getCategoryNews(category)
        if (response.isSuccessful) {
            val newsResult = response.body()!!
            return categoryNewsMapper.mapDataToDomainList(newsResult)
        }
        return listOf()
    }

    override suspend fun getColumnNews(title: String): ColumnNewsListEntity {
        val response = newsApi.getColumnNews(title, COUNTRY, SORT_BY)
        if (response.isSuccessful) {
            val newsResult = response.body()!!
            return columnNewsMapper.mapDataToDomainList(newsResult)
        }
        return ColumnNewsListEntity(
            listOf(),
            0
        )
    }

    override suspend fun getDetailNews(title: String): DetailNewsEntity {
        val response = newsApi.getColumnNews(title, COUNTRY, SORT_BY)
        if (response.isSuccessful) {
            val newsResult = response.body()!!
            return detailNewsMapper.mapDtoToDomain(newsResult)
        }
        return DetailNewsEntity()
    }

    companion object {
        const val COUNTRY = "us"
        const val SORT_BY = "popularity"
    }
}