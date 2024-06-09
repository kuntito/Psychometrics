package com.example.psychometrics.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.psychometrics.ui.components.button.ActiveActionButton
import com.example.psychometrics.ui.components.util.PreviewColumn
import com.example.psychometrics.ui.theme.colorSuccess
import com.example.psychometrics.ui.theme.h1_100
import com.example.psychometrics.ui.theme.h1_50
import com.example.psychometrics.ui.theme.h2_300


@Composable
fun LessonEndScreen(
    modifier: Modifier = Modifier,
    scoreString: String,
    goToHomeScreen: () -> Unit,
) {
    BackHandler {
        goToHomeScreen()
    }
    Column(
        modifier = modifier
            .padding(16.dp),
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "Lesson\ncomplete!",
                    style = h1_50.copy(
                        color = colorSuccess
                    ),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = scoreString,
                    style = h1_100,
                )
            }
        }
        ActiveActionButton(
            text = "Continue",
            onClick = goToHomeScreen,
            bgColor = colorSuccess,
            textStyle = h2_300,
        )
    }
}


@Preview
@Composable
fun LessonEndScreenPreview() {
    PreviewColumn {
        LessonEndScreen(
            scoreString = "2/3"
        ) {

        }
    }
}