package com.example.bookshelf.presentation.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.bookshelf.presentation.BookShelfAppUi
import com.example.bookshelf.presentation.components.detailScreen.BookBasicInfo
import com.example.bookshelf.presentation.core.ui.theme.BookShelfTheme
import com.example.bookshelf.presentation.getBookById.DetailScreen
import com.example.bookshelf.presentation.getBookById.DetailScreenHeader
import com.example.bookshelf.presentation.getBooks.GetBooksListScreen
import com.example.bookshelf.presentation.viewModel.GetBookByIdViewModel
import com.example.bookshelf.presentation.viewModel.GetBooksViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val getBooksViewModel: GetBooksViewModel = viewModel(factory = GetBooksViewModel.Factory)
            val getBooksUiState = getBooksViewModel.uiState.collectAsState()

            val getBookByIdViewModel: GetBookByIdViewModel = viewModel(factory = GetBookByIdViewModel.Factory)
            val getBookByIdUiState = getBookByIdViewModel.uiState.collectAsState()

            BookShelfTheme (dynamicColor = false) {
                Surface {
                    BookShelfAppUi(
                        getBooksViewModel = getBooksViewModel,
                        getBooksUiState = getBooksUiState.value,
                        getBookByIdViewModel = getBookByIdViewModel
                    )

//                    Text(text = getBooksUiState.value.success.toString())
                }
            }
        }
    }
}