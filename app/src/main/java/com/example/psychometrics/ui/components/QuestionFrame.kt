package com.example.psychometrics.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.example.psychometrics.models.question.Question
import com.example.psychometrics.models.question_types.AnalogyQuestion
import com.example.psychometrics.models.question_types.AntonymQuestion
import com.example.psychometrics.models.question_types.CommonFeaturesQuestion
import com.example.psychometrics.models.question_types.WordLinkQuestion
import com.example.psychometrics.ui.components.question_frames.DoubleOptionsTqFrame
import com.example.psychometrics.ui.components.question_frames.ImageOptionsFrame
import com.example.psychometrics.ui.components.question_frames.SingleOptionTqFrame

@Composable
fun QuestionFrame(
    modifier: Modifier = Modifier,
    question: Question,
) {
    when (question) {
        is AntonymQuestion -> {
            SingleOptionTqFrame(
                question = question,
                modifier = modifier,
                textAlign = TextAlign.Center,
            )
        }
        is AnalogyQuestion -> {
            SingleOptionTqFrame(
                question = question,
                modifier = modifier,
            )
        }
        is WordLinkQuestion -> {
            DoubleOptionsTqFrame(
                question = question,
                modifier = modifier,
            )
        }
        is CommonFeaturesQuestion -> {
            ImageOptionsFrame(
                question = question,
                modifier = modifier,
            )
        }
    }
}