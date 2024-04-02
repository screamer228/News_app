package com.example.news_app.di

import android.content.Context
import androidx.room.Room
import com.example.news_app.domain.repository.RoomRepository
import com.example.news_app.data.repository.room.RoomRepositoryImpl
import com.example.news_app.data.local.NewsDao
import com.example.news_app.data.local.NewsDatabase
import com.example.news_app.data.mapper.CategoryNewsMapper
import com.example.news_app.data.mapper.ColumnNewsMapper
import com.example.news_app.data.mapper.LatestNewsMapper
import com.example.news_app.data.network.NewsApi
import com.example.news_app.domain.repository.NewsRepository
import com.example.news_app.data.repository.news.NewsRepositoryImpl
import com.example.news_app.domain.usecase.GetFavoriteNewsUseCase
import com.example.news_app.domain.usecase.GetFavoriteNewsUseCaseImpl
import com.example.news_app.domain.usecase.categorynews.GetCategoryNewsUseCase
import com.example.news_app.domain.usecase.categorynews.GetCategoryNewsUseCaseImpl
import com.example.news_app.domain.usecase.columnnews.GetColumnNewsUseCase
import com.example.news_app.domain.usecase.columnnews.GetColumnNewsUseCaseImpl
import com.example.news_app.domain.usecase.latestnews.GetLatestNewsUseCase
import com.example.news_app.domain.usecase.latestnews.GetLatestNewsUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    @Provides
    @Singleton
    fun provideGetColumnNewsUseCase(
        newsRepository: NewsRepository
    ): GetColumnNewsUseCase {
        return GetColumnNewsUseCaseImpl(
            newsRepository,
            com.example.news_app.domain.mapper.ColumnNewsMapper()
        )
    }

    @Provides
    @Singleton
    fun provideGetCategoryNewsUseCase(
        newsRepository: NewsRepository
    ): GetCategoryNewsUseCase {
        return GetCategoryNewsUseCaseImpl(
            newsRepository,
            com.example.news_app.domain.mapper.CategoryNewsMapper()
        )
    }

    @Provides
    @Singleton
    fun provideGetLatestNewsUseCase(
        newsRepository: NewsRepository
    ): GetLatestNewsUseCase {
        return GetLatestNewsUseCaseImpl(
            newsRepository,
            com.example.news_app.domain.mapper.LatestNewsMapper()
        )
    }

    @Provides
    @Singleton
    fun provideCharacterRepository(
        newsApi: NewsApi
    ): NewsRepository {
        return NewsRepositoryImpl(
            newsApi,
            LatestNewsMapper(),
            ColumnNewsMapper(),
            CategoryNewsMapper()
        )
    }

    @Provides
    @Singleton
    fun provideRequestsApi(): NewsApi {
        return provideRetrofitInstance().create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofitInstance(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    @Provides
    @Singleton
    fun provideGetFavoriteNewsUseCase(roomRepository: RoomRepository): GetFavoriteNewsUseCase =
        GetFavoriteNewsUseCaseImpl(
            roomRepository,
            com.example.news_app.domain.mapper.ColumnNewsMapper()
        )

    @Provides
    @Singleton
    fun provideRoomRepository(newsDao: NewsDao): RoomRepository {
        return RoomRepositoryImpl(
            newsDao,
            ColumnNewsMapper()
        )
    }

    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext context: Context): NewsDatabase =
        Room.databaseBuilder(
            context,
            NewsDatabase::class.java,
            DATABASE_NAME
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideNewsDao(newsDatabase: NewsDatabase): NewsDao = newsDatabase.newsDao()

    companion object {
        const val BASE_URL = "https://newsapi.org/"
        const val DATABASE_NAME = "news-database"
    }
}