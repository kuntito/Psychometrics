package com.example.psychometrics.data

import com.example.psychometrics.models.option.OptionsAndAnswer
import com.example.psychometrics.models.option.StringOption
import com.example.psychometrics.models.question_types.AnalogyQuestion

val analogyQuestions = listOf(
    AnalogyQuestion(
        index = 0,
        questionText = "Page is to book as petal is to:",
        oa = OptionsAndAnswer(
            options = listOf(
                StringOption(1, "stem"),
                StringOption(2, "leaf"),
                StringOption(3, "flower"),
            ),
            answerId = 3,
        ),
    ),
    AnalogyQuestion(
        index = 1,
        questionText = "Wing is to bird as fin is to:",
        oa = OptionsAndAnswer(
            options = listOf(
                StringOption(1, "fish"),
                StringOption(2, "ship"),
                StringOption(3, "scale"),
            ),
            answerId = 1,
        ),
    ),
    AnalogyQuestion(
        index = 2,
        questionText = "Artist is to paint as writer is to:",
        oa = OptionsAndAnswer(
            options = listOf(
                StringOption(1, "book"),
                StringOption(2, "pen"),
                StringOption(3, "novel"),
            ),
            answerId = 3,
        ),
    ),
    AnalogyQuestion(
        index = 3,
        questionText = "Tree is to forest as star is to:",
        oa = OptionsAndAnswer(
            options = listOf(
                StringOption(1, "planet"),
                StringOption(2, "galaxy"),
                StringOption(3, "moon"),
            ),
            answerId = 2,
        ),
    ),
    AnalogyQuestion(
        index = 4,
        questionText = "Key is to lock as password is to:",
        oa = OptionsAndAnswer(
            options = listOf(
                StringOption(1, "code"),
                StringOption(2, "door"),
                StringOption(3, "account"),
            ),
            answerId = 3,
        ),
    ),
    AnalogyQuestion(
        index = 5,
        questionText = "Bark is to dog as meow is to:",
        oa = OptionsAndAnswer(
            options = listOf(
                StringOption(1, "cow"),
                StringOption(2, "cat"),
                StringOption(3, "sheep"),
            ),
            answerId = 2,
        ),
    ),
    AnalogyQuestion(
        index = 6,
        questionText = "Heart is to body as engine is to:",
        oa = OptionsAndAnswer(
            options = listOf(
                StringOption(1, "car"),
                StringOption(2, "wheel"),
                StringOption(3, "battery"),
            ),
            answerId = 1,
        ),
    ),
    AnalogyQuestion(
        index = 7,
        questionText = "Knife is to cut as pen is to:",
        oa = OptionsAndAnswer(
            options = listOf(
                StringOption(1, "write"),
                StringOption(2, "erase"),
                StringOption(3, "draw"),
            ),
            answerId = 1,
        ),
    ),
    AnalogyQuestion(
        index = 8,
        questionText = "Eye is to see as ear is to:",
        oa = OptionsAndAnswer(
            options = listOf(
                StringOption(1, "hear"),
                StringOption(2, "smell"),
                StringOption(3, "taste"),
            ),
            answerId = 1,
        ),
    ),
    AnalogyQuestion(
        index = 9,
        questionText = "Day is to light as night is to:",
        oa = OptionsAndAnswer(
            options = listOf(
                StringOption(1, "moon"),
                StringOption(2, "dark"),
                StringOption(3, "dream"),
            ),
            answerId = 2,
        ),
    ),
)