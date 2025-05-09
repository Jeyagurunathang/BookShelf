package com.example.bookshelf.data.remote.booksListDto

import com.example.bookshelf.domain.models.booksListModel.Item

data class Item(
    val accessInfo: AccessInfo,
    val etag: String,
    val id: String,
    val kind: String,
    val saleInfo: SaleInfo,
    val searchInfo: SearchInfo,
    val selfLink: String,
    val volumeInfo: VolumeInfo
)

fun Item.toBookListModelItem() : Item {
    return Item(
        id = id,
        volumeInfo = volumeInfo
    )
}