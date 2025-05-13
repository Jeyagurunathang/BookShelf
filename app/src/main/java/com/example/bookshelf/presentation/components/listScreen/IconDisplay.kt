package com.example.bookshelf.presentation.components.listScreen

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.bookshelf.R

@Composable
fun IconDisplay(
    @DrawableRes icon: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    IconButton(
        modifier = modifier,
        onClick = onClick
    ) {
        Icon(
            painter = painterResource(icon),
            contentDescription = stringResource(R.string.search_icon),
            tint = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.padding(1.dp)
        )
    }
}