package com.example.sourcetreeexample.domain

import com.example.sourcetreeexample.news.News
import retrofit2.Response
import javax.inject.Inject


///inject constructor что это
class NewsCloudUseCaseImpl @Inject constructor(val newsCloudRepository: NewsCloudRepository):NewsCloudUseCase {
    override suspend fun getNews(): Response<List<News>> {
        return newsCloudRepository.getNews()
    }
}