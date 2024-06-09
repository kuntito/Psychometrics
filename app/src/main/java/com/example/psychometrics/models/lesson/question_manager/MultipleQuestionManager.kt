package com.example.psychometrics.models.lesson.question_manager

import android.content.SharedPreferences
import com.example.psychometrics.models.question.Question
import com.example.psychometrics.models.question.QuestionType
import kotlin.random.Random


val mqTag = "mqTag"
class MultipleQuestionManager(
    private val pref: SharedPreferences,
    private val questionTypes: List<QuestionType>,
): QuestionManager(pref) {
    private val prefKey = "multiPref"
    private var index: Int = 0
    private lateinit var questionManagers: List<QuestionManager>

    override val totalQuestions: Int
        get() = questionManagers.sumOf { it.totalQuestions }

    init {
        val loadedIndex = pref.getInt(prefKey, 0)
        initializeQuestionManagers(loadedIndex)
    }

    private fun getIndex(): Int {
        return Random.nextInt(0, questionManagers.size)
    }

    private fun initializeQuestionManagers(loadedIndex: Int) {
        questionManagers = questionTypes.map {
            SingleQuestionManager(pref, it)
        }

        index = if (loadedIndex < questionManagers.size) loadedIndex else getIndex()
    }

    override fun getQuestion(): Question? {
        val question = questionManagers[index].getQuestion()
        saveIndex()
        index = getIndex()
        return question
    }

    private fun saveIndex() {
        pref.edit().apply {
            putInt(prefKey, index)
            apply()
        }
    }

    override fun onLessonEnd() {
        questionManagers.forEach {
            it.onLessonEnd()
        }
    }
}