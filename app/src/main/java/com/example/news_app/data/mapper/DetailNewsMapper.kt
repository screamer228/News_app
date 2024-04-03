package com.example.news_app.data.mapper

import com.example.news_app.data.local.model.DetailNewsDBO
import com.example.news_app.domain.entity.DetailNewsEntity

class DetailNewsMapper {

    fun mapDomainToData(entity: DetailNewsEntity) : DetailNewsDBO {
        return DetailNewsDBO(
            title = entity.title,
            imageUrl = entity.imageUrl,
            author = entity.author,
            publishedAt = entity.publishedAt,
            description = entity.description
        )
    }

    fun mapDataToDomain(dbo: DetailNewsDBO?) : DetailNewsEntity? {
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
}