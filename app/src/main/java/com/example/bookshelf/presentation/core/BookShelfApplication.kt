package com.example.bookshelf.presentation.core

import android.app.Application
import com.example.bookshelf.di.AppContainer
import com.example.bookshelf.di.DefaultAppContainer

class BookShelfApplication : Application() {
    lateinit var appContainer: AppContainer
    override fun onCreate() {
        super.onCreate()
        appContainer = DefaultAppContainer()
    }
}