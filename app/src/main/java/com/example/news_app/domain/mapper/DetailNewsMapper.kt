package com.example.news_app.domain.mapper

import com.example.news_app.domain.entity.DetailNewsEntity
import com.example.news_app.presentation.model.DetailNews

class DetailNewsMapper {

    fun mapUiToDomain(news: DetailNews) : DetailNewsEntity {
        return DetailNewsEntity(
            title = news.title,
            imageUrl = news.imageUrl,
            author = news.author,
            publishedAt = news.publishedAt,
            description = news.description
        )
    }

    fun mapDomainToUi(entity: DetailNewsEntity?) : DetailNews? {
        if (entity != null) {
            return DetailNews(
                title = entity.title,
                imageUrl = entity.imageUrl,
                author = entity.author,
                publishedAt = entity.publishedAt,
                description = entity.description
            )
        }
        return null
    }
}