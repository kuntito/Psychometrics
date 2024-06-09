package com.example.psychometrics.ui.components

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.psychometrics.models.question.Question
import com.example.psychometrics.models.question_types.sampleCommonFeaturesQuestion
import com.example.psychometrics.ui.components.answer_block.getAnswerBlock
import com.example.psychometrics.ui.components.button.ActiveActionButton
import com.example.psychometrics.ui.components.button.FeedbackButton
import com.example.psychometrics.ui.components.button.InactiveActionButton
import com.example.psychometrics.ui.components.util.PreviewColumn

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuestionDisplay(
    modifier: Modifier = Modifier,
    question: Question,
    lessonProgress: Float,
    onCheckQuestion: () -> Unit,
    getNextQuestion: () -> Unit,
    goToHomeScreen: () -> Unit,
) {
    OnBackButton(lessonProgress) { goToHomeScreen() }
    val sheetState = rememberModalBottomSheetState( confirmValueChange = {
        false // `false` prevents modal sheet from being dismissed
    })
    var isSheetOpen by rememberSaveable { mutableStateOf(false) }
    var isAnswerChecked by remember{ mutableStateOf(false) }
    LaunchedEffect(key1 = question) {
        isAnswerChecked = false
    }

    Column(
        modifier = modifier
            .padding(start = 16.dp, end = 16.dp, top = 32.dp, bottom = 16.dp)
            .fillMaxSize(),
    ) {
        LessonProgressBar(progress = lessonProgress)
        QuestionFrame(
            question = question,
            modifier = Modifier
                .weight(1f)
        )
        Spacer(modifier = Modifier.height(16.dp))
        if (!isSheetOpen && isAnswerChecked) {
            FeedbackButton(
                status = question.answerStatus,
                onClick = getNextQuestion
            )
        } else if (question.isAnswered) {
            ActiveActionButton(text = "Check") {
                isSheetOpen = true
                isAnswerChecked = true
                onCheckQuestion()
            }
        } else {
            InactiveActionButton()
        }
    }

    val onDismissSheet = { isSheetOpen = false }
    if (isSheetOpen) {
        AnswerFeedbackPopup(
            sheetState = sheetState,
            answerStatus = question.answerStatus,
            answerBlock = { getAnswerBlock(question = question) },
            onDismissSheet = onDismissSheet,
            onFeedbackButtonClick = {
                onDismissSheet()
                getNextQuestion()
            },
        )
    }
}

@Preview
@Composable
fun QuestionDisplayPreview() {
    PreviewColumn {
        QuestionDisplay(
            question = sampleCommonFeaturesQuestion,
            lessonProgress = 0.3f,
            onCheckQuestion = {},
            getNextQuestion = {},
            goToHomeScreen = {},
        )
    }
}

@Composable
private fun OnBackButton(
    lessonProgress: Float,
    goToHomeScreen: () -> Unit,
) {
    var isVisible by remember { mutableStateOf(false) }
    val showDialog = { isVisible = true }
    val hideDialog = { isVisible = false }
    BackHandler(
        enabled = lessonProgress > 0f && lessonProgress < 1f,
        onBack = showDialog
    )
    QuitLessonDialog(
        onConfirm = goToHomeScreen,
        onDismiss = hideDialog,
        isVisible = isVisible,
    )
}