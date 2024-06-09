package com.example.psychometrics.data

import com.example.psychometrics.R
import com.example.psychometrics.models.option.ImageOption
import com.example.psychometrics.models.option.OptionsAndAnswer
import com.example.psychometrics.models.question_types.CommonFeaturesQuestion

val commonFeaturesQuestions = listOf(
    CommonFeaturesQuestion(
        index = 0,
        imageQuestion = R.drawable.cf_samp_000,
        questionText = "complete the sequence above",
        oa = OptionsAndAnswer(
            options = listOf(
                ImageOption(0, R.drawable.cf_samp_000_0),
                ImageOption(1, R.drawable.cf_samp_000_1),
                ImageOption(2, R.drawable.cf_samp_000_2),
                ImageOption(3, R.drawable.cf_samp_000_3),
                ImageOption(4, R.drawable.cf_samp_000_4),
            ),
            answerId = 2
        ),
        explanation = "The base figure rotates at an angle of 45 degrees in the anti-clockwise direction. Hence choice C is the perfect match."
    ),
    CommonFeaturesQuestion(
        index = 1,
        imageQuestion = R.drawable.cf_samp_001,
        questionText = "complete the sequence above",
        oa = OptionsAndAnswer(
            options = listOf(
                ImageOption(0, R.drawable.cf_samp_001_0),
                ImageOption(1, R.drawable.cf_samp_001_1),
                ImageOption(2, R.drawable.cf_samp_001_2),
                ImageOption(3, R.drawable.cf_samp_001_3),
            ),
            answerId = 3
        ),
        explanation = "In the given series, a figure is followed by the combination of itself and its vertical inversion."
    ),
    CommonFeaturesQuestion(
        index = 2,
        imageQuestion = R.drawable.cf_samp_002,
        oa = OptionsAndAnswer(
            options = listOf(
                ImageOption(0, R.drawable.cf_samp_002_0),
                ImageOption(1, R.drawable.cf_samp_002_1),
                ImageOption(2, R.drawable.cf_samp_002_2),
            ),
            answerId = 1
        ),
        explanation = "if you subtract the top number of dots from the bottom number the remainder is 3"
    ),
)