package com.easit.puzzle.model

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import kotlin.random.Random

fun createSeed(): Int{
    return (100000..999999).random()
}
fun splitPuzzle(imagePartsRoot: Int, bitmap: Bitmap): List<Bitmap> {
    val imageWidth = bitmap.width
    val imageHeight = bitmap.height

    val tileWidth = imageWidth / 4
    val tileHeight = imageHeight / 4
    val tiles = mutableListOf<Bitmap>()

    // Split image into 16 parts
    for (y in 0 until imagePartsRoot) {
        for (x in 0 until imagePartsRoot) {
            val croppedBitmap = Bitmap.createBitmap(
                bitmap,
                x * tileWidth, y * tileHeight,
                tileWidth, tileHeight
            )
            tiles.add(croppedBitmap)
        }
    }

    return tiles
}

fun shuffleBitmap(tiles: List<Bitmap>, userSeed: Int): List<Bitmap> {
    val random = Random(userSeed)//Random
    val tilesCopy = tiles.toMutableList()
    return tilesCopy.shuffled(random)
}

fun retrieveStartImageList (): List<Bitmap>{
    val image = createBitmapWithWhiteBackground(200, 200)
    return listOf(
        image, image, image, image,
        image, image, image, image,
        image, image, image, image,
        image, image, image, image
    )
}

fun createBitmapWithWhiteBackground(width: Int, height: Int): Bitmap {
    val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(bitmap)
    canvas.drawColor(Color.WHITE)
    return bitmap
}
