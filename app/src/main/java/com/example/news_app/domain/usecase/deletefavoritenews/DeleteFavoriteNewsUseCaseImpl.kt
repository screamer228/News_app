package com.example.news_app.domain.usecase.deletefavoritenews

import com.example.news_app.domain.mapper.DetailNewsMapper
import com.example.news_app.domain.repository.RoomRepository
import com.example.news_app.presentation.model.DetailNews
import javax.inject.Inject

class DeleteFavoriteNewsUseCaseImpl @Inject constructor(
    private val roomRepository: RoomRepository,
    private val detailNewsMapper: DetailNewsMapper
) : DeleteFavoriteNewsUseCase {

    override suspend fun deleteFavoriteNews(news: DetailNews) {
        roomRepository.deleteFavoriteNews(detailNewsMapper.mapUiToDomain(news))
    }
}