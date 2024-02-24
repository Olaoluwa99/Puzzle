package com.easit.puzzle.ui.main.puzzle1

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.math.round

class JigsawViewModel: ViewModel() {

    private val _score = MutableStateFlow(0.toDouble())
    var score = _score.asStateFlow()

    private val _calculation = MutableStateFlow("")
    var calculation = _calculation.asStateFlow()

    fun checkScore (myList: List<Bitmap>, correctList: List<Bitmap>){
        var total = 0
        var score = 0
        myList.forEachIndexed { index, _ ->
            total += 1
            if (myList[index] == correctList[index]){
                score += 1
            }
        }
        val percentage = (score.toDouble()/ total) * 100
        _calculation.value = "${score.toDouble()} / $total x 100 = $percentage"
        _score.value = round(percentage * 100) / 100
    }
}