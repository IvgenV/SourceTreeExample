package com.example.sourcetreeexample.domain

import javax.inject.Inject


///inject constructor что это
class NewsCloudUseCaseImpl(
    val newsCloudRepository:
    NewsCloudRepository
) : NewsCloudUseCase {
    override  fun getNews(): String {
        return newsCloudRepository.getNews()
    }
}