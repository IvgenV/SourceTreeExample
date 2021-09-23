package com.example.sourcetreeexample.domain

import com.example.sourcetreeexample.news.News
import retrofit2.Response

interface NewsCloudRepository {
    suspend fun getNews(): Response<List<News>>
}