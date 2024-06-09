package com.example.psychometrics.ui.components.image_question

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.psychometrics.R
import com.example.psychometrics.models.option.ImageOption
import com.example.psychometrics.ui.components.util.PreviewColumn
import com.example.psychometrics.ui.theme.color300
import com.example.psychometrics.ui.theme.ts300

@Composable
fun ImageOptionLabel(
    modifier: Modifier = Modifier,
    optionId: Int,
    selectedOptionId: Int,
    image: Int,
    onClick: () -> Unit,
) {
    val color = color300
    val isSelected = selectedOptionId == optionId
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier,
    ) {
        ImageDisplay(
            borderColor = color,
            isSelected = isSelected,
            image = image
        ) { onClick() }
        Spacer(modifier = Modifier.height(8.dp))
        ImageLabel(
            color = color,
            isSelected = isSelected,
            text = "$optionId"
        )
    }
}


@Preview
@Composable
fun ImageOptionPreview() {
    PreviewColumn {
        val option = ImageOption(
            id = 1,
            value = R.drawable.cf_samp_002_0
        )
        var selectedOptionId by remember{ mutableIntStateOf(option.id) }
        ImageOptionLabel(
            optionId = option.id,
            selectedOptionId = selectedOptionId,
            image = option.value
        ) {
            selectedOptionId = -selectedOptionId
        }
        Button(onClick = { selectedOptionId = -selectedOptionId }) {
            Text(
                text = "toggle",
                style = ts300
            )
        }
    }
}