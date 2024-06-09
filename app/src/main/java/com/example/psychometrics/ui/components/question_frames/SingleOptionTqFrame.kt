package com.example.psychometrics.ui.components.question_frames

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.psychometrics.models.question.OptionsQuestion
import com.example.psychometrics.models.question_types.sampleAnalogyQuestion
import com.example.psychometrics.ui.components.options.OptionsList
import com.example.psychometrics.ui.components.util.PreviewColumn
import com.example.psychometrics.ui.theme.ts200

@Composable
fun SingleOptionTqFrame(
    modifier: Modifier = Modifier,
    question: OptionsQuestion<String>,
    textAlign: TextAlign = TextAlign.Left
) {
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            modifier = Modifier,
        ) {
            Text(
                text = question.text,
                textAlign = textAlign,
                style = ts200,
                modifier = Modifier.fillMaxWidth(),
            )
            Spacer(modifier = Modifier.height(64.dp))
            OptionsList(
                options = question.optionsAndAnswer.options,
                selectedOptionId = question.selectedOption,
                onOptionClick =  question::selectOption
            )
        }
    }
}

@Preview
@Composable
fun SingleOptionQfPreview() {
    PreviewColumn {
        SingleOptionTqFrame(question = sampleAnalogyQuestion)
    }
}