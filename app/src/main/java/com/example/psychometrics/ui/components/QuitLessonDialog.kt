package com.example.psychometrics.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.psychometrics.ui.theme.colorError
import com.example.psychometrics.ui.theme.h2_200
import com.example.psychometrics.ui.theme.ts300
import com.example.psychometrics.ui.components.util.ClickableSurface
import com.example.psychometrics.ui.components.util.PreviewColumn


@Composable
fun QuitLessonDialog(
    modifier: Modifier = Modifier,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit,
    isVisible: Boolean,
) {
    if (isVisible) {
        AlertDialog(
            modifier = modifier,
            onDismissRequest = onDismiss,
            title = {
                Text(
                    text = "Quit lesson?",
                    style = h2_200,
                )
            },
            text = {
                Text(
                    text = "all progress will be lost",
                    style = ts300.copy(
                        color = colorError,
                    )
                )
            },
            confirmButton = {
                LessonEndDialogButton(
                    text = "yes",
                    onClick = {
                        onDismiss()
                        onConfirm()
                    },
                )
            },
            dismissButton = {
                LessonEndDialogButton(
                    text = "no",
                    onClick = onDismiss,
                )
            }
        )
    }
}

@Preview
@Composable
fun QuitLessonDialogPreview() {
    PreviewColumn {
        var openDialog by remember { mutableStateOf(true) }

        QuitLessonDialog(
            onConfirm = {},
            onDismiss = {
                openDialog = false
            },
            isVisible = openDialog,
        )
    }
}

@Composable
fun LessonEndDialogButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
) {
    val textStyle = ts300
    ClickableSurface(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
    ) {
        Text(
            text = text,
            style = textStyle,
            modifier = Modifier.padding(
                horizontal = 16.dp,
                vertical = 4.dp,
            )
        )
    }
}