package com.example.news_app.data.mapper

import com.example.news_app.data.network.model.news.Article
import com.example.news_app.data.network.model.news.NewsDTO
import com.example.news_app.domain.entity.latest.LatestNewsEntity
import com.example.news_app.domain.entity.latest.LatestNewsListEntity

class LatestNewsMapper {

    fun mapDataToDomainList(news: NewsDTO): LatestNewsListEntity {
        return LatestNewsListEntity(
            news.articles.map {
                mapDataToDomain(it)
            })
    }

    fun mapDataToDomain(article: Article): LatestNewsEntity {
        return LatestNewsEntity(
            title = article.title,
            imageUrl = article.urlToImage ?: "https://s0.rbk.ru/v6_top_pics/media/img/3/81/755719504466813.jpeg"
        )
    }
}