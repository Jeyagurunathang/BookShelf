package com.example.bookshelf.presentation.getBookById

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.bookshelf.R
import com.example.bookshelf.domain.models.bookByIdModel.BookByIdModel
import com.example.bookshelf.presentation.components.detailScreen.BookBasicInfo
import com.example.bookshelf.presentation.components.detailScreen.BookPageDateInfo
import org.jsoup.Jsoup

@Composable
fun DetailScreenBody(
    modifier: Modifier = Modifier,
    book: BookByIdModel
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BookBasicInfo(
            bookImage = book.volumeInfo?.imageLinks?.thumbnail?.replace("http://", "https://"),
            bookTitle = book.volumeInfo?.title ?: "Android Development",
            bookAuthor = book.volumeInfo?.authors
        )

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_detail_tiny)))

        BookPageDateInfo(
            publishedDate = book.volumeInfo?.publishedDate?.substring(0, 4),
            pageCount = book.volumeInfo?.pageCount
        )

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_detail_tiny)))


        Text(
            text = "Description",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.align(Alignment.Start)
        )

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_tiny)))

        Text(
            text = if(book.volumeInfo?.description?.isNotEmpty() == true) {
                Jsoup.parse(book.volumeInfo.description).text()
            } else { "Sorry we don't know about this book" },
            style = MaterialTheme.typography.displaySmall,
            color = MaterialTheme.colorScheme.onSecondary,
            modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_tiny))
        )

    }
}