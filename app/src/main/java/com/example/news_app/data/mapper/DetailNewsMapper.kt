package com.example.news_app.data.mapper

import com.example.news_app.data.local.model.DetailNewsDBO
import com.example.news_app.data.network.model.NewsDTO
import com.example.news_app.domain.entity.DetailNewsEntity

class DetailNewsMapper {

    fun mapDomainToDbo(entity: DetailNewsEntity): DetailNewsDBO {
        return DetailNewsDBO(
            title = entity.title,
            imageUrl = entity.imageUrl,
            author = entity.author ?: "unknown",
            publishedAt = entity.publishedAt,
            description = entity.description
        )
    }

    fun mapDboToDomain(dbo: DetailNewsDBO?): DetailNewsEntity? {
        if (dbo != null) {
            return DetailNewsEntity(
                title = dbo.title,
                imageUrl = dbo.imageUrl,
                author = dbo.author,
                publishedAt = dbo.publishedAt,
                description = dbo.description
            )
        }
        return null
    }

    fun mapDtoToDomain(dto: NewsDTO): DetailNewsEntity {
        val news = dto.articles.first()
        return DetailNewsEntity(
            title = news.title,
            imageUrl = news.urlToImage,
            author = news.author,
            publishedAt = news.publishedAt,
            description = news.description
        )
    }
}