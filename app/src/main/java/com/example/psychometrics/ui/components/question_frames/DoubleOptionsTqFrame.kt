package com.example.psychometrics.ui.components.question_frames

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.psychometrics.models.question.DoubleOptionsQuestion
import com.example.psychometrics.models.question_types.sampleWordLinkQuestion
import com.example.psychometrics.ui.components.options.OptionsList
import com.example.psychometrics.ui.components.util.PreviewColumn
import com.example.psychometrics.ui.theme.ts200

@Composable
fun DoubleOptionsTqFrame(
    modifier: Modifier = Modifier,
    question: DoubleOptionsQuestion<String>
) {
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column {
            Text(
                text = question.text,
                style = ts200,
            )
            Spacer(modifier = Modifier.height(64.dp))
            Row {
                OptionsList(
                    options = question.optionsOne ,
                    selectedOptionId = question.selectedOptionOne,
                    onOptionClick = question::selectOptionOne,
                    modifier = Modifier.weight(1f),
                )
                Spacer(modifier = Modifier.width(16.dp))
                OptionsList(
                    options = question.optionsTwo,
                    selectedOptionId = question.selectedOptionTwo,
                    onOptionClick = question::selectOptionTwo,
                    modifier = Modifier.weight(1f),
                )
            }
        }
    }
}


@Preview
@Composable
fun DoubleOptionQfPreview() {
    PreviewColumn {
        DoubleOptionsTqFrame(question = sampleWordLinkQuestion)
    }
}