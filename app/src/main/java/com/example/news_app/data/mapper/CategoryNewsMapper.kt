package com.example.news_app.data.mapper

import com.example.news_app.data.network.model.Article
import com.example.news_app.data.network.model.NewsDTO
import com.example.news_app.domain.entity.column.ColumnNewsEntity

const val IMAGE_URL = "https://s0.rbk.ru/v6_top_pics/media/img/3/81/755719504466813.jpeg"

class CategoryNewsMapper {

    fun mapDataToDomainList(news: NewsDTO): List<ColumnNewsEntity> {
        return news.articles.map {
            mapDataToDomain(it)
        }
    }

    private fun mapDataToDomain(article: Article): ColumnNewsEntity {
        return ColumnNewsEntity(
            title = article.title,
            imageUrl = article.urlToImage ?: IMAGE_URL,
            author = article.author,
            publishedAt = article.publishedAt
        )
    }
}