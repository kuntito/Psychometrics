package com.example.psychometrics.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.psychometrics.ui.theme.colorError
import com.example.psychometrics.ui.theme.colorSuccess


enum class AnswerStatus(
    val bgColor: Color,
    val icon: ImageVector,
    val contentDescription: String,
    val message: String,
    val buttonText: String,
) {
    Correct(
        bgColor = colorSuccess,
        icon = Icons.Filled.Check,
        contentDescription = "tick icon badge",
        message = "Correct!",
        buttonText = "Continue"
    ),
    Wrong(
        bgColor = colorError,
        icon = Icons.Filled.Close,
        contentDescription = "close icon badge",
        message = "Wrong answer",
        buttonText = "Got it"
    )
}