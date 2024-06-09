package com.example.psychometrics.ui.components.util

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.psychometrics.ui.theme.color100
import com.example.psychometrics.ui.theme.color400
import kotlinx.coroutines.delay

@Composable
fun ClickableSurface(
    modifier: Modifier = Modifier,
    shape: RoundedCornerShape = RoundedCornerShape(0.dp),
    bgColor: Color = color400,
    rippleColor: Color = color100,
    isClickable: Boolean = true,
    onClick: () -> Unit,
    content: @Composable () -> Unit,
) {
    var isSurfaceClicked by remember { mutableStateOf(false) }
    LaunchedEffect(isSurfaceClicked) {
        delay(150)
        isSurfaceClicked = false
    }

    Surface(
        shape = shape,
        color = bgColor,
        content = content,
        modifier = modifier
            .alpha(if (isSurfaceClicked) 0.7f else 1f)
            .clickable(
                enabled = isClickable,
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(
                    color = rippleColor
                ) // Change the ripple color here
            ) {
                isSurfaceClicked = true
                onClick()
            },
    )
}