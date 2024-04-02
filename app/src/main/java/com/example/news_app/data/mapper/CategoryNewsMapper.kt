package com.example.news_app.data.mapper

import com.example.news_app.data.network.model.category.NewsCategoryDTO
import com.example.news_app.data.network.model.category.Source
import com.example.news_app.domain.entity.CategoryNewsEntity
import com.example.news_app.domain.entity.column.ColumnNewsEntity

const val IMAGE_URL = "https://s0.rbk.ru/v6_top_pics/media/img/3/81/755719504466813.jpeg"

class CategoryNewsMapper {

    fun mapDataToDomainList(news: NewsCategoryDTO): List<ColumnNewsEntity> {
        return news.sources.map {
                mapDataToDomain(it)
            }
    }

    fun mapDataToDomain(source: Source): ColumnNewsEntity {
        return ColumnNewsEntity(
            title = source.description,
            imageUrl = IMAGE_URL,
            author = "",
            publishedAt = ""
        )
    }
}