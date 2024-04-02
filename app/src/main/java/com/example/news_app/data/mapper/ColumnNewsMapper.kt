package com.example.news_app.data.mapper

import com.example.news_app.data.network.model.news.Article
import com.example.news_app.data.network.model.news.NewsDTO
import com.example.news_app.domain.entity.column.ColumnNewsEntity
import com.example.news_app.domain.entity.column.ColumnNewsListEntity

class ColumnNewsMapper {

    fun mapDataToDomainList(news: NewsDTO): ColumnNewsListEntity {
        return ColumnNewsListEntity(
            news = news.articles.map {
                mapDataToDomain(it)
            },
            totalResults = news.totalResults
        )
    }

    fun mapDataToDomain(article: Article): ColumnNewsEntity {
        return ColumnNewsEntity(
            title = article.title,
            imageUrl = article.urlToImage,
            author = article.author,
            publishedAt = article.publishedAt
        )
    }

}