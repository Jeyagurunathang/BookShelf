package com.example.bookshelf.presentation.getBooks

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.bookshelf.presentation.components.listScreen.LoadingScreen
import com.example.bookshelf.presentation.uiState.BooksUiState
import com.example.bookshelf.presentation.viewModel.GetBooksViewModel

@Composable
fun GetBooksListScreen(
    getBooksViewModel: GetBooksViewModel,
    getBooksUiState: BooksUiState,
    modifier: Modifier = Modifier,
    onBookClicked: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primaryContainer),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ListScreenHeader(
            getBooksViewModel = getBooksViewModel
        )

        HorizontalDivider()

        if (getBooksUiState.isLoading) {
            LoadingScreen(
                modifier = modifier.fillMaxSize()
            )
        } else if (getBooksUiState.error?.isNotEmpty() == true) {
            Text(text = getBooksUiState.error)
        } else {
            ListScreenBody(
                books = getBooksUiState.success.items,
                onBookClicked = onBookClicked
            )
        }
    }
}