package com.example.bookshelf.data.remote.bookByIdDto

import com.example.bookshelf.domain.models.bookByIdModel.BookByIdModel
import com.example.bookshelf.domain.models.bookByIdModel.VolumeInfo

data class BookByIdDto(
    val accessInfo: AccessInfo,
    val etag: String,
    val id: String,
    val kind: String,
    val saleInfo: SaleInfo,
    val selfLink: String,
    val volumeInfo: VolumeInfo
)

fun BookByIdDto.toBookByIdModel(): BookByIdModel {
    return BookByIdModel(
        id = id,
        volumeInfo = VolumeInfo(
            authors = volumeInfo.authors,
            description = volumeInfo.description,
            imageLinks = volumeInfo.imageLinks,
            pageCount = volumeInfo.pageCount,
            publishedDate = volumeInfo.publishedDate,
            subtitle = volumeInfo.subtitle,
            title = volumeInfo.title
        )
    )
}