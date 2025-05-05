package com.example.bookshelf.presentation.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bookshelf.domain.useCase.getBooks.GetBooksUseCase
import com.example.bookshelf.presentation.core.ui.theme.BookShelfTheme
import com.example.bookshelf.presentation.getBooks.ListScreenHeader
import com.example.bookshelf.presentation.viewModel.GetBooksViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel: GetBooksViewModel = viewModel(factory = GetBooksViewModel.Factory)
            BookShelfTheme (dynamicColor = false) {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ListScreenHeader(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}