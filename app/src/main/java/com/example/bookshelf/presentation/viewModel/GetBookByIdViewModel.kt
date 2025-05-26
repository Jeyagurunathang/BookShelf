package com.example.bookshelf.presentation.viewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.bookshelf.common.Resource
import com.example.bookshelf.domain.useCase.getBook.GetBookByIdUseCase
import com.example.bookshelf.presentation.core.BookShelfApplication
import com.example.bookshelf.presentation.uiState.BookUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
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
                    _uiState.value = it.data?.let { it1 -> BookUiState(success = it1) }!!
                }
                is Resource.Error -> {
                    _uiState.value = BookUiState(error = it.message ?: "An unexpected error occurs")
                }
                is Resource.Loading -> {
                    _uiState.value = BookUiState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as BookShelfApplication)
                val repository = application.appContainer.booksRepository
                GetBookByIdViewModel(GetBookByIdUseCase(repository))
            }
        }
    }
}