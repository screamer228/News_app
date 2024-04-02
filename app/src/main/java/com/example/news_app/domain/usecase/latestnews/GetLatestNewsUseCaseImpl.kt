package com.example.news_app.domain.usecase.latestnews

import com.example.news_app.domain.mapper.LatestNewsMapper
import com.example.news_app.domain.repository.NewsRepository
import com.example.news_app.model.LatestNews
import javax.inject.Inject

class GetLatestNewsUseCaseImpl @Inject constructor(
    private val newsRepository: NewsRepository,
    private val latestNewsMapper: LatestNewsMapper
) : GetLatestNewsUseCase {

    override suspend fun getLatestNews(country: String): List<LatestNews> {
        val news = newsRepository.getLatestNews(country)
        return latestNewsMapper.mapDomainToUiList(news)
    }
}