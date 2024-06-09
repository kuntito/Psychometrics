package com.example.psychometrics.models.question_types

import com.example.psychometrics.models.option.OptionsAndAnswer
import com.example.psychometrics.models.option.StringOption
import com.example.psychometrics.models.question.DoubleOptionsQuestion
import com.example.psychometrics.models.question.OptionsQuestion
import com.example.psychometrics.models.question.QuestionType

data class WordLinkQuestion(
    override val index: Int,
    val questionText: String = "Which words have the strongest connection?",
    val oaOne: OptionsAndAnswer<String>,
    val oaTwo: OptionsAndAnswer<String>,
): DoubleOptionsQuestion<String>(
    questionText,
    oaOne,
    oaTwo
){
    override val answerText: String
        get() = choiceManagers[0].answer + "-" + choiceManagers[1].answer

    override val type: QuestionType
        get() = QuestionType.Analogy
}

val sampleWordLinkQuestion = WordLinkQuestion(
    index = 0,
    oaOne = OptionsAndAnswer(
        options = listOf(
            StringOption(1, "mahrez"),
            StringOption(2, "tunde ednut"),
            StringOption(3, "sumn' wrong"),
        ),
        answerId = 3,
    ),
    oaTwo = OptionsAndAnswer(
        options = listOf(
            StringOption(1, "yemi alade"),
            StringOption(2, "i hold my head"),
            StringOption(3, "aguero"),
        ),
        answerId = 2,
    )
)