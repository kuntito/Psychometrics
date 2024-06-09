package com.example.psychometrics.data

import com.example.psychometrics.models.option.OptionsAndAnswer
import com.example.psychometrics.models.option.StringOption
import com.example.psychometrics.models.question_types.AntonymQuestion

val antonymQuestions = listOf(
    AntonymQuestion(
        index = 0,
        word = "Expand",
        oa = OptionsAndAnswer(
            listOf(
                StringOption(1, "Enlarge"),
                StringOption(2, "Contract"),
                StringOption(3, "Broaden"),
            ),
            2
        ),
    ),
    AntonymQuestion(
        index = 1,
        word = "Frugal",
        oa = OptionsAndAnswer(
            listOf(
                StringOption(1, "Lavish"),
                StringOption(2, "Stingy"),
                StringOption(3, "Prudent"),
            ),
            1
        ),
    ),
    AntonymQuestion(
        index = 2,
        word = "Support",
        oa = OptionsAndAnswer(
            listOf(
                StringOption(1, "Assist"),
                StringOption(2, "Undermine"),
                StringOption(3, "Encourage"),
            ),
            2
        ),
    ),
    AntonymQuestion(
        index = 3,
        word = "Diligent",
        oa = OptionsAndAnswer(
            listOf(
                StringOption(1, "Industrious"),
                StringOption(2, "Lazy"),
                StringOption(3, "Meticulous"),
            ),
            2
        ),
    ),
    AntonymQuestion(
        index = 4,
        word = "Bright",
        oa = OptionsAndAnswer(
            listOf(
                StringOption(1, "Luminous"),
                StringOption(2, "Dark"),
                StringOption(3, "Radiant"),
            ),
            2
        ),
    ),
    AntonymQuestion(
        index = 5,
        word = "Abundant",
        oa = OptionsAndAnswer(
            listOf(
                StringOption(1, "Plentiful"),
                StringOption(2, "Scarce"),
                StringOption(3, "Ample"),
                StringOption(4, "Copious"),
            ),
            2
        ),
    ),
    AntonymQuestion(
        index = 6,
        word = "Harmony",
        oa = OptionsAndAnswer(
            listOf(
                StringOption(1, "Discord"),
                StringOption(2, "Accord"),
                StringOption(3, "Agreement"),
            ),
            1
        ),
    ),
    AntonymQuestion(
        index = 7,
        word = "Generous",
        oa = OptionsAndAnswer(
            listOf(
                StringOption(1, "Selfish"),
                StringOption(2, "Benevolent"),
                StringOption(3, "Kind"),
            ),
            1
        ),
    ),
    AntonymQuestion(
        index = 8,
        word = "Optimistic",
        oa = OptionsAndAnswer(
            listOf(
                StringOption(1, "Hopeful"),
                StringOption(2, "Pessimistic"),
                StringOption(3, "Positive"),
            ),
            2
        ),
    ),
    AntonymQuestion(
        index = 9,
        word = "Courageous",
        oa = OptionsAndAnswer(
            listOf(
                StringOption(1, "Brave"),
                StringOption(2, "Fearful"),
                StringOption(3, "Bold"),
                StringOption(4, "Valiant"),
            ),
            2
        ),
    ),
)