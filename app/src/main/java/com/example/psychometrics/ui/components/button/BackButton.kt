package com.example.psychometrics.ui.components.button

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.psychometrics.R
import com.example.psychometrics.ui.components.util.PreviewColumn
import com.example.psychometrics.ui.theme.color300

@Composable
fun BackButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    IconButton(
        onClick = { onClick() },
        modifier = modifier,
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_back_button),
            contentDescription = "back button",
            tint = color300,
        )
    }
}


@Preview
@Composable
fun BackButtonPreview() {
    PreviewColumn {
        BackButton{}
    }
}