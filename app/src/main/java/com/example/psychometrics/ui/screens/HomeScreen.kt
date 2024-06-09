package com.example.psychometrics.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.psychometrics.ui.components.button.SquircleButton
import com.example.psychometrics.ui.components.util.PreviewColumn
import com.example.psychometrics.ui.theme.color100
import com.example.psychometrics.ui.theme.color400
import com.example.psychometrics.ui.theme.color500
import com.example.psychometrics.ui.theme.h2_200

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onStartLesson: () -> Unit,
) {
    Scaffold(
        modifier = modifier
            .background(color = color500)
            .fillMaxSize(),
        topBar = { TopBar() }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = it),
            contentAlignment = Alignment.Center,
        ){
            SquircleButton(text = "start\nlesson") {
                onStartLesson()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar(
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = "psychometrics",
                style = h2_200
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = color400,
            titleContentColor = color100,
        )
    )
}

@Preview
@Composable
fun HomeScreenPreview() {
    PreviewColumn {
        HomeScreen{}
    }
}