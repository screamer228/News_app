package com.example.news_app.data.repository

import com.example.news_app.model.DetailNews

interface RoomRepository {

    fun getFavoriteNews() : List<DetailNews>?

    fun insertFavoriteNews(news: DetailNews)
}