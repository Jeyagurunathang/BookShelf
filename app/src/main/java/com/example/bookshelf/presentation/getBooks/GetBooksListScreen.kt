package com.example.bookshelf.presentation.getBooks

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.bookshelf.presentation.DummyData
import com.example.bookshelf.presentation.components.LoadingScreen
import com.example.bookshelf.presentation.uiState.BooksUiState

@Composable
fun GetBooksListScreen(
    getBooksUiState: BooksUiState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primaryContainer),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ListScreenHeader()

        HorizontalDivider()

        if (getBooksUiState.isLoading) {
            LoadingScreen(
                modifier = modifier.fillMaxSize()
            )
        } else if (getBooksUiState.error?.isNotEmpty() == true) {
            Text(text = getBooksUiState.error)
        } else {
            ListScreenBody(books = getBooksUiState.success.items)
        }
    }
}