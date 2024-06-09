package com.example.psychometrics.models.question

import com.example.psychometrics.models.AnswerStatus
import com.example.psychometrics.models.ChoiceManager
import com.example.psychometrics.models.option.OptionsAndAnswer
import com.example.psychometrics.models.question.QuestionType

abstract class Question {
    abstract val index: Int
    abstract val answerText: String
    abstract val isAnswered: Boolean
    abstract val isUserCorrect: Boolean
    abstract val type: QuestionType

    abstract fun clearInput()


    val id: String
        get() = getId(type, index)
    val answerStatus: AnswerStatus
        get() = if (isUserCorrect) AnswerStatus.Correct else AnswerStatus.Wrong

    fun getId(type:QuestionType, x: Int): String {
        return "${type.prefix}_$x"
    }
}

abstract class BaseOptionsQuestion<T>(
    text: String,
    val choiceManagers: List<ChoiceManager<T>>
): Question() {
    val selectedOptions
        get() = choiceManagers.map { it.choice }

    fun selectOption(optionId: Int) {
        if (choiceManagers.size == 1) {
            choiceManagers[0].updateChoice(optionId)
        } else {
            throw UnsupportedOperationException("Use selectOptionAt for multiple choice managers")
        }
    }

    fun selectOptionAt(managerIndex: Int, optionId: Int) {
        choiceManagers[managerIndex].updateChoice(optionId)
    }

    override val isAnswered: Boolean
        get() = choiceManagers.all { it.isChoiceValid }

    override val isUserCorrect: Boolean
        get() = choiceManagers.all { it.isCorrect }

    override fun clearInput() {
        choiceManagers.forEach { it.clearChoice() }
    }
}


abstract class OptionsQuestion<T>(
    val text: String,
    val optionsAndAnswer: OptionsAndAnswer<T>
): BaseOptionsQuestion<T>(
    text,
    listOf(ChoiceManager(optionsAndAnswer))
) {
    val selectedOption
        get() = selectedOptions[0]
}


abstract class DoubleOptionsQuestion<T>(
    val text: String,
    private val optionsAnswerOne: OptionsAndAnswer<T>,
    private val optionsAnswerTwo: OptionsAndAnswer<T>,
): BaseOptionsQuestion<T>(
    text,
    listOf(
        ChoiceManager(optionsAnswerOne),
        ChoiceManager(optionsAnswerTwo),
    )
) {
    val optionsOne
        get() = optionsAnswerOne.options
    val optionsTwo
        get() = optionsAnswerTwo.options

    val selectedOptionOne
        get() = selectedOptions[0]
    val selectedOptionTwo
        get() = selectedOptions[1]

    fun selectOptionOne(optionId: Int) {
        selectOptionAt(0, optionId)
    }

    fun selectOptionTwo(optionId: Int) {
        selectOptionAt(1, optionId)
    }
}