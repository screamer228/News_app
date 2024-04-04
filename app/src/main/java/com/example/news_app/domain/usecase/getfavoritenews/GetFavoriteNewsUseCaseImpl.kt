package com.example.news_app.domain.usecase.getfavoritenews

import com.example.news_app.domain.mapper.DetailNewsMapper
import com.example.news_app.domain.repository.RoomRepository
import com.example.news_app.presentation.model.DetailNews
import javax.inject.Inject

class GetFavoriteNewsUseCaseImpl @Inject constructor(
    private val roomRepository: RoomRepository,
    private val detailNewsMapper: DetailNewsMapper
) : GetFavoriteNewsUseCase {

    override suspend fun getFavoriteNews(title: String): DetailNews? {
        val news = roomRepository.getNewsByTitle(title)
        return detailNewsMapper.mapDomainToUi(news)
    }
}