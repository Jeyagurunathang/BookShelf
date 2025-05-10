package com.example.bookshelf.presentation.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.bookshelf.R
import com.example.bookshelf.domain.models.booksListModel.ImageLinks
import com.example.bookshelf.domain.models.booksListModel.Item
import com.example.bookshelf.domain.models.booksListModel.VolumeInfo

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun BookCardComponent(
    modifier: Modifier = Modifier,
    book: Item = Item(
        id = "1",
        volumeInfo = VolumeInfo(
            description = "",
            imageLinks = ImageLinks(
                smallThumbnail = "https://books.google.com/books/content?id=8UvrCQAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api",
                thumbnail = "https://books.google.com/books/content?id=8UvrCQAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"
            ),
            subtitle = "",
            title = "Android Development"
        )
    )
) {
    val imageSrc = book.volumeInfo.imageLinks.thumbnail.replace(oldValue = "http://", newValue = "https://")
    var bottomModalEnabled by remember { mutableStateOf(false) }
    val haptics = LocalHapticFeedback.current

    Card (
        modifier = modifier
            .wrapContentSize()
            .combinedClickable(
                onClick = {},
                onLongClick = {
                    haptics.performHapticFeedback(HapticFeedbackType.LongPress)
                    bottomModalEnabled = !bottomModalEnabled
                },
                onLongClickLabel = "Long Click"
            ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        )
    ) {
        Column (
            modifier = modifier.padding(15.dp)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(imageSrc)
                    .crossfade(true)
                    .build(),
                contentDescription = "Book Image",
                modifier = Modifier.size(150.dp),
                contentScale = ContentScale.FillWidth
            )

            Text(
                text = book.volumeInfo.title,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(
                    top = 15.dp
                ),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                color = MaterialTheme.colorScheme.onSecondary
            )
        }
    }

    if (bottomModalEnabled) {
        ModalBottomSheet(
            onDismissRequest = { bottomModalEnabled = !bottomModalEnabled },
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ) {
            BottomModalComponent(
                bookTitle = book.volumeInfo.title,
                bookDescription = book.volumeInfo.description
            )
        }
    }
}