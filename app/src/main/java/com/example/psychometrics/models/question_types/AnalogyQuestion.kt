package com.example.psychometrics.models.question_types

import com.example.psychometrics.models.option.OptionsAndAnswer
import com.example.psychometrics.models.option.StringOption
import com.example.psychometrics.models.question.OptionsQuestion
import com.example.psychometrics.models.question.QuestionType

data class AnalogyQuestion(
    override val index: Int,
    val questionText: String,
    val oa: OptionsAndAnswer<String>
): OptionsQuestion<String>(questionText, oa){

    override val answerText: String
        get() = choiceManagers[0].answer

    override val type: QuestionType
        get() = QuestionType.Analogy
}

val sampleAnalogyQuestion = AnalogyQuestion(
    index = 0,
    questionText = "Nas is to ether as\nkendrick is to:",
    oa = OptionsAndAnswer(
        options = listOf(
            StringOption(1, "litty"),
            StringOption(2, "story of adidon"),
            StringOption(3, "euphoria"),
        ),
        answerId = 3,
    )
)