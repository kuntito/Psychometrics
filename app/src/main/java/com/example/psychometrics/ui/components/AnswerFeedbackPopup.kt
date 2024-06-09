package com.example.psychometrics.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.psychometrics.models.AnswerStatus
import com.example.psychometrics.models.question.Question
import com.example.psychometrics.models.question_types.sampleAnalogyQuestion
import com.example.psychometrics.ui.components.answer_block.getAnswerBlock
import com.example.psychometrics.ui.components.util.PreviewColumn


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnswerFeedbackPopup(
    modifier: Modifier = Modifier,
    sheetState: SheetState,
    answerStatus: AnswerStatus,
    answerBlock: @Composable () -> Unit,
    onDismissSheet: () -> Unit,
    onFeedbackButtonClick: () -> Unit,
) {
    ModalBottomSheet(
        modifier = modifier,
        sheetState = sheetState,
        shape = RoundedCornerShape(0.dp),
        dragHandle = null,
        onDismissRequest = onDismissSheet,
    ) {
        Box(
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 16.dp,
                    bottom = 104.dp
                )
        ) {
            AnswerFeedbackCard(
                answerStatus = answerStatus,
                answerBlock = answerBlock,
                onClick = onFeedbackButtonClick,
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun AnswerFeedbackPopupPreview() {
    PreviewColumn {
        val sheetState = rememberModalBottomSheetState( confirmValueChange = { false })
        var isSheetOpen by rememberSaveable { mutableStateOf(false) }
        val onDismissSheet = { isSheetOpen = false }

        AnswerFeedbackPopup(
            sheetState = sheetState,
//            answerStatus = AnswerStatus.Wrong,
            answerStatus = AnswerStatus.Correct,
            answerBlock = { getAnswerBlock(question = sampleAnalogyQuestion) },
            onDismissSheet = onDismissSheet,
            onFeedbackButtonClick = {
                onDismissSheet()
            },
        )
    }
}