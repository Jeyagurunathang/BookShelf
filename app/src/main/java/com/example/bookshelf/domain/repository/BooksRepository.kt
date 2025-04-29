package com.example.bookshelf.domain.repository

import com.example.bookshelf.common.Constants
import com.example.bookshelf.data.remote.bookByIdDto.BookByIdDto
import com.example.bookshelf.data.remote.booksListDto.BooksListDto

interface BooksRepository {
    suspend fun getBooksList(topic: String = Constants.DEFAULT_TOPIC): BooksListDto

    suspend fun getBookById(bookId: String = Constants.DEFAULT_BOOK_ID): BookByIdDto
}