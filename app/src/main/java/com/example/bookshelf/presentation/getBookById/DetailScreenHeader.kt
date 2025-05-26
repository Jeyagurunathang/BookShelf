package com.example.bookshelf.presentation.getBookById

import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.bookshelf.R

@Composable
fun DetailScreenHeader(
    modifier: Modifier = Modifier,
    onBackArrowClicked: () -> Unit,
    bookTitle: String? = "Sorry, we don't know the book title",
    bookAuthors: String? = "Sorry, we don't know the book authors"
) {
    val context = LocalContext.current

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                top = dimensionResource(R.dimen.padding_detail_small),
                bottom = dimensionResource(R.dimen.padding_tiny)
            ),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(
            onClick = onBackArrowClicked
        ) {
            Icon(
                painter = painterResource(R.drawable.back),
                contentDescription = stringResource(R.string.back_arrow),
                tint = MaterialTheme.colorScheme.tertiary,
                modifier = Modifier.size(24.dp)
            )
        }

        IconButton(
            onClick = {
                val intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, "$bookTitle\nby $bookAuthors")
                }

                try {
                    context.startActivity(intent)
                } catch (e: ActivityNotFoundException) {
                    e.printStackTrace()
                }
            }
        ) {
            Icon(
                painter = painterResource(R.drawable.sharing),
                contentDescription = stringResource(R.string.back_arrow),
                tint = MaterialTheme.colorScheme.tertiary,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}