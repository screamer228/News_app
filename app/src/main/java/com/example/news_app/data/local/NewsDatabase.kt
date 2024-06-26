package com.example.news_app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.news_app.data.local.model.DetailNewsDBO

@Database(
    entities = [DetailNewsDBO::class],
    version = 3,
    exportSchema = false
)

abstract class NewsDatabase : RoomDatabase() {
    abstract fun newsDao(): NewsDao
}