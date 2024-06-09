package com.example.psychometrics.data

import com.example.psychometrics.models.option.OptionsAndAnswer
import com.example.psychometrics.models.option.StringOption
import com.example.psychometrics.models.question_types.WordLinkQuestion


val wordLinkQuestions = listOf(
    WordLinkQuestion(
        index = 0,
        oaOne = OptionsAndAnswer(
            options = listOf(
                StringOption(1, "Harvest"),
                StringOption(2, "Plant"),
                StringOption(3, "Nourish"),
            ),
            answerId = 2,
        ),
        oaTwo = OptionsAndAnswer(
            options = listOf(
                StringOption(1, "Sow"),
                StringOption(2, "Grow"),
                StringOption(3, "Reap"),
            ),
            answerId = 1,
        ),
    ),
    WordLinkQuestion(
        index = 1,
        oaOne = OptionsAndAnswer(
            options = listOf(
                StringOption(1, "Craft"),
                StringOption(2, "Break"),
                StringOption(3, "Design"),
            ),
            answerId = 1,
        ),
        oaTwo = OptionsAndAnswer(
            options = listOf(
                StringOption(1, "Create"),
                StringOption(2, "Destroy"),
                StringOption(3, "Shape"),
            ),
            answerId = 1,
        ),
    ),
    WordLinkQuestion(
        index = 2,
        oaOne = OptionsAndAnswer(
            options = listOf(
                StringOption(1, "Fly"),
                StringOption(2, "Swim"),
                StringOption(3, "Walk"),
            ),
            answerId = 1,
        ),
        oaTwo = OptionsAndAnswer(
            options = listOf(
                StringOption(1, "Soar"),
                StringOption(2, "Dive"),
                StringOption(3, "Run"),
            ),
            answerId = 1,
        ),
    ),
    WordLinkQuestion(
        index = 3,
        oaOne = OptionsAndAnswer(
            options = listOf(
                StringOption(1, "Laugh"),
                StringOption(2, "Cry"),
                StringOption(3, "Smile"),
            ),
            answerId = 1,
        ),
        oaTwo = OptionsAndAnswer(
            options = listOf(
                StringOption(1, "Giggle"),
                StringOption(2, "Weep"),
                StringOption(3, "Grin"),
            ),
            answerId = 1,
        ),
    ),
    WordLinkQuestion(
        index = 4,
        oaOne = OptionsAndAnswer(
            options = listOf(
                StringOption(1, "Build"),
                StringOption(2, "Demolish"),
                StringOption(3, "Construct"),
            ),
            answerId = 1,
        ),
        oaTwo = OptionsAndAnswer(
            options = listOf(
                StringOption(1, "Erect"),
                StringOption(2, "Destroy"),
                StringOption(3, "Form"),
            ),
            answerId = 1,
        ),
    ),
    WordLinkQuestion(
        index = 5,
        oaOne = OptionsAndAnswer(
            options = listOf(
                StringOption(1, "Whisper"),
                StringOption(2, "Shout"),
                StringOption(3, "Speak"),
            ),
            answerId = 1,
        ),
        oaTwo = OptionsAndAnswer(
            options = listOf(
                StringOption(1, "Murmur"),
                StringOption(2, "Yell"),
                StringOption(3, "Talk"),
            ),
            answerId = 1,
        ),
    ),
    WordLinkQuestion(
        index = 6,
        oaOne = OptionsAndAnswer(
            options = listOf(
                StringOption(1, "Glow"),
                StringOption(2, "Dim"),
                StringOption(3, "Shine"),
            ),
            answerId = 1,
        ),
        oaTwo = OptionsAndAnswer(
            options = listOf(
                StringOption(1, "Radiate"),
                StringOption(2, "Darken"),
                StringOption(3, "Glare"),
            ),
            answerId = 1,
        ),
    ),
    WordLinkQuestion(
        index = 7,
        oaOne = OptionsAndAnswer(
            options = listOf(
                StringOption(1, "Launch"),
                StringOption(2, "Abort"),
                StringOption(3, "Initiate"),
            ),
            answerId = 1,
        ),
        oaTwo = OptionsAndAnswer(
            options = listOf(
                StringOption(1, "Begin"),
                StringOption(2, "Stop"),
                StringOption(3, "Start"),
            ),
            answerId = 1,
        ),
    ),
    WordLinkQuestion(
        index = 8,
        oaOne = OptionsAndAnswer(
            options = listOf(
                StringOption(1, "Teach"),
                StringOption(2, "Learn"),
                StringOption(3, "Instruct"),
            ),
            answerId = 1,
        ),
        oaTwo = OptionsAndAnswer(
            options = listOf(
                StringOption(1, "Educate"),
                StringOption(2, "Study"),
                StringOption(3, "Coach"),
            ),
            answerId = 1,
        ),
    ),
    WordLinkQuestion(
        index = 9,
        oaOne = OptionsAndAnswer(
            options = listOf(
                StringOption(1, "Heal"),
                StringOption(2, "Injure"),
                StringOption(3, "Cure"),
            ),
            answerId = 1,
        ),
        oaTwo = OptionsAndAnswer(
            options = listOf(
                StringOption(1, "Mend"),
                StringOption(2, "Hurt"),
                StringOption(3, "Treat"),
            ),
            answerId = 1,
        ),
    ),
)