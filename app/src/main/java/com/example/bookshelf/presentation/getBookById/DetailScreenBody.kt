package com.example.bookshelf.presentation.getBookById

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.example.bookshelf.R
import com.example.bookshelf.presentation.DummyData
import com.example.bookshelf.presentation.components.detailScreen.BookBasicInfo
import com.example.bookshelf.presentation.components.detailScreen.BookPageDateInfo
import com.example.bookshelf.presentation.core.ui.theme.BookShelfTheme

@Composable
fun DetailScreenBody(modifier: Modifier = Modifier) {
    Column (
        modifier = modifier.fillMaxWidth().verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BookBasicInfo()

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_detail_tiny)))

        BookPageDateInfo()

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_detail_tiny)))

        Text(
            text = "Description",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.align(Alignment.Start)
        )

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_tiny)))

        Text(
            text = DummyData.items[0].volumeInfo.description,
            style = MaterialTheme.typography.displaySmall,
            color = MaterialTheme.colorScheme.onSecondary,
            modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_tiny))
        )
    }
}