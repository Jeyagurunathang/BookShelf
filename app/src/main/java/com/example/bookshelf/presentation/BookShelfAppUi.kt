package com.example.bookshelf.presentation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.bookshelf.presentation.core.Screens
import com.example.bookshelf.presentation.getBookById.DetailScreen
import com.example.bookshelf.presentation.getBooks.GetBooksListScreen
import com.example.bookshelf.presentation.uiState.BooksUiState
import com.example.bookshelf.presentation.viewModel.GetBooksViewModel

@Composable
fun BookShelfAppUi(
    modifier: Modifier = Modifier,
    getBooksViewModel: GetBooksViewModel,
    getBooksUiState: BooksUiState,
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
                        navController.navigate(route = Screens.DETAIL.name)
                    }
                )
            }

            composable(
                route = Screens.DETAIL.name
            ) {
                DetailScreen(
                    modifier = Modifier.padding(innerPadding),
                    onBackArrowClicked = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}