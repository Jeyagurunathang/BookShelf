package com.example.bookshelf.presentation.components.listScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.example.bookshelf.R
import com.example.bookshelf.presentation.core.ui.theme.BookShelfTheme

@Composable
fun BottomModalComponent(
    modifier: Modifier = Modifier,
    bookDescription: String? = null,
    bookTitle: String
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(dimensionResource(R.dimen.padding_tiny))
    ) {
        Text(
            text = bookTitle,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onPrimary
        )

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_tiny)))

        Text(
            text = bookDescription ?: "Sorry, we don't know that much about this book",
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.labelMedium,
            maxLines = 7,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@PreviewLightDark
@Composable
fun BottomModalComponentPreview(modifier: Modifier = Modifier) {
    BookShelfTheme(dynamicColor = false) {
        BottomModalComponent(
            bookDescription = "Android Development",
            bookTitle = "Android Development"
        )
    }
}