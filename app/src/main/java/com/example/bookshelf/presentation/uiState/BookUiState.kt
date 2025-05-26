package com.example.bookshelf.presentation.uiState

import com.example.bookshelf.domain.models.bookByIdModel.BookByIdModel
import com.example.bookshelf.domain.models.bookByIdModel.ImageLinks
import com.example.bookshelf.domain.models.bookByIdModel.VolumeInfo

data class BookUiState(
    val isLoading: Boolean = false,
    val success: BookByIdModel = BookByIdModel(),
    val error: String = ""
)