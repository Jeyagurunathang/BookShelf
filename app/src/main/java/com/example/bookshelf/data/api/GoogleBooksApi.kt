package com.example.bookshelf.data.api

import com.example.bookshelf.data.remote.bookByIdDto.BookByIdDto
import com.example.bookshelf.data.remote.booksListDto.BooksListDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GoogleBooksApi {

    @GET("books/v1/volumes")
    suspend fun getBooksList(
        @Query("q") topic: String
    ): BooksListDto

    @GET("books/v1/volumes/{bookId}")
    suspend fun getBookById(
        @Path("bookId") bookId: String
    ): BookByIdDto
}