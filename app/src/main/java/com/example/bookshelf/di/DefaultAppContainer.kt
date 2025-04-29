package com.example.bookshelf.di

import com.example.bookshelf.data.api.GoogleBooksApi
import com.example.bookshelf.data.repository.BooksRepositoryImpl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DefaultAppContainer : AppContainer {
    private val baseUrl = "https://www.googleapis.com/"

    private val retrofit = Retrofit
        .Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val retrofitService by lazy { retrofit.create(GoogleBooksApi::class.java) }

    override val booksRepository = BooksRepositoryImpl(apiService = retrofitService)
}