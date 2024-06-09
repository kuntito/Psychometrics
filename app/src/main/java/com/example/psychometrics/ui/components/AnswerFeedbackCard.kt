package com.example.psychometrics.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.psychometrics.models.AnswerStatus
import com.example.psychometrics.models.question_types.sampleAnalogyQuestion
import com.example.psychometrics.ui.components.answer_block.getAnswerBlock
import com.example.psychometrics.ui.components.button.FeedbackButton
import com.example.psychometrics.ui.components.util.PreviewColumn


@Composable
fun AnswerFeedbackCard(
    modifier: Modifier = Modifier,
    answerStatus: AnswerStatus,
    answerBlock: @Composable () -> Unit,
    onClick: () -> Unit,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        BadgeAndStatusMessage(status = answerStatus)
        if (answerStatus == AnswerStatus.Wrong) {
            answerBlock()
        }
        FeedbackButton(
            status = answerStatus,
            onClick = onClick,
        )
    }
}

@Preview
@Composable
fun AnswerFeedbackCardPreview() {
    PreviewColumn {
        AnswerFeedbackCard(
            answerStatus = AnswerStatus.Correct,
            answerBlock = {
                getAnswerBlock(
                    question = sampleAnalogyQuestion
                )
            }
        ) {}
    }
}

