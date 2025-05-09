package com.example.bookshelf.presentation.getBooks

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.bookshelf.domain.models.booksListModel.Item
import com.example.bookshelf.presentation.components.BookCardComponent

@Composable
fun ListScreenBody(
    modifier: Modifier = Modifier,
    books: List<Item>
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2)
    ) {
        items(
            items = books,
            key = { book -> book.id }
        ) { book ->
            BookCardComponent(book = book)
        }
    }
}