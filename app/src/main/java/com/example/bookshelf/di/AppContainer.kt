package com.example.bookshelf.di

import com.example.bookshelf.domain.repository.BooksRepository

interface AppContainer {
    val booksRepository: BooksRepository
}