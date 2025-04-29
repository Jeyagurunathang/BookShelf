package com.example.bookshelf.data.repository

import com.example.bookshelf.data.api.GoogleBooksApi
import com.example.bookshelf.data.remote.bookByIdDto.BookByIdDto
import com.example.bookshelf.data.remote.booksListDto.BooksListDto
import com.example.bookshelf.domain.repository.BooksRepository

class BooksRepositoryImpl(
    private val apiService: GoogleBooksApi
) : BooksRepository {
    override suspend fun getBooksList(topic: String): BooksListDto {
        return apiService.getBooksList(topic)
    }

    override suspend fun getBookById(bookId: String): BookByIdDto {
        return apiService.getBookById(bookId)
    }
}