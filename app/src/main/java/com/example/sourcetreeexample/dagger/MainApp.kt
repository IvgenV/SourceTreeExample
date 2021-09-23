package com.example.sourcetreeexample.dagger

import android.app.Application
import android.content.Context

class MainApp : Application() {

    private var _appComponent:AppComponent? = null

    internal val appComponent:AppComponent
    get() = checkNotNull(_appComponent){
        "Application isn't initialized"
    }

    override fun onCreate() {
        super.onCreate()
        _appComponent = DaggerAppComponent.create()
    }

}

val Context.appComponent:AppComponent
get() = when(this){
    is MainApp -> appComponent
    else -> this.applicationContext.appComponent
}