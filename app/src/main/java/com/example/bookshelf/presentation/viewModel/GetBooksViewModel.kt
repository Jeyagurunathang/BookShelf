package com.example.bookshelf.presentation.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.bookshelf.common.Constants
import com.example.bookshelf.common.Resource
import com.example.bookshelf.domain.models.booksListModel.BooksListModel
import com.example.bookshelf.domain.useCase.getBooks.GetBooksUseCase
import com.example.bookshelf.presentation.core.BookShelfApplication
import com.example.bookshelf.presentation.uiState.BooksUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class GetBooksViewModel(
    private val getBooksUseCase: GetBooksUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(BooksUiState())
    val uiState = _uiState.asStateFlow()

    init {
        getBooks(topic = Constants.DEFAULT_TOPIC)
    }

    private fun getBooks(topic: String) {
        getBooksUseCase.execute(topic).onEach {
            when(it) {
                is Resource.Success -> {
                    _uiState.value = BooksUiState(success = it.data ?: BooksListModel(items = emptyList()))
                }
                is Resource.Error -> {
                    _uiState.value = BooksUiState(error = it.message)
                }
                is Resource.Loading -> {
                    _uiState.value = BooksUiState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as BookShelfApplication)
                val bookRepository = application.appContainer.booksRepository
                GetBooksViewModel(getBooksUseCase = GetBooksUseCase(bookRepository))
            }
        }
    }
}