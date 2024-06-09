package com.example.psychometrics.ui.components.options

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.psychometrics.ui.components.util.ClickableSurface
import com.example.psychometrics.ui.components.util.PreviewColumn
import com.example.psychometrics.ui.theme.color320
import com.example.psychometrics.ui.theme.color400
import com.example.psychometrics.ui.theme.ts300
import com.example.psychometrics.ui.theme.ts400

@Composable
fun OptionLabel(
    modifier: Modifier = Modifier,
    text: String,
    optionId: Int,
    selectedOptionId: Int,
    onClick: () -> Unit,
) {
    val labelHeight = 48
    val cornerSize = 12
    val buttonShape = RoundedCornerShape(cornerSize.dp)

    val textStyle = ts300
    var fontSize by remember{
        mutableStateOf(textStyle.fontSize)
    }

    val isSelected = selectedOptionId == optionId
    ClickableSurface(
        onClick = onClick,
        shape = buttonShape,
        bgColor = if(isSelected) color320 else color400,
        modifier = modifier
            .height(labelHeight.dp)
            .fillMaxWidth(),
    ){
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(horizontal = cornerSize.dp),
        ) {
            Text(
                text = text,
                style = textStyle,
                fontSize = fontSize,
                maxLines = 1,
                // if text overflows width, shrink `fontSize`.
                // not sure why `it.didOverflowHeight` works instead of `it.didOverflowWidth`
                onTextLayout = {
                    if(it.didOverflowHeight && fontSize.value >= ts400.fontSize.value ) {
                        fontSize *= .9F
                    }
                },
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}

@Preview
@Composable
fun OptionLabelPreview() {
    PreviewColumn {
        var currentOption by remember{ mutableIntStateOf(-1) }
        val optionId = 1
        OptionLabel(
            text = "comma",
            optionId = optionId,
            selectedOptionId = currentOption,
        ) {
            currentOption = optionId
        }
    }
}