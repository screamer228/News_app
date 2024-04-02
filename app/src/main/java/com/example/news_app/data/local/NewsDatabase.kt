package com.example.news_app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.news_app.model.DetailNews

@Database(
    entities = [DetailNews::class],
    version = 3,
    exportSchema = false
)

abstract class NewsDatabase : RoomDatabase() {
    abstract fun newsDao(): NewsDao
}