package com.example.bookshelf.domain.models.bookByIdModel

data class VolumeInfo(
    val authors: List<String>? = listOf<String>(""),
    val description: String? = "",
    val imageLinks: ImageLinks? = null,
    val pageCount: String? = "",
    val publishedDate: String? = "",
    val subtitle: String? = "",
    val title: String? = ""
)