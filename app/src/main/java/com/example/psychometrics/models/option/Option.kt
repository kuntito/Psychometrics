package com.example.psychometrics.models.option

import androidx.annotation.DrawableRes

abstract class Option<T>(
    open val id: Int,
    open val value: T
)

data class StringOption(
    override val id: Int,
    override val value: String,
): Option<String>(id, value)


data class ImageOption(
    override val id: Int,
    @DrawableRes
    override val value: Int
): Option<Int>(id, value)