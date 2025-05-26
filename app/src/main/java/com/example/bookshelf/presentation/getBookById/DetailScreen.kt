package com.example.bookshelf.presentation.getBookById

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import com.example.bookshelf.R
import com.example.bookshelf.presentation.components.listScreen.LoadingScreen
import com.example.bookshelf.presentation.uiState.BookUiState
import com.example.bookshelf.presentation.viewModel.GetBookByIdViewModel
import kotlinx.coroutines.delay

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    getBookByIdViewModel: GetBookByIdViewModel,
    onBackArrowClicked: () -> Unit
) {
    val getBookByIdUiState = getBookByIdViewModel.uiState.collectAsState().value

    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = dimensionResource(R.dimen.padding_tiny))
//            .background(Color.Red)
    ) {
        if (getBookByIdUiState.isLoading) {
            LoadingScreen(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.tertiary
            )
        } else if (getBookByIdUiState.error.isNotEmpty()) {
            Text(text = "Error")
        } else {
            DetailScreenHeader(
                onBackArrowClicked = onBackArrowClicked,
                bookTitle = getBookByIdUiState.success.volumeInfo?.title,
                bookAuthors = getBookByIdUiState.success.volumeInfo?.authors?.joinToString()
            )

            DetailScreenBody(
                book = getBookByIdUiState.success
            )
        }
    }
}