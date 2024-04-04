package com.example.news_app.domain.mapper

import com.example.news_app.domain.entity.column.ColumnNewsEntity
import com.example.news_app.domain.entity.column.ColumnNewsListEntity
import com.example.news_app.presentation.model.ColumnNews
import com.example.news_app.presentation.model.ColumnNewsState

class ColumnNewsMapper {

    fun mapDomainToUiState(entity: ColumnNewsListEntity): ColumnNewsState {
        return ColumnNewsState(
            columnNews = entity.news.map {
                mapDomainToUi(it)
            },
            totalResults = entity.totalResults
        )
    }

    fun mapDomainToUi(entity: ColumnNewsEntity): ColumnNews {
        return ColumnNews(
            title = entity.title,
            imageUrl = entity.imageUrl
                ?: "https://s0.rbk.ru/v6_top_pics/media/img/3/81/755719504466813.jpeg",
            author = entity.author ?: "",
            publishedAt = entity.publishedAt
        )
    }
}