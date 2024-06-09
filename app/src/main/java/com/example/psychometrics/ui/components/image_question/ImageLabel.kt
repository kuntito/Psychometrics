package com.example.psychometrics.ui.components.image_question

import androidx.compose.animation.animateColorAsState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.psychometrics.ui.theme.color320
import com.example.psychometrics.ui.theme.ts300

@Composable
fun ImageLabel(
    modifier: Modifier = Modifier,
    text: String,
    color: Color,
    isSelected: Boolean,
) {
    val _color by animateColorAsState(
        targetValue = if (isSelected) color else color320,
        label = ""
    )
    Text(
        text = text,
        style = ts300
            .copy(color = _color),
        modifier = modifier,
    )
}