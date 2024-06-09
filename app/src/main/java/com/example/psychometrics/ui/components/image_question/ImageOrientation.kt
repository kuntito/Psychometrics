package com.example.psychometrics.ui.components.image_question

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp

enum class ImageOrientation {
    Landscape,
    Portrait,
    Square;

    companion object {
        @JvmStatic
        fun getOrientation(@DrawableRes imageId: Int, res: Resources): ImageOrientation {
            val imageBitmap = BitmapFactory.Options().let {
                it.inPreferredConfig = Bitmap.Config.ARGB_8888
                BitmapFactory.decodeResource(
                    res,
                    imageId,
                    it
                )
            }

            val width = imageBitmap.width
            val height = imageBitmap.height
            val tolerance = 10
            return if (kotlin.math.abs(width - height) <= tolerance) {
                Square
            } else if (width > height) {
                Landscape
            } else {
                Portrait
            }
        }

        private fun firstDigit(number: Int): Int {
            return number.toString().first().toString().toInt()
        }
    }
}

fun getImageDimension(maxDim: Int, orientation: ImageOrientation): Modifier {
    return when (orientation) {
        ImageOrientation.Square -> {
            Modifier
                .width(maxDim.dp)
                .height(maxDim.dp)
        }
        ImageOrientation.Portrait -> {
            Modifier
                .height(maxDim.dp)
        }
        ImageOrientation.Landscape -> {
            Modifier
                .width(maxDim.dp)
        }
    }
}

fun getContentScale(orientation: ImageOrientation): ContentScale {
    return when (orientation) {
        ImageOrientation.Square -> {
            ContentScale.FillBounds
        }
        ImageOrientation.Portrait -> {
            ContentScale.FillHeight
        }
        ImageOrientation.Landscape -> {
            ContentScale.FillWidth
        }
    }
}