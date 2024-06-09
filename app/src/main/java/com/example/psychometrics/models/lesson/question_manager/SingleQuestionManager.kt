package com.example.psychometrics.models.lesson.question_manager

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.util.Log
import com.example.psychometrics.models.question.Question
import com.example.psychometrics.models.question.QuestionType

class SingleQuestionManager(
    private val pref: SharedPreferences,
    private val type: QuestionType,
): QuestionManager(pref) {
    private var index: Int = 0
    private val allQuestions: List<Question> = type.questions

    init {
        val loadedIndex = pref.getInt(type.text, 0)
        index = if (loadedIndex >= type.questions.size) 0 else loadedIndex
    }

    override val totalQuestions: Int
        get() = allQuestions.size

    override fun getQuestion(): Question? {
        if (index !in allQuestions.indices) return null

        val nextQuestion = allQuestions[index]
        nextQuestion.clearInput()
        updateIndex()
        return nextQuestion
    }

    @SuppressLint("CommitPrefEdits")
    private fun updateIndex() {
        saveCurrentIndex()
        if (index >= allQuestions.lastIndex) { index = -1 }
        index++
    }

    private fun saveCurrentIndex() {
        pref.edit().apply {
            putInt(type.text, index)
            apply()
        }
    }

    override fun onLessonEnd() {
        saveCurrentIndex()
    }
}