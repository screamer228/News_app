package com.example.news_app.domain.usecase.getcategorynews

import com.example.news_app.domain.mapper.CategoryNewsMapper
import com.example.news_app.domain.repository.NewsRepository
import com.example.news_app.presentation.model.ColumnNews
import javax.inject.Inject

class GetCategoryNewsUseCaseImpl @Inject constructor(
    private val newsRepository: NewsRepository,
    private val categoryNewsMapper: CategoryNewsMapper
) : GetCategoryNewsUseCase {

    override suspend fun getCategoryNews(category: String): List<ColumnNews> {
        val news = newsRepository.getCategoryNews(category)
        return categoryNewsMapper.mapDomainToUiState(news)
    }
}