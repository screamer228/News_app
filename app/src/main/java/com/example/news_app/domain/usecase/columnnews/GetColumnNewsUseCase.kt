package com.example.news_app.domain.usecase.columnnews

import com.example.news_app.presentation.model.ColumnNewsState

interface GetColumnNewsUseCase {

    suspend fun getColumnNews(title: String): ColumnNewsState

}