package com.example.bookshelf.presentation.uiState

import com.example.bookshelf.domain.models.booksListModel.BooksListModel

data class BooksUiState (
    val isLoading: Boolean = false,
    val success: BooksListModel = BooksListModel(items = emptyList()),
    val error: String? = null
)