package com.example.bookshelf.presentation.components.listScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp

@Composable
fun LoadingScreen(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onPrimary
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            trackColor = MaterialTheme.colorScheme.secondaryContainer,
            color = color,
            strokeCap = StrokeCap.Round,
            modifier = Modifier.size(20.dp)
        )
    }
}