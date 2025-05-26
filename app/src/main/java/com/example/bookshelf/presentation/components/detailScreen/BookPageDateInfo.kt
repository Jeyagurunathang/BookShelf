package com.example.bookshelf.presentation.components.detailScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.example.bookshelf.R

@Composable
fun BookPageDateInfo(
    modifier: Modifier = Modifier,
    publishedDate: String? = null,
    pageCount: String? = null
) {
    Row (
        modifier = Modifier
            .background(
                color = MaterialTheme.colorScheme.secondaryContainer,
                shape = MaterialTheme.shapes.medium
            )
            .padding(
                vertical = dimensionResource(R.dimen.padding_medium),
                horizontal = dimensionResource(R.dimen.padding_tiny)
            )
    ) {
        BookMetaData(
            icon = R.drawable.calendar,
            data = publishedDate ?: "2014",
            modifier = Modifier.size(30.dp)
        )

        BookMetaData(
            icon = R.drawable.book,
            data = if(pageCount?.isNotEmpty() == true) pageCount else "-",
            modifier = Modifier.size(30.dp)
        )
    }
}