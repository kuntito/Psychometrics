package com.example.psychometrics.models.lesson

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.psychometrics.models.lesson.question_manager.MultipleQuestionManager
import com.example.psychometrics.models.lesson.question_manager.QuestionManager
import com.example.psychometrics.models.lesson.question_manager.SingleQuestionManager
import com.example.psychometrics.models.question.Question
import com.example.psychometrics.models.question.QuestionType

class LessonManager(
    val pref: SharedPreferences,
    val questionCount: Int,
    val goToLessonEndScreen: () -> Unit,
    private val questionTypes: List<QuestionType>,
) {
    private var questionsSent: Int = 0
    private var score = 0
    private var _question = MutableLiveData<Question?>()
    val question: LiveData<Question?>
        get() = _question
    private var _scoreString = ""
    val scoreString
        get() = _scoreString

    private val lessonProgress = LessonProgress(questionCount)
    val progress: LiveData<Float>
        get() = lessonProgress.progress

    fun onCheckQuestion() {
        lessonProgress.increment()
    }

    private lateinit var questionManager: QuestionManager
    fun startLesson() {
        initializeVariables()
        questionManager = MultipleQuestionManager(pref, questionTypes)
//        questionManager = SingleQuestionManager(
//            pref,
//            QuestionType.WordLink,
//        )
        getQuestion()
    }

    fun getQuestion() {
        updateScore()

        if (questionsSent >= questionCount) {
            endLesson()
        } else {
            _question.value = questionManager.getQuestion()
            questionsSent += 1
        }
    }

    private fun updateScore() {
        score += _question.value?.let {
            if (it.isUserCorrect) 1 else 0
        } ?: 0
    }

    private fun endLesson() {
        _scoreString = "$score/$questionCount"
        questionManager.onLessonEnd()
        goToLessonEndScreen()
        initializeVariables()
    }

    init {
        initializeVariables()
    }

    private fun initializeVariables() {
        questionsSent = 0
        score = 0
        lessonProgress.reset()
        _question.value = null
    }
}