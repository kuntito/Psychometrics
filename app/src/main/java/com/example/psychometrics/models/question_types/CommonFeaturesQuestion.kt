package com.example.psychometrics.models.question_types

import androidx.annotation.DrawableRes
import com.example.psychometrics.R
import com.example.psychometrics.models.option.ImageOption
import com.example.psychometrics.models.option.OptionsAndAnswer
import com.example.psychometrics.models.question.OptionsQuestion
import com.example.psychometrics.models.question.QuestionType

abstract class ImageQuestion(
    text: String,
    oa: OptionsAndAnswer<Int>
): OptionsQuestion<Int>(text, oa) {
    abstract val explanation: String
    abstract val correctOption: String
    override val answerText: String
        get() = explanation
}


class CommonFeaturesQuestion(
    override val index: Int,
    @DrawableRes
    val imageQuestion: Int,
    val questionText: String = "which image is similar to the ones above?",
    val oa: OptionsAndAnswer<Int>,
    override val explanation: String,
): ImageQuestion(
    questionText,
    oa
) {
    override val correctOption: String
        get() = "Image ${oa.answerId}"
    override val type: QuestionType
        get() = QuestionType.CommonFeatures
}

val sampleCommonFeaturesQuestion = CommonFeaturesQuestion(
    index = 0,
    imageQuestion = R.drawable.common_features_question,
    oa = OptionsAndAnswer(
        options = listOf(
            ImageOption(0, R.drawable.cf_samp_002_0),
            ImageOption(1, R.drawable.cf_samp_002_1),
            ImageOption(2, R.drawable.cf_samp_002_2),
        ),
        answerId = 1
    ),
    explanation = "if you subtract the top number of dots from the bottom number the remainder is 3"
)

val sampleCommonFeaturesQuestionSquare = CommonFeaturesQuestion(
    index = 0,
    imageQuestion = R.drawable.common_features_question,
    oa = OptionsAndAnswer(
        options = listOf(
            ImageOption(0, R.drawable.square_image),
            ImageOption(1, R.drawable.square_image),
            ImageOption(2, R.drawable.square_image),
        ),
        answerId = 1
    ),
    explanation = "if you subtract the top number of dots from the bottom number the remainder is 3"
)