package com.example.news_app.domain.usecase.savefavoritenews

import com.example.news_app.domain.mapper.DetailNewsMapper
import com.example.news_app.domain.repository.RoomRepository
import com.example.news_app.presentation.model.DetailNews
import javax.inject.Inject

class SaveFavoriteNewsUseCaseImpl @Inject constructor(
    private val roomRepository: RoomRepository,
    private val detailNewsMapper: DetailNewsMapper
) : SaveFavoriteNewsUseCase {

    override suspend fun saveFavoriteNews(news: DetailNews) {
        roomRepository.insertFavoriteNews(detailNewsMapper.mapUiToDomain(news))
    }
}