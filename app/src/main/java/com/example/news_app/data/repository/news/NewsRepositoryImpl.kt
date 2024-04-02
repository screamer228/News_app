package com.example.news_app.data.repository.news

import android.util.Log
import com.example.news_app.data.mapper.CategoryNewsMapper
import com.example.news_app.data.mapper.ColumnNewsMapper
import com.example.news_app.data.mapper.LatestNewsMapper
import com.example.news_app.data.network.NewsApi
import com.example.news_app.domain.entity.category.CategoryNewsListEntity
import com.example.news_app.domain.entity.column.ColumnNewsListEntity
import com.example.news_app.domain.entity.latest.LatestNewsListEntity
import com.example.news_app.domain.repository.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsApi: NewsApi,
    private val latestNewsMapper: LatestNewsMapper,
    private val columnNewsMapper: ColumnNewsMapper,
    private val categoryNewsMapper: CategoryNewsMapper
) : NewsRepository {

    override suspend fun getLatestNews(country: String): LatestNewsListEntity {
        val response = newsApi.getLatestNews(country, API_KEY)
        if (response.isSuccessful) {
            Log.d("retrofitTest","response successful")
            val newsResult = response.body()!!
            return latestNewsMapper.mapDataToDomainList(newsResult)
        }
        Log.d("retrofitTest", "response failed")
        return LatestNewsListEntity(
            listOf()
        )
    }

    override suspend fun getColumnNews(title: String): ColumnNewsListEntity {
        val response = newsApi.getColumnNews(title, FROM, SORT_BY, API_KEY)
        if (response.isSuccessful) {
            val newsResult = response.body()!!
            return columnNewsMapper.mapDataToDomainList(newsResult)
        }
        return ColumnNewsListEntity(
            listOf(),
            0
        )
    }

    override suspend fun getCategoryNews(category: String): CategoryNewsListEntity {
        val response = newsApi.getCategoryNews(category, API_KEY)
        if (response.isSuccessful) {
            val characterResult = response.body()!!
            return categoryNewsMapper.mapDataToDomainList(characterResult)
        }
        return CategoryNewsListEntity(
            listOf()
        )
    }

    companion object {
        const val API_KEY = "bcd245a2c038443ca208299a0f5f3ba0"
        const val FROM = "2024-03-23"
        const val SORT_BY = "popularity"
    }
}