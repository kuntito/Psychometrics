package com.example.psychometrics.ui.components.answer_block

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.psychometrics.models.AnswerStatus
import com.example.psychometrics.ui.components.util.PreviewColumn
import com.example.psychometrics.ui.theme.colorOutline
import com.example.psychometrics.ui.theme.ts300

@Composable
fun ImageQuestionTab(
    modifier: Modifier = Modifier,
    correctOption: String,
    rationale: String,
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
    ) {
        val style = ts300
        Row {
            Text(
                text = "correct answer: ",
                style = style,
            )
            Text(
                text = correctOption,
                style = style.copy(color = colorOutline),
            )
        }
        Text(
            text = rationale,
            style = style.copy(
                color = AnswerStatus.Correct.bgColor
            ),
        )
    }
}

@Preview
@Composable
fun ImageQuestionTabPreview() {
    PreviewColumn {
        ImageQuestionTab(
            correctOption = "B",
            rationale = "but you knew that!"
        )
    }
}