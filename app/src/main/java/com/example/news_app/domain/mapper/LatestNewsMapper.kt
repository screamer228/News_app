package com.example.news_app.domain.mapper

import com.example.news_app.domain.entity.LatestNewsEntity
import com.example.news_app.presentation.model.LatestNews

class LatestNewsMapper {

    fun mapDomainToUiList(entity: List<LatestNewsEntity>): List<LatestNews> {
        return entity.map {
            mapDomainToUi(it)
        }
    }

    private fun mapDomainToUi(entity: LatestNewsEntity): LatestNews {
        return LatestNews(
            title = entity.title,
            imageUrl = entity.imageUrl
                ?: "https://s0.rbk.ru/v6_top_pics/media/img/3/81/755719504466813.jpeg"
        )
    }

}