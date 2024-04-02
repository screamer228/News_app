package com.example.news_app.domain.usecase

import com.example.news_app.domain.mapper.ColumnNewsMapper
import com.example.news_app.domain.repository.RoomRepository
import com.example.news_app.presentation.detail_screen.DetailUiState
import com.example.news_app.presentation.favorite_screen.FavoriteUiState
import com.example.news_app.presentation.model.ColumnNews
import javax.inject.Inject

class GetFavoriteNewsUseCaseImpl @Inject constructor(
    private val roomRepository: RoomRepository,
    private val columnNewsMapper: ColumnNewsMapper
) : GetFavoriteNewsUseCase {

    override suspend fun getFavoriteNews(): FavoriteUiState {
        val news = roomRepository.getFavoriteNews()
        return FavoriteUiState(
            news.map {
                columnNewsMapper.mapDomainToUi(it)
            })
    }
}