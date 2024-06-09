package com.example.psychometrics.models.question_types

import com.example.psychometrics.models.option.OptionsAndAnswer
import com.example.psychometrics.models.option.StringOption
import com.example.psychometrics.models.question.OptionsQuestion
import com.example.psychometrics.models.question.QuestionType

data class AntonymQuestion(
    override val index: Int,
    val word: String,
    val oa: OptionsAndAnswer<String>
): OptionsQuestion<String>(word, oa){

    override val answerText: String
        get() = choiceManagers[0].answer

    override val type: QuestionType
        get() = QuestionType.Antonym
}

val sampleAntonymQuestion = AntonymQuestion(
    index = 0,
    word = "zoro",
    oa = OptionsAndAnswer(
        options = listOf(
            StringOption(1, "direction"),
            StringOption(2, "misdirection"),
            StringOption(3, "tiny brows"),
        ),
        answerId = 1
    )
)