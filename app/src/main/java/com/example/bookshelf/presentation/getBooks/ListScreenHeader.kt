package com.example.bookshelf.presentation.getBooks

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.bookshelf.R
import com.example.bookshelf.presentation.components.listScreen.IconDisplay
import com.example.bookshelf.presentation.components.listScreen.SearchBarComponent
import com.example.bookshelf.presentation.viewModel.GetBooksViewModel
import kotlinx.coroutines.delay

@Composable
fun ListScreenHeader(
    getBooksViewModel: GetBooksViewModel,
    modifier: Modifier = Modifier
) {
    var searchIconClicked by remember { mutableStateOf(false) }

    val appTitle = stringResource(R.string.app_name).split(" ")

    val focusRequester =  remember { FocusRequester() }

//    val scope = rememberCoroutineScope()

    Row (
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(
                vertical = dimensionResource(R.dimen.padding_normal),
                horizontal = dimensionResource(R.dimen.horizontal_padding_medium)
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (searchIconClicked) {
            LaunchedEffect(Unit) {
                delay(100L)
                focusRequester.requestFocus()
            }
            SearchBarComponent(
                modifier = Modifier.focusRequester(focusRequester),
                onClick = { topic ->
                    getBooksViewModel.getBooks(topic = topic)
                },
                onCancelClicked = { searchIconClicked = false }
            )
        } else {
            Column {
                Text(
                    text = appTitle.first(),
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = appTitle.last(),
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.titleMedium
                )
            }

            IconDisplay(
                icon = R.drawable.search,
                modifier = Modifier.size(24.dp),
                onClick = {
                    searchIconClicked = !searchIconClicked
                    /*scope.launch {
                        delay(100L)
                        focusRequester.requestFocus()
                    }*/
                }
            )
        }
    }
}