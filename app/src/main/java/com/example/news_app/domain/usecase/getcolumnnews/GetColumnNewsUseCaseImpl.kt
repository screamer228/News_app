package com.example.news_app.domain.usecase.getcolumnnews

import com.example.news_app.domain.mapper.ColumnNewsMapper
import com.example.news_app.domain.repository.NewsRepository
import com.example.news_app.presentation.model.ColumnNewsState
import javax.inject.Inject

class GetColumnNewsUseCaseImpl @Inject constructor(
    private val newsRepository: NewsRepository,
    private val columnNewsMapper: ColumnNewsMapper
) : GetColumnNewsUseCase {

    override suspend fun getColumnNews(title: String): ColumnNewsState {
        val news = newsRepository.getColumnNews(title)
        return columnNewsMapper.mapDomainToUiState(news)
    }
}