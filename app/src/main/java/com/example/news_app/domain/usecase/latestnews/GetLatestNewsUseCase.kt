package com.example.news_app.domain.usecase.latestnews

import com.example.news_app.model.LatestNews

interface GetLatestNewsUseCase {

    suspend fun getLatestNews(country: String) : List<LatestNews>

}