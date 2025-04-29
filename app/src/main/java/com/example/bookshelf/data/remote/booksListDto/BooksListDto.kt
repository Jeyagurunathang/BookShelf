package com.example.bookshelf.data.remote.booksListDto

data class BooksListDto(
    val items: List<Item>,
    val kind: String,
    val totalItems: Int
)