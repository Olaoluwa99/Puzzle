package com.easit.puzzle.data

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.LinearGradient
import android.graphics.Paint
import android.graphics.Shader
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb

class ImageData {

    fun setBackground(width: Int, height: Int, startColor: Color, endColor: Color) : Bitmap {
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)

        val gradient = LinearGradient(
            0f, 0f, width.toFloat(), height.toFloat(),
            intArrayOf(startColor.toArgb(), endColor.toArgb()), null, Shader.TileMode.CLAMP
        )

        val paint = Paint().apply {
            this.shader = gradient
        }

        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), paint)
        return bitmap
    }
}