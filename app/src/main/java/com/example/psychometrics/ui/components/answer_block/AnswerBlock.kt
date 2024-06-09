package com.example.psychometrics.ui.components.answer_block

import androidx.compose.runtime.Composable
import com.example.psychometrics.models.question.BaseOptionsQuestion
import com.example.psychometrics.models.question.Question
import com.example.psychometrics.models.question_types.ImageQuestion


@Composable
fun getAnswerBlock(question: Question) {
    if (question is ImageQuestion) {
        ImageQuestionTab(
            correctOption = question.correctOption,
            rationale = question.explanation
        )
    } else if (question is BaseOptionsQuestion<*>) {
        TextAnswerBlock(answer = question.answerText)
    }
}