package com.example.psychometrics.ui.components.image_question

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.psychometrics.R
import com.example.psychometrics.ui.components.util.PreviewColumn

@Composable
fun ImageQuestionDisplay(
    modifier: Modifier = Modifier,
    maxDim: Int,
    imageId: Int,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.BottomCenter,
    ) {
        val orientation = ImageOrientation.getOrientation(imageId, LocalContext.current.resources)
        Log.d("vibes", orientation.name)
        Image(
            painter = painterResource(id = imageId),
            contentDescription = "image option",
            contentScale = getContentScale(orientation),
            modifier = getImageDimension(maxDim = maxDim, orientation = orientation)
                .then(modifier),
        )
    }
}

@Preview
@Composable
fun ImageQuestionDisplayPreview() {
    PreviewColumn {
        ImageQuestionDisplay(
            maxDim = 320,
            imageId = R.drawable.cf_samp_001,
            modifier = Modifier.border(width = 2.dp, color = Color.Yellow)
        )
    }
}