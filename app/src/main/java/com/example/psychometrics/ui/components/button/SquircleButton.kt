package com.example.psychometrics.ui.components.button

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.psychometrics.ui.components.util.ClickableSurface
import com.example.psychometrics.ui.components.util.PreviewColumn
import com.example.psychometrics.ui.theme.h2_300

@Composable
fun SquircleButton(
    modifier: Modifier = Modifier,
    buttonSize: Int = 100,
    text: String,
    onClick: () -> Unit,
) {
    val cornerRadius = (0.2 * buttonSize).toInt()
    val shape = RoundedCornerShape(cornerRadius.dp)
    ClickableSurface(
        onClick = { onClick() },
        shape = shape,
        modifier = modifier
            .size(buttonSize.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = text,
                maxLines = 2,
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis,
                style = h2_300,
            )
        }
    }
}

@Preview
@Composable
fun SquircleButtonPreview() {
    PreviewColumn {
        SquircleButton(text = "start\nlesson") {

        }
    }
}