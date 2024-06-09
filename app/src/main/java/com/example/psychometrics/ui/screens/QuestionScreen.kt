package com.example.psychometrics.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.psychometrics.models.question.Question
import com.example.psychometrics.ui.components.NoQuestionAvailable
import com.example.psychometrics.ui.components.QuestionDisplay
import com.example.psychometrics.ui.components.button.BackButton
import com.example.psychometrics.ui.theme.color100
import com.example.psychometrics.ui.theme.color400
import com.example.psychometrics.ui.theme.color500
import com.example.psychometrics.ui.theme.h2_200

const val qsTag = "qsTag"
@Composable
fun QuestionScreen(
    modifier: Modifier = Modifier,
    question: Question?,
    lessonProgress: Float,
    onCheckQuestion: () -> Unit,
    onGetNextQuestion: () -> Unit,
    goToHomeScreen: () -> Unit,
    onBackButton: () -> Unit,
) {
    Log.d(qsTag, "question: $question, type: ${question?.type}")
    Scaffold(
        modifier = modifier
            .background(color = color500)
            .fillMaxSize(),
        topBar = {
            TopBar(
                title = question?.type?.text ?: " ",
                onBackButton=onBackButton
            )
        }
    ) { paddingValues ->
        val mod: Modifier = Modifier.padding(paddingValues)
        question?.let { 
            QuestionDisplay(
                question = question,
                lessonProgress = lessonProgress,
                onCheckQuestion = onCheckQuestion,
                getNextQuestion = onGetNextQuestion,
                goToHomeScreen = goToHomeScreen,
                modifier = mod
            )   
        }
        if (question == null) {
            NoQuestionAvailable(modifier = mod)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar(
    modifier: Modifier = Modifier,
    onBackButton: () -> Unit,
    title: String,
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = title,
                style = h2_200
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = color400,
            titleContentColor = color100,
        ),
        navigationIcon = {
            BackButton {
                onBackButton()
            }
        }
    )
}
