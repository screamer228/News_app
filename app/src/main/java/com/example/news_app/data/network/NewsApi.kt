package com.example.news_app.data.network

import com.example.news_app.data.network.model.category.NewsCategoryDTO
import com.example.news_app.data.network.model.news.NewsDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("v2/top-headlines")
    suspend fun getLatestNews(
        @Query("country") country: String,
//        @Query("apiKey") apiKey: String
    ): Response<NewsDTO>

    @GET("v2/everything")
    suspend fun getColumnNews(
        @Query("q") title: String,
//        @Query("from") from: String,
        @Query("sortBy") sortBy: String,
//        @Query("apiKey") apiKey: String
    ): Response<NewsDTO>

    @GET("v2/top-headlines")
    suspend fun getCategoryNews(
        @Query("category") category: String,
//        @Query("apiKey") apiKey: String
    ): Response<NewsDTO>
}