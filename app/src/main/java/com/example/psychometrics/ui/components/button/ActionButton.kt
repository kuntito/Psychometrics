package com.example.psychometrics.ui.components.button

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.psychometrics.ui.theme.color320
import com.example.psychometrics.ui.theme.ts400
import com.example.psychometrics.ui.components.util.ClickableSurface
import com.example.psychometrics.ui.components.util.PreviewColumn

@Composable
fun ActiveActionButton(
    modifier: Modifier = Modifier,
    bgColor: Color = color320,
    textStyle: TextStyle = ts400,
    text: String,
    onClick: () -> Unit,
) {
    BaseActionButton(
        text = text,
        bgColor = bgColor,
        textColor =  ts400.color,
        borderColor = bgColor,
        isClickable = true,
        onClick = onClick,
        modifier = modifier,
        textStyle = textStyle,
    )
}

@Composable
fun InactiveActionButton(
    modifier: Modifier = Modifier,
) {
    val alpha = 0.7f
    val color = color320.copy(alpha)
    BaseActionButton(
        text = "Check",
        alpha = alpha,
        bgColor = Color.Transparent,
        textColor = color,
        isClickable = false,
        borderColor = color,
        borderWidth = 2.dp,
        modifier = modifier,
    ) {}
}

@Composable
fun BaseActionButton(
    modifier: Modifier = Modifier,
    text: String,
    bgColor: Color,
    alpha: Float = 1f,
    textColor: Color,
    borderColor: Color,
    borderWidth: Dp = 0.dp,
    textStyle: TextStyle = ts400,
    isClickable: Boolean,
    onClick: () -> Unit,
) {
    val buttonHeight = 48
    val cornerSize = (buttonHeight/3).toInt()
    val shape = RoundedCornerShape(cornerSize.dp)
    ClickableSurface(
        onClick = onClick,
        shape = shape,
        bgColor = bgColor,
        isClickable = isClickable,
        modifier = modifier
            .fillMaxWidth()
            .height(buttonHeight.dp)
            .border(borderWidth, borderColor, shape)
            .alpha(alpha)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier,
        ) {
            Text(
                text = text,
                style = textStyle.copy(
                    color = textColor,
                )
            )
        }
    }
}

@Preview
@Composable
fun ActionButtonPreview() {
    PreviewColumn {
        ActiveActionButton(text = "vibes") {}
        InactiveActionButton()
    }
}