package com.example.bookshelf.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.bookshelf.R
import com.example.bookshelf.presentation.core.ui.theme.BookShelfTheme

@Composable
fun SearchBarComponent(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    onCancelClicked: () -> Unit = {}
) {
    var enteredBookCategory by remember { mutableStateOf("") }
    Row (
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = enteredBookCategory,
            singleLine = true,
            placeholder = {
                Text(
                    text = stringResource(R.string.search_bar_placeholder),
                    style = MaterialTheme.typography.labelLarge
                )
            },
            onValueChange = { enteredBookCategory = it },
            trailingIcon = {
                if (enteredBookCategory.isNotEmpty()) {
                    IconDisplay(
                        icon = R.drawable.search,
                        modifier = Modifier.size(16.dp),
                        onClick = onClick
                    )
                } else {
                    IconDisplay(
                        icon = R.drawable.remove,
                        modifier = Modifier.size(16.dp),
                        onClick = {
                            enteredBookCategory = ""
                            onCancelClicked()
                        }
                    )
                }
            },
            textStyle = MaterialTheme.typography.labelLarge,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(50.dp),
            modifier = modifier.fillMaxWidth()

        )
    }
}

@PreviewLightDark
@Composable
fun SearchBarComponentPreview(modifier: Modifier = Modifier) {
    BookShelfTheme(dynamicColor = false) {
        SearchBarComponent()
    }
}