package com.example.bookshelf.data.remote.booksListDto

import com.example.bookshelf.domain.models.booksListModel.BooksListModel
import com.example.bookshelf.domain.models.booksListModel.Item

data class BooksListDto(
    val items: List<Item>,
    val kind: String,
    val totalItems: Int
)

fun BooksListDto.toBooksListModel(): BooksListModel {
    return BooksListModel(
        items = items.map { item ->
            Item(
                id = item.id,
                volumeInfo = item.volumeInfo
            )
        }
    )
}