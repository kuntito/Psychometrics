package com.example.psychometrics.models.question

import com.example.psychometrics.data.analogyQuestions
import com.example.psychometrics.data.antonymQuestions
import com.example.psychometrics.data.commonFeaturesQuestions
import com.example.psychometrics.data.wordLinkQuestions
import com.example.psychometrics.models.question_types.sampleCommonFeaturesQuestion
import com.example.psychometrics.models.question_types.sampleCommonFeaturesQuestionSquare

enum class QuestionType(
    val text: String,
    val prefix: String,
    val questions: List<Question>,
) {
    Analogy(
        "analogies",
        "anl",
        analogyQuestions,
    ),
    WordLink(
        "links",
        "lnk",
        wordLinkQuestions,
    ),
    Antonym(
        "antonyms",
        "atm",
        antonymQuestions,
    ),
    FindNewWord(
        "find new word",
        "fnw",
        listOf()
    ),
    CommonFeatures(
        "common features",
        "cf",
        commonFeaturesQuestions,
    )
}