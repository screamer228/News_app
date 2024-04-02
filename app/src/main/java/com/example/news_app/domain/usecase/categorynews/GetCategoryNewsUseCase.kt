package com.example.news_app.domain.usecase.categorynews

import com.example.news_app.presentation.model.ColumnNews

interface GetCategoryNewsUseCase {

    suspend fun getCategoryNews(category: String) : List<ColumnNews>

}