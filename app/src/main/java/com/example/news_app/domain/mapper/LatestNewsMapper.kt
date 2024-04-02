package com.example.news_app.domain.mapper

import com.example.news_app.domain.entity.latest.LatestNewsEntity
import com.example.news_app.domain.entity.latest.LatestNewsListEntity
import com.example.news_app.model.LatestNews

class LatestNewsMapper {

    fun mapDomainToUiList(entity: LatestNewsListEntity): List<LatestNews> {
        return entity.news.map {
                mapDomainToUi(it)
            }
    }

    fun mapDomainToUi(news: LatestNewsEntity): LatestNews {
        return LatestNews(
            title = news.title,
            imageUrl = news.imageUrl ?: "https://s0.rbk.ru/v6_top_pics/media/img/3/81/755719504466813.jpeg"
        )
    }

}