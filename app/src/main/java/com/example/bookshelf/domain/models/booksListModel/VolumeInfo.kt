package com.example.bookshelf.domain.models.booksListModel

data class VolumeInfo(
    val description: String,
    val imageLinks: ImageLinks? = null,
    val subtitle: String,
    val title: String
)