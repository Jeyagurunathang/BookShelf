package com.example.bookshelf.presentation.components.detailScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.bookshelf.R
import com.example.bookshelf.presentation.DummyData

@Composable
fun BookBasicInfo(
    modifier: Modifier = Modifier,
    bookImage: String? = DummyData.sampleBookImage,
    bookTitle: String = "Head First Android Development",
    bookAuthor: String = "Dawn Griffiths"
) {
    Column (
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            shape = MaterialTheme.shapes.medium
        ) {
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(bookImage ?: R.drawable.image_not_found)
                    .crossfade(true)
                    .build(),
                contentDescription = bookTitle,
                modifier = Modifier.size(250.dp),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_tiny)))

        Text(
            text = bookTitle,
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_tiny)))

        Text(
            text = "by $bookAuthor",
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onSecondary
        )
    }
}