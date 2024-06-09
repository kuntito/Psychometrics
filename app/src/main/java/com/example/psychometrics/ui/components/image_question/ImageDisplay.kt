package com.example.psychometrics.ui.components.image_question

import androidx.annotation.DrawableRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.psychometrics.R
import com.example.psychometrics.ui.components.util.PreviewColumn
import com.example.psychometrics.ui.theme.color300
import com.example.psychometrics.ui.theme.ts300

@Composable
fun ImageDisplay(
    modifier: Modifier = Modifier,
    borderColor: Color,
    isSelected: Boolean,
    @DrawableRes
    image: Int,
    onClick: () -> Unit,
) {
    val cornerRadius = 8

    val _borderColor by animateColorAsState(
        targetValue = if (isSelected) borderColor else Color.Transparent,
        label = ""
    )
    Box(
        modifier = modifier
            .border(
                width = 2.dp,
                color = _borderColor,
                shape = RoundedCornerShape(cornerRadius.dp)
            )
            .padding(8.dp)
            .clickable { onClick() },
    ) {
        val orientation = ImageOrientation.getOrientation(image, LocalContext.current.resources)
        Image(
            painter = painterResource(id = image),
            contentDescription = "image option",
            contentScale = getContentScale(orientation),
            modifier = getImageDimension(maxDim = 150, orientation = orientation)
                .clip(RoundedCornerShape((cornerRadius / 2).dp)),
        )
    }
}
@Preview
@Composable
fun ImageDisplayPreview() {
    var isSelected by remember{ mutableStateOf(false) }
    val color = color300
    PreviewColumn {
        ImageDisplay(
            borderColor = color,
            isSelected = isSelected,
            image = R.drawable.cf_samp_002_0,
        ){}
        ImageDisplay(
            borderColor = color,
            isSelected = isSelected,
            image = R.drawable.square_image,
        ){}
        ImageDisplay(
            borderColor = color,
            isSelected = isSelected,
            image = R.drawable.landscape_image,
        ){}
        Button(onClick = { isSelected = !isSelected }) {
            Text(
                text = "toggle",
                style = ts300
            )
        }
    }
}