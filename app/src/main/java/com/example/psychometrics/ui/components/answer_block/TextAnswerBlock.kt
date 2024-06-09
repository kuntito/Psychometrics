package com.example.psychometrics.ui.components.answer_block

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.psychometrics.models.AnswerStatus
import com.example.psychometrics.ui.components.util.PreviewColumn
import com.example.psychometrics.ui.theme.ts300

@Composable
fun TextAnswerBlock(
    modifier: Modifier = Modifier,
    answer: String,
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
    ) {
        val style = ts300
        Text(
            text = "correct answer: ",
            style = style,
        )
        Text(
            text = answer,
            style = style.copy(
                color = AnswerStatus.Correct.bgColor
            ),
        )
    }
}

@Preview
@Composable
fun TextAnswerBlockPreview() {
    PreviewColumn {
        TextAnswerBlock(answer = "vibes, but you knew that!")
    }
}