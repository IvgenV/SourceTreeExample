package com.example.sourcetreeexample.dagger

import com.example.sourcetreeexample.domain.NewsCloudRepository
import com.example.sourcetreeexample.*
import com.example.sourcetreeexample.data.NewsCloudSource
import com.example.sourcetreeexample.domain.NewsCloudUseCase
import com.example.sourcetreeexample.domain.NewsCloudUseCaseImpl
import dagger.Component
import dagger.Module
import dagger.Provides

@Component(modules = [News::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)


}


@Module
class News {

    ///Насколько я понял Provides можно заменить на @Inject constructor
    ///и это будет тоже самое или не?
    //с inject constructor не хочет собирать


}



