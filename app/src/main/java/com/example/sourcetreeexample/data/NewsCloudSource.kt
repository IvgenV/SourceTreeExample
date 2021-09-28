package com.example.sourcetreeexample.data

import com.example.sourcetreeexample.domain.NewsCloudRepository
import javax.inject.Inject


class NewsCloudSource:NewsCloudRepository {

    override  fun getNews(): String {
        return "some news"
    }

}