package com.example.psychometrics.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.psychometrics.ui.components.util.PreviewColumn
import com.example.psychometrics.ui.theme.color300
import com.example.psychometrics.ui.theme.color400
import com.example.psychometrics.ui.theme.ts200

@Composable
fun LessonProgressBar(
    modifier: Modifier = Modifier,
    progress: Float,
) {
    val animatedProgress = animateFloatAsState(
        targetValue = progress,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec, label = ""
    ).value

    LinearProgressIndicator(
        modifier = modifier
            .height(10.dp)
            .fillMaxWidth(),
        color = color300,
        trackColor = color400,
        strokeCap = StrokeCap.Round,
        progress = animatedProgress,
    )
}

@Preview
@Composable
fun LessonProgressBarPreview() {
    PreviewColumn {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            var progress by remember{ mutableFloatStateOf(0.3f) }

            LessonProgressBar(
                progress = progress
            )

            Button(onClick = {
                progress += 0.1f
            }) {
                Text(
                    text = "increase",
                    style = ts200
                )
            }
        }
    }
}
