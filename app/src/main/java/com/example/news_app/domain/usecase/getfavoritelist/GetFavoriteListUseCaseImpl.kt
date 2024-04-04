package com.example.news_app.domain.usecase.getfavoritelist

import com.example.news_app.domain.mapper.ColumnNewsMapper
import com.example.news_app.domain.repository.RoomRepository
import com.example.news_app.presentation.favorite_screen.uistate.FavoriteUiState
import javax.inject.Inject

class GetFavoriteListUseCaseImpl @Inject constructor(
    private val roomRepository: RoomRepository,
    private val columnNewsMapper: ColumnNewsMapper
) : GetFavoriteListUseCase {

    override suspend fun getFavoriteList(): FavoriteUiState {
        val news = roomRepository.getFavoriteNews()
        return FavoriteUiState(
            news.map {
                columnNewsMapper.mapDomainToUi(it)
            })
    }
}