package com.example.bookshelf.data.remote.bookByIdDto

data class VolumeInfo(
    val allowAnonLogging: Boolean,
    val authors: List<String>,
    val canonicalVolumeLink: String,
    val categories: List<String>,
    val contentVersion: String,
    val description: String,
    val dimensions: Dimensions,
    val imageLinks: ImageLinks,
    val industryIdentifiers: List<IndustryIdentifier>,
    val infoLink: String,
    val language: String,
    val maturityRating: String,
    val pageCount: Int,
    val panelizationSummary: PanelizationSummary,
    val previewLink: String,
    val printType: String,
    val printedPageCount: Int,
    val publishedDate: String,
    val publisher: String,
    val readingModes: ReadingModes,
    val subtitle: String,
    val title: String
)