package com.example.psychometrics.ui.components.options

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.psychometrics.models.option.Option
import com.example.psychometrics.models.option.StringOption
import com.example.psychometrics.ui.components.util.PreviewColumn

@Composable
fun <T>OptionsList(
    modifier: Modifier = Modifier,
    options: List<Option<T>>,
    selectedOptionId: Int,
    onOptionClick: (Int) -> Unit,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        options.forEach {option ->
            OptionLabel(
                selectedOptionId = selectedOptionId,
                optionId = option.id,
                text = option.value as String,
            ) {
                onOptionClick(option.id)
            }
        }
    }
}

@Preview
@Composable
fun OptionListPreview() {
    PreviewColumn {
        var selectedOptionId by remember{ mutableIntStateOf(0) }
        val options = listOf(
            StringOption(1, "mahrez"),
            StringOption(2, "tunde ednut"),
            StringOption(3, "misra"),
        )
        OptionsList(
            options = options,
            selectedOptionId = selectedOptionId,
        ) {
            selectedOptionId = it
        }
    }
}