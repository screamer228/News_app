package com.example.news_app.domain.usecase.getdetailnews

import com.example.news_app.presentation.model.DetailNews

interface GetDetailNewsUseCase {

    suspend fun getDetailNews(title: String): DetailNews

}