package com.easit.puzzle

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.ColorMatrix
import android.graphics.LinearGradient
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.Shader
import android.graphics.Typeface
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.easit.puzzle.model.ImageEncoder

fun fullImageProcess(
    text: String,
    width: Int,
    height: Int,
    startColor: Color,
    endColor: Color,
    textColor: Color,
    textSize: Float,
    typeface: Typeface? = null,
    shuffleSeed: Long
): Bitmap{
    val response = setBackground(width, height, startColor, endColor)
    val encoder = ImageEncoder()
    val design = encoder.reassembleImage(encoder.shuffleBitmap(encoder.splitImageToParts(4, response), shuffleSeed))
    return setTextOnBackground(design, text, width, height, textColor, textSize, typeface)
}

fun setTextOnBackground(
    background: Bitmap,
    text: String,
    width: Int,
    height: Int,
    textColor: Color,
    textSize: Float,
    typeface: Typeface? = null
) : Bitmap {
    val bitmap = Bitmap.createBitmap(background, 0, 0, width, height)
    val canvas = Canvas(bitmap)
    val paint = Paint().apply {
        this.color = textColor.toArgb()
        this.textSize = textSize
        this.typeface = typeface ?: Typeface.DEFAULT
    }

    val bounds = Rect()
    paint.getTextBounds(text, 0, text.length, bounds)

    val x = (width - bounds.width()) / 2
    val y = (height + bounds.height()) / 2

    canvas.drawText(text, x.toFloat(), y.toFloat(), paint)

    return bitmap
}

fun setBackground(width: Int, height: Int, startColor: Color, endColor: Color) : Bitmap{
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