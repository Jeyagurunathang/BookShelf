package com.example.bookshelf.presentation.getBooks

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.bookshelf.R
import com.example.bookshelf.domain.models.booksListModel.Item
import com.example.bookshelf.presentation.components.listScreen.BookCardComponent

@Composable
fun ListScreenBody(
    modifier: Modifier = Modifier,
    books: List<Item>
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(dimensionResource(R.dimen.padding_tiny)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_tiny)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_tiny))
    ) {
        items(
            items = books,
            key = { book -> book.id }
        ) { book ->
            BookCardComponent(book = book)
        }
    }
}