package com.example.news_app.data.mapper

import com.example.news_app.data.local.model.DetailNewsDBO
import com.example.news_app.data.network.model.Article
import com.example.news_app.data.network.model.NewsDTO
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

    private fun mapDataToDomain(article: Article): ColumnNewsEntity {
        return ColumnNewsEntity(
            title = article.title,
            imageUrl = article.urlToImage
                ?: "https://s0.rbk.ru/v6_top_pics/media/img/3/81/755719504466813.jpeg",
            author = article.author,
            publishedAt = article.publishedAt
        )
    }

    fun mapDboToDomainList(newsList: List<DetailNewsDBO>): List<ColumnNewsEntity> {
        return newsList.map {
            mapDboToDomain(it)
        }
    }

    private fun mapDboToDomain(news: DetailNewsDBO): ColumnNewsEntity {
        return ColumnNewsEntity(
            title = news.title,
            imageUrl = news.imageUrl
                ?: "https://s0.rbk.ru/v6_top_pics/media/img/3/81/755719504466813.jpeg",
            author = news.author,
            publishedAt = news.publishedAt
        )
    }
}