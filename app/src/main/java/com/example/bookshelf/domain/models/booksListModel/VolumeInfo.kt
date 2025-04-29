package com.example.bookshelf.domain.models.booksListModel

data class VolumeInfo(
    val description: String,
    val imageLinks: ImageLinks,
    val subtitle: String,
    val title: String
)