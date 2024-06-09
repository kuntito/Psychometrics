package com.example.psychometrics.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.psychometrics.ui.components.util.PreviewColumn
import com.example.psychometrics.ui.theme.ts100

@Composable
fun NoQuestionAvailable(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "no questions\navailable",
            style = ts100,
            textAlign = TextAlign.Center,
        )
    }
}

@Preview
@Composable
fun NoQuestionAvailablePreview() {
    PreviewColumn {
        NoQuestionAvailable()
    }
}