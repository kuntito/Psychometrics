package com.example.psychometrics

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.psychometrics.ui.screens.HomeScreen
import com.example.psychometrics.ui.screens.LessonEndScreen
import com.example.psychometrics.ui.screens.QuestionScreen
import kotlinx.serialization.Serializable

@Composable
fun Navigation(
    modifier: Modifier = Modifier,
    viewModel: AppViewModel,
) {
    viewModel.setNavController(rememberNavController())
    val navController = viewModel.navController

    NavHost(
        navController = navController,
        startDestination = Screens.HomeScreen,
        modifier = modifier
            .fillMaxSize()
    ){
        composable<Screens.HomeScreen> {
            HomeScreen{
                viewModel.onStartLesson()
            }
        }
        composable<Screens.QuestionScreen> {
            val question by viewModel.lessonManager.question.observeAsState()
            val lessonProgress by viewModel.lessonManager.progress.observeAsState()

            QuestionScreen(
                question = question,
                lessonProgress = lessonProgress!!,
                onCheckQuestion = viewModel.onCheckQuestion,
                onGetNextQuestion = viewModel.onGetNextQuestion,
                goToHomeScreen = { viewModel.goToHomeScreen() },
                onBackButton = { viewModel.goToPreviousScreen() }
            )
        }
        composable<Screens.LessonEndScreen> {
            LessonEndScreen(
                scoreString = viewModel.lessonManager.scoreString,
                goToHomeScreen = { viewModel.goToHomeScreen() }
            )
        }
    }
}



sealed class Screens {
    @Serializable
    object HomeScreen

    @Serializable
    object QuestionScreen

    @Serializable
    object LessonEndScreen
}

