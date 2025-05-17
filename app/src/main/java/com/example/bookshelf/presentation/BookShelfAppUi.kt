package com.example.bookshelf.presentation

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bookshelf.presentation.core.Screens
import com.example.bookshelf.presentation.getBookById.DetailScreen
import com.example.bookshelf.presentation.getBooks.GetBooksListScreen
import com.example.bookshelf.presentation.uiState.BookUiState
import com.example.bookshelf.presentation.uiState.BooksUiState
import com.example.bookshelf.presentation.viewModel.GetBookByIdViewModel
import com.example.bookshelf.presentation.viewModel.GetBooksViewModel
import kotlinx.coroutines.launch

@Composable
fun BookShelfAppUi(
    modifier: Modifier = Modifier,
    getBooksViewModel: GetBooksViewModel,
    getBooksUiState: BooksUiState,
    getBookByIdViewModel: GetBookByIdViewModel,
    navController: NavHostController = rememberNavController()
) {
    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screens.HOME.name
        ) {
            composable(
                route = Screens.HOME.name
            ) {
                GetBooksListScreen(
                    getBooksViewModel = getBooksViewModel,
                    getBooksUiState = getBooksUiState,
                    modifier = Modifier.padding(innerPadding),
                    onBookClicked = {
                        getBookByIdViewModel.getBookById(it)
                        navController.navigate(route = Screens.DETAIL.name)
                    }
                )
            }

            composable(
                route = Screens.DETAIL.name
            ) {
                DetailScreen(
                    modifier = Modifier.padding(innerPadding),
                    getBookByIdViewModel = getBookByIdViewModel,
                    onBackArrowClicked = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}