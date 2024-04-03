package com.example.news_app.domain.usecase.getdetailnews

import com.example.news_app.domain.mapper.DetailNewsMapper
import com.example.news_app.domain.repository.NewsRepository
import com.example.news_app.presentation.model.DetailNews
import javax.inject.Inject

class GetDetailNewsUseCaseImpl @Inject constructor(
    private val newsRepository: NewsRepository,
    private val detailNewsMapper: DetailNewsMapper
) : GetDetailNewsUseCase {

    override suspend fun getDetailNews(title: String): DetailNews {
        val news = newsRepository.getDetailNews(title)
        return detailNewsMapper.mapDomainToUi(news)!!
    }
}