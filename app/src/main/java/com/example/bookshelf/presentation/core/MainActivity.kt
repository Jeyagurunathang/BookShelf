package com.example.bookshelf.presentation.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bookshelf.domain.models.booksListModel.ImageLinks
import com.example.bookshelf.domain.models.booksListModel.Item
import com.example.bookshelf.domain.models.booksListModel.VolumeInfo
import com.example.bookshelf.domain.useCase.getBooks.GetBooksUseCase
import com.example.bookshelf.presentation.DummyData
import com.example.bookshelf.presentation.components.BookCardComponent
import com.example.bookshelf.presentation.core.ui.theme.BookShelfTheme
import com.example.bookshelf.presentation.getBooks.GetBooksListScreen
import com.example.bookshelf.presentation.getBooks.ListScreenBody
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
                    GetBooksListScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}