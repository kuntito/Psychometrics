package com.example.psychometrics.ui.components.button

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.psychometrics.models.AnswerStatus
import com.example.psychometrics.ui.components.util.PreviewColumn

@Composable
fun FeedbackButton(
    modifier: Modifier = Modifier,
    status: AnswerStatus,
    onClick: () -> Unit,
) {
    BaseActionButton(
        text = status.buttonText,
        bgColor = status.bgColor,
        textColor = Color.White,
        borderColor = status.bgColor,
        isClickable = true,
        modifier = modifier,
    ) {
        onClick()
    }
}

@Preview
@Composable
fun FeedbackButtonPreview() {
    PreviewColumn {
        FeedbackButton(status = AnswerStatus.Correct) {}
        FeedbackButton(status = AnswerStatus.Wrong) {}
    }
}
