package com.example.psychometrics.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import com.example.psychometrics.models.option.OptionsAndAnswer

class ChoiceManager<T>(
    private val oa: OptionsAndAnswer<T>
) {
    init {
        require(oa.answerId != -1) {
            "correct choice cannot be -1"
        }
    }

    private var _choice by mutableIntStateOf(-1)

    val choice: Int
        get() = _choice

    fun updateChoice(newChoice: Int) {
        _choice = newChoice
    }

    fun clearChoice() {
        _choice = -1
    }

    val isCorrect: Boolean
        get() = oa.answerId == choice

    val isChoiceValid: Boolean
        get() = choice in oa.options.map { it.id }

    val answer: T
        get() = oa.answer.value
}