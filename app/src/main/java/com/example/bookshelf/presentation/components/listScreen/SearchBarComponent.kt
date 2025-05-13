package com.example.bookshelf.presentation.components.listScreen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.bookshelf.R
import com.example.bookshelf.presentation.core.ui.theme.BookShelfTheme

@Composable
fun SearchBarComponent(
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit = {},
    onCancelClicked: () -> Unit = {}
) {
    var enteredBookCategory by remember { mutableStateOf("") }

    val focusManager = LocalFocusManager.current

    Row (
        modifier = Modifier
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
            leadingIcon = {
                IconButton(
                    onClick = onCancelClicked
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = "Back"
                    )
                }
            },
            trailingIcon = {
                if (enteredBookCategory.isNotEmpty()) {
                    IconDisplay(
                        icon = R.drawable.search,
                        modifier = Modifier.size(16.dp),
                        onClick = {
                            onClick(enteredBookCategory)
                            focusManager.clearFocus()
                        }
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
            modifier = modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Go
            ),
            keyboardActions = KeyboardActions(
                onGo = {
                    onClick(enteredBookCategory)
                    focusManager.clearFocus()
                }
            )
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