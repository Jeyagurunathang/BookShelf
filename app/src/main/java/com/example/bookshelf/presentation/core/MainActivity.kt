package com.example.bookshelf.presentation.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bookshelf.presentation.core.ui.theme.BookShelfTheme
import com.example.bookshelf.presentation.getBooks.GetBooksListScreen
import com.example.bookshelf.presentation.viewModel.GetBooksViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val getBooksViewModel: GetBooksViewModel = viewModel(factory = GetBooksViewModel.Factory)
            BookShelfTheme (dynamicColor = false) {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    val getBooksUiState = getBooksViewModel.uiState.collectAsState()

                    GetBooksListScreen(
                        getBooksUiState = getBooksUiState.value,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}