package com.example.bookshelf.presentation.getBooks

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.example.bookshelf.R
import com.example.bookshelf.domain.models.booksListModel.Item
import com.example.bookshelf.presentation.components.BookCardComponent

@Composable
fun ListScreenBody(
    modifier: Modifier = Modifier,
    books: List<Item>
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(dimensionResource(R.dimen.padding_tiny))
    ) {
        items(books) { book ->
            BookCardComponent(book = book)
        }
    }
}