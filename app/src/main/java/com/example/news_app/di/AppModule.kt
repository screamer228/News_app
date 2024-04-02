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
    fun provideGetLatestNewsUseCase(
        newsRepository: NewsRepository
    ) : GetLatestNewsUseCase {
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
    fun provideRoomRepository(newsDao: NewsDao): RoomRepository = RoomRepositoryImpl(
        newsDao
    )

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