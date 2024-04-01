package com.example.news_app.di

import android.content.Context
import androidx.room.Room
import com.example.news_app.data.repository.RoomRepository
import com.example.news_app.data.repository.RoomRepositoryImpl
import com.example.news_app.data.room.NewsDao
import com.example.news_app.data.room.NewsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesRoomRepository(newsDao: NewsDao): RoomRepository = RoomRepositoryImpl(
        newsDao
    )

    @Provides
    @Singleton
    fun providesRoomDatabase(@ApplicationContext context: Context): NewsDatabase =
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
        const val DATABASE_NAME = "news-database"
    }

}