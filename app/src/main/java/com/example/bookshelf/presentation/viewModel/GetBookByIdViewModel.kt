package com.example.bookshelf.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.example.bookshelf.common.Resource
import com.example.bookshelf.domain.useCase.getBook.GetBookByIdUseCase
import com.example.bookshelf.presentation.uiState.BookUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onEach

class GetBookByIdViewModel(
    private val getBookByIdUseCase: GetBookByIdUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(BookUiState())
    val uiState = _uiState.asStateFlow()

    fun getBookById(bookId: String) {
        getBookByIdUseCase.execute(bookId).onEach {
            when(it) {
                is Resource.Success -> {
                    _uiState.value = BookUiState(success = it.data)
                }
                is Resource.Error -> {
                    _uiState.value = BookUiState(error = it.message ?: "An unexpected error occurs")
                }
                is Resource.Loading -> {
                    _uiState.value = BookUiState(isLoading = true)
                }
            }
        }
    }
}