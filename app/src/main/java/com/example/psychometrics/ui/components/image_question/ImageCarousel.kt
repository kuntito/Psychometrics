package com.example.psychometrics.ui.components.image_question

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.psychometrics.R
import com.example.psychometrics.models.option.ImageOption
import com.example.psychometrics.models.option.Option
import com.example.psychometrics.ui.components.util.PreviewColumn

@Composable
fun ImageCarousel(
    modifier: Modifier = Modifier,
    imageOptions: List<Option<Int>>,
    onOptionClick: (Int) -> Unit,
    selectedOptionId: Int,
) {
   LazyRow(
       horizontalArrangement = Arrangement.SpaceAround,
       modifier = modifier
           .padding(horizontal = 8.dp)
           .fillMaxWidth(),
   ) {
       item {
           Spacer(modifier = Modifier.fillMaxWidth())
       }
       itemsIndexed(imageOptions) {index, option ->
           ImageOptionLabel(
               optionId = option.id,
               selectedOptionId = selectedOptionId,
               image = option.value,
           ) { onOptionClick(option.id) }
           if (index < imageOptions.lastIndex) {
               Spacer(modifier = Modifier.width(8.dp))
           }
       }
       item {
           Spacer(modifier = Modifier.fillMaxWidth())
       }
   }
}

@Preview
@Composable
fun ImageCarouselPreview() {
    PreviewColumn {
        var selectedOptionId by remember{ mutableIntStateOf(-1) }
        val optionsSquare = listOf(
            ImageOption(0, R.drawable.square_image),
            ImageOption(1, R.drawable.square_image),
            ImageOption(2, R.drawable.square_image),
        )
        ImageCarousel(
            imageOptions = optionsSquare,
            onOptionClick = {
                selectedOptionId = it
            },
            selectedOptionId = selectedOptionId
        )

        val optionsLandscape = listOf(
            ImageOption(0, R.drawable.landscape_image),
            ImageOption(1, R.drawable.landscape_image),
            ImageOption(2, R.drawable.landscape_image),
        )
        ImageCarousel(
            imageOptions = optionsLandscape,
            onOptionClick = {
                selectedOptionId = it
            },
            selectedOptionId = selectedOptionId
        )

        val optionsPotrait = listOf(
            ImageOption(0, R.drawable.cf_samp_002_0),
            ImageOption(1, R.drawable.cf_samp_002_0),
            ImageOption(2, R.drawable.cf_samp_002_0),
        )
        ImageCarousel(
            imageOptions = optionsPotrait,
            onOptionClick = {
                selectedOptionId = it
            },
            selectedOptionId = selectedOptionId
        )
    }
}