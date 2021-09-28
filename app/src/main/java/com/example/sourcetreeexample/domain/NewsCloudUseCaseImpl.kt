package com.example.sourcetreeexample.domain

import javax.inject.Inject


class NewsCloudUseCaseImpl @Inject constructor(
    val newsCloudRepository:
    NewsCloudRepository
) : NewsCloudUseCase {
    override  fun getNews(): String {
        return newsCloudRepository.getNews()
    }
}