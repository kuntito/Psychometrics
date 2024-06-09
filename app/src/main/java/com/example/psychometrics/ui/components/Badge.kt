package com.example.psychometrics.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.psychometrics.models.AnswerStatus
import com.example.psychometrics.ui.components.util.PreviewColumn
import com.example.psychometrics.ui.theme.h2_200


private val statusCorrect = AnswerStatus.Correct
private val statusWrong = AnswerStatus.Wrong

@Composable
fun Badge(
    modifier: Modifier = Modifier,
    tint: Color = Color.White,
    size: Int = 24,
    bgColor: Color,
    icon: ImageVector,
    contentDescription: String,
) {
    Surface(
        shape = CircleShape,
        color = bgColor,
        modifier = modifier
            .size(size.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            val iconSize = (0.9 * size).toInt()
            Icon(
                imageVector = icon,
                contentDescription = contentDescription,
                tint = tint,
                modifier = Modifier
                    .size(iconSize.dp)
            )
        }
    }
}

@Preview
@Composable
fun BadgePreview() {
    PreviewColumn {
        val size = 200
        Badge(
            bgColor = statusCorrect.bgColor,
            icon = statusCorrect.icon,
            contentDescription = statusCorrect.contentDescription,
            size = size,
        )
        Badge(
            bgColor = statusWrong.bgColor,
            icon = statusWrong.icon,
            contentDescription = statusCorrect.contentDescription,
            size = size,
        )
    }
}

@Composable
fun BadgeAndStatusMessage(
    modifier: Modifier = Modifier,
    status: AnswerStatus,
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Badge(
            bgColor = status.bgColor,
            icon = status.icon,
            contentDescription = status.contentDescription,
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = status.message,
            style = h2_200,
        )
    }
}



@Preview
@Composable
fun BadgeAndStatusMessagePreview() {
    PreviewColumn {
        BadgeAndStatusMessage(status = statusCorrect)
        BadgeAndStatusMessage(status = statusWrong)
    }
}