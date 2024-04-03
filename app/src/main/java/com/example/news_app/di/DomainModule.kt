package com.example.news_app.di

import com.example.news_app.domain.mapper.CategoryNewsMapper
import com.example.news_app.domain.mapper.ColumnNewsMapper
import com.example.news_app.domain.mapper.DetailNewsMapper
import com.example.news_app.domain.mapper.LatestNewsMapper
import com.example.news_app.domain.repository.NewsRepository
import com.example.news_app.domain.repository.RoomRepository
import com.example.news_app.domain.usecase.deletefavoritenews.DeleteFavoriteNewsUseCase
import com.example.news_app.domain.usecase.deletefavoritenews.DeleteFavoriteNewsUseCaseImpl
import com.example.news_app.domain.usecase.getcategorynews.GetCategoryNewsUseCase
import com.example.news_app.domain.usecase.getcategorynews.GetCategoryNewsUseCaseImpl
import com.example.news_app.domain.usecase.getcolumnnews.GetColumnNewsUseCase
import com.example.news_app.domain.usecase.getcolumnnews.GetColumnNewsUseCaseImpl
import com.example.news_app.domain.usecase.getfavoritelist.GetFavoriteListUseCase
import com.example.news_app.domain.usecase.getfavoritelist.GetFavoriteListUseCaseImpl
import com.example.news_app.domain.usecase.getfavoritenews.GetFavoriteNewsUseCase
import com.example.news_app.domain.usecase.getfavoritenews.GetFavoriteNewsUseCaseImpl
import com.example.news_app.domain.usecase.getlatestnews.GetLatestNewsUseCase
import com.example.news_app.domain.usecase.getlatestnews.GetLatestNewsUseCaseImpl
import com.example.news_app.domain.usecase.savefavoritenews.SaveFavoriteNewsUseCase
import com.example.news_app.domain.usecase.savefavoritenews.SaveFavoriteNewsUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideGetColumnNewsUseCase(
        newsRepository: NewsRepository
    ): GetColumnNewsUseCase {
        return GetColumnNewsUseCaseImpl(
            newsRepository,
            ColumnNewsMapper()
        )
    }

    @Provides
    fun provideGetCategoryNewsUseCase(
        newsRepository: NewsRepository
    ): GetCategoryNewsUseCase {
        return GetCategoryNewsUseCaseImpl(
            newsRepository,
            CategoryNewsMapper()
        )
    }

    @Provides
    fun provideGetLatestNewsUseCase(
        newsRepository: NewsRepository
    ): GetLatestNewsUseCase {
        return GetLatestNewsUseCaseImpl(
            newsRepository,
            LatestNewsMapper()
        )
    }

    @Provides
    fun provideDeleteFavoriteNewsUseCase(roomRepository: RoomRepository): DeleteFavoriteNewsUseCase =
        DeleteFavoriteNewsUseCaseImpl(
            roomRepository,
            DetailNewsMapper()
        )

    @Provides
    fun provideSaveFavoriteNewsUseCase(roomRepository: RoomRepository): SaveFavoriteNewsUseCase =
        SaveFavoriteNewsUseCaseImpl(
            roomRepository,
            DetailNewsMapper()
        )

    @Provides
    fun provideGetFavoriteNewsUseCase(roomRepository: RoomRepository): GetFavoriteNewsUseCase =
        GetFavoriteNewsUseCaseImpl(
            roomRepository,
            DetailNewsMapper()
        )

    @Provides
    fun provideGetFavoriteListUseCase(roomRepository: RoomRepository): GetFavoriteListUseCase =
        GetFavoriteListUseCaseImpl(
            roomRepository,
            ColumnNewsMapper()
        )
}