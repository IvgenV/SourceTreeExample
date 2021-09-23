package com.example.sourcetreeexample.dagger

import com.example.sourcetreeexample.domain.NewsCloudRepository
import com.example.sourcetreeexample.*
import com.example.sourcetreeexample.data.NewsCloudSource
import com.example.sourcetreeexample.domain.NewsCloudUseCase
import com.example.sourcetreeexample.domain.NewsCloudUseCaseImpl
import com.example.sourcetreeexample.domain.NewsCloudUseCaseImpl_Factory
import dagger.Component
import dagger.Module
import dagger.Provides

@Component(modules = [AppModule::class])
interface AppComponent {

    ///не понял как конкретно работает
    fun inject(mainActivity: MainActivity)

    val computer: Computer
    val news: NewsCloudUseCase

}


@Module
class Retro {


    //с inject constructor не хочет собирать
    @Provides
    fun provideNewsRepositoryImpl(
        newsRepository: NewsCloudRepository
    ): NewsCloudUseCase {
        return NewsCloudUseCaseImpl(newsRepository)
    }

    @Provides
    fun provideNewsRepository(): NewsCloudRepository {
        return NewsCloudSource()
    }

}

@Module(includes = [Retro::class])
class AppModule {

    @Provides
    fun provideComputer(
        processor: Processor,
        motherboard: Motherboard,
        ram: RAM
    ): Computer {
        return Computer(
            processor = processor,
            motherboard = motherboard,
            ram = ram
        )
    }

    @Provides
    fun provideProcessor(): Processor {
        return Processor()
    }

    @Provides
    fun provideMotherboard(): Motherboard {
        return Motherboard()
    }

    @Provides
    fun provideRam(): RAM {
        return RAM()
    }

}