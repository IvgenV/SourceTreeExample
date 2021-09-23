package com.example.sourcetreeexample.data

import com.example.sourcetreeexample.news.News
import retrofit2.Response
import retrofit2.http.GET

interface ApiNewsBelarusBank {

    @GET("news_info?lang=ru")
    suspend fun getNews(): Response<List<News>>
}