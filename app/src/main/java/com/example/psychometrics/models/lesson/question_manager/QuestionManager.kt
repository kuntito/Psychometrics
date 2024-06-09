package com.example.psychometrics.models.lesson.question_manager

import android.content.SharedPreferences
import com.example.psychometrics.models.question.Question

abstract class QuestionManager(val preferences: SharedPreferences) {
    abstract fun getQuestion(): Question?
    abstract fun onLessonEnd()

    abstract val totalQuestions: Int
}

