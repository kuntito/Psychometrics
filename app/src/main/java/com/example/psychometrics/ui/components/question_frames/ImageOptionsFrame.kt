package com.example.psychometrics.ui.components.question_frames

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.psychometrics.models.question_types.CommonFeaturesQuestion
import com.example.psychometrics.models.question_types.sampleCommonFeaturesQuestion
import com.example.psychometrics.ui.components.image_question.ImageCarousel
import com.example.psychometrics.ui.components.image_question.ImageQuestionDisplay
import com.example.psychometrics.ui.components.util.PreviewColumn
import com.example.psychometrics.ui.theme.ts300

@Composable
fun ImageOptionsFrame(
    modifier: Modifier = Modifier,
    question: CommonFeaturesQuestion,
) {
    Column(
        modifier = modifier
            .padding(bottom = 32.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
    ) {
        ImageQuestionDisplay(
            imageId = question.imageQuestion,
            maxDim = 300,
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.height(64.dp))
        TextAndOptions(question = question)
    }
}

@Preview
@Composable
fun ImageOptionsPreview() {
    PreviewColumn {
        ImageOptionsFrame(question = sampleCommonFeaturesQuestion)
    }
}


@Composable
fun TextAndOptions(
    modifier: Modifier = Modifier,
    question: CommonFeaturesQuestion,
) {
    Column(modifier = modifier) {
        Text(
            text = question.text,
            style = ts300,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(32.dp))
        ImageCarousel(
            imageOptions = question.oa.options,
            onOptionClick = question::selectOption,
            selectedOptionId = question.selectedOption
        )
    }
}

@Preview
@Composable
fun TextAndOptionsPreview() {
    PreviewColumn {
        TextAndOptions(question = sampleCommonFeaturesQuestion)
    }
}