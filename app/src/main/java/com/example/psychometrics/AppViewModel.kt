package com.example.psychometrics

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.psychometrics.models.lesson.LessonManager
import com.example.psychometrics.models.question.QuestionType

const val vmTag = "vmTag"
class AppViewModel: ViewModel() {
    private val questionsPerLesson = 5
    lateinit var lessonManager: LessonManager
    private val questionTypes = listOf(
        QuestionType.Antonym,
        QuestionType.Analogy,
        QuestionType.WordLink,
        QuestionType.CommonFeatures,
    )

    private var _navController: NavHostController? = null
    val navController: NavHostController
        get() = _navController!!

    fun setNavController(nav: NavHostController) {
        _navController = nav
    }

    fun setupLessonManager(pref: SharedPreferences) {
        lessonManager = LessonManager(
            pref = pref,
            questionCount = questionsPerLesson,
            questionTypes = questionTypes,
            goToLessonEndScreen = {
                navController.navigate(Screens.LessonEndScreen)
            }
        )
    }

    fun onStartLesson() {
        lessonManager.startLesson()
        navController.navigate(Screens.QuestionScreen)
    }

    val onGetNextQuestion = {
        lessonManager.getQuestion()
    }

    val onCheckQuestion = {
        lessonManager.onCheckQuestion()
    }

    // navigations
    val goToHomeScreen = {
        navController.popBackStack(
            Screens.HomeScreen,
            inclusive = false,
        )
    }

    val goToPreviousScreen = {
        navController.popBackStack()
    }
}