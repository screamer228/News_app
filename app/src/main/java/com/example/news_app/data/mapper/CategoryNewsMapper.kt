package com.example.news_app.data.mapper

import com.example.news_app.data.network.model.category.NewsCategoryDTO
import com.example.news_app.data.network.model.category.Source
import com.example.news_app.domain.entity.category.CategoryNewsEntity
import com.example.news_app.domain.entity.category.CategoryNewsListEntity

const val IMAGE_URL = "https://s0.rbk.ru/v6_top_pics/media/img/3/81/755719504466813.jpeg"

class CategoryNewsMapper {

    fun mapDataToDomainList(news: NewsCategoryDTO): CategoryNewsListEntity {
        return CategoryNewsListEntity(
            news.sources.map {
                mapDataToDomain(it)
            })
    }

    fun mapDataToDomain(source: Source): CategoryNewsEntity {
        return CategoryNewsEntity(
            title = source.name,
            imageUrl = IMAGE_URL,
            description = source.description
        )
    }

}