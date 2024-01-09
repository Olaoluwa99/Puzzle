package com.easit.puzzle.ui.main.puzzle1

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.easit.puzzle.constants.Constants
import com.easit.puzzle.data.ImageData
import com.easit.puzzle.ui.theme.PuzzleTheme

@SuppressLint("MutableCollectionMutableState")
@Composable
fun JigsawScreen() {

    val image = ImageData()
    val response = image.setBackground(200, 200, Color.Red, Color.Blue)
    val width = 50
    val height = 50
    val smallBoxPadding = 1
    val spacingValue = 0

    var selectedList by remember {
        mutableStateOf(listOf(
            true, false, false, false,
            false, false, false, false,
            false, false, false, false,
            false, false, false, false,
        ))
    }
    var bottomList by remember {
        mutableStateOf(listOf(
            true, false, false, false,
            false, false, false, false,
            false, false, false, false,
            false, false, false, false,
        ))
    }

    /*var isImage1Selected by remember { mutableStateOf(true) }
    var isImage2Selected by remember { mutableStateOf(false) }
    var isImage3Selected by remember { mutableStateOf(false) }
    var isImage4Selected by remember { mutableStateOf(false) }
    var isImage5Selected by remember { mutableStateOf(false) }
    var isImage6Selected by remember { mutableStateOf(false) }
    var isImage7Selected by remember { mutableStateOf(false) }
    var isImage8Selected by remember { mutableStateOf(false) }
    var isImage9Selected by remember { mutableStateOf(false) }
    var isImage10Selected by remember { mutableStateOf(false) }
    var isImage11Selected by remember { mutableStateOf(false) }
    var isImage12Selected by remember { mutableStateOf(false) }
    var isImage13Selected by remember { mutableStateOf(false) }
    var isImage14Selected by remember { mutableStateOf(false) }
    var isImage15Selected by remember { mutableStateOf(false) }
    var isImage16Selected by remember { mutableStateOf(false) }

    var image1Background by remember { mutableStateOf(Constants.clickedBackground) }
    var image2Background by remember { mutableStateOf(Constants.clickedBackground) }
    var image3Background by remember { mutableStateOf(Constants.clickedBackground) }
    var image4Background by remember { mutableStateOf(Constants.clickedBackground) }
    var image5Background by remember { mutableStateOf(Constants.clickedBackground) }
    var image6Background by remember { mutableStateOf(Constants.clickedBackground) }
    var image7Background by remember { mutableStateOf(Constants.clickedBackground) }
    var image8Background by remember { mutableStateOf(Constants.clickedBackground) }
    var image9Background by remember { mutableStateOf(Constants.clickedBackground) }
    var image10Background by remember { mutableStateOf(Constants.clickedBackground) }
    var image11Background by remember { mutableStateOf(Constants.clickedBackground) }
    var image12Background by remember { mutableStateOf(Constants.clickedBackground) }
    var image13Background by remember { mutableStateOf(Constants.clickedBackground) }
    var image14Background by remember { mutableStateOf(Constants.clickedBackground) }
    var image15Background by remember { mutableStateOf(Constants.clickedBackground) }
    var image16Background by remember { mutableStateOf(Constants.clickedBackground) }

    if (isImage1Selected){
        //resetBackground()
        image1Background = Constants.clickedBackground
    }else*/
    //
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ){
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .border(
                        width = 1.dp,
                        brush = Brush.horizontalGradient(listOf(Color.Black, Color.Black)),
                        shape = RoundedCornerShape(10.dp)
                    )
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.LightGray)
                    .padding(8.dp)
            ){
                Column(
                    modifier = Modifier
                        .wrapContentWidth(),
                    verticalArrangement = Arrangement.spacedBy(spacingValue.dp)
                ) {
                    //
                    Row(modifier = Modifier
                        .wrapContentWidth(),
                        horizontalArrangement = Arrangement.spacedBy(spacingValue.dp)
                    ) {
                        //
                        Box(
                            modifier = Modifier
                                .background(getBackground(selectedList, 0))
                                .padding(smallBoxPadding.dp)
                        ){
                            //
                            Image(
                                bitmap = response.asImageBitmap(),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(width.dp)
                                    .height(height.dp)
                                    .clickable { selectedList = setAsActive(0) }
                            )
                        }

                        //
                        Box(
                            modifier = Modifier
                                .background(getBackground(selectedList, 1))
                                .padding(smallBoxPadding.dp)
                        ){
                            //
                            Image(
                                bitmap = response.asImageBitmap(),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(width.dp)
                                    .height(height.dp)
                                    .clickable { selectedList = setAsActive(1) }
                            )
                        }

                        //
                        Box(
                            modifier = Modifier
                                .background(getBackground(selectedList, 2))
                                .padding(smallBoxPadding.dp)
                        ){
                            //
                            Image(
                                bitmap = response.asImageBitmap(),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(width.dp)
                                    .height(height.dp)
                                    .clickable { selectedList = setAsActive(2) }
                            )
                        }

                        //
                        Box(
                            modifier = Modifier
                                .background(getBackground(selectedList, 3))
                                .padding(smallBoxPadding.dp)
                        ){
                            //
                            Image(
                                bitmap = response.asImageBitmap(),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(width.dp)
                                    .height(height.dp)
                                    .clickable { selectedList = setAsActive(3) }
                            )
                        }
                    }

                    //
                    Row(modifier = Modifier
                        .wrapContentWidth(),
                        horizontalArrangement = Arrangement.spacedBy(spacingValue.dp)
                    ) {
                        //
                        Box(
                            modifier = Modifier
                                .background(getBackground(selectedList, 4))
                                .padding(smallBoxPadding.dp)
                        ){
                            //
                            Image(
                                bitmap = response.asImageBitmap(),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(width.dp)
                                    .height(height.dp)
                                    .clickable { selectedList = setAsActive(4) }
                            )
                        }

                        //
                        Box(
                            modifier = Modifier
                                .background(getBackground(selectedList, 5))
                                .padding(smallBoxPadding.dp)
                        ){
                            //
                            Image(
                                bitmap = response.asImageBitmap(),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(width.dp)
                                    .height(height.dp)
                                    .clickable { selectedList = setAsActive(5) }
                            )
                        }

                        //
                        Box(
                            modifier = Modifier
                                .background(getBackground(selectedList, 6))
                                .padding(smallBoxPadding.dp)
                        ){
                            //
                            Image(
                                bitmap = response.asImageBitmap(),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(width.dp)
                                    .height(height.dp)
                                    .clickable { selectedList = setAsActive(6) }
                            )
                        }

                        //
                        Box(
                            modifier = Modifier
                                .background(getBackground(selectedList, 7))
                                .padding(smallBoxPadding.dp)
                        ){
                            //
                            Image(
                                bitmap = response.asImageBitmap(),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(width.dp)
                                    .height(height.dp)
                                    .clickable { selectedList = setAsActive(7) }
                            )
                        }
                    }

                    //
                    Row(modifier = Modifier
                        .wrapContentWidth(),
                        horizontalArrangement = Arrangement.spacedBy(spacingValue.dp)
                    ) {
                        //
                        Box(
                            modifier = Modifier
                                .background(getBackground(selectedList, 8))
                                .padding(smallBoxPadding.dp)
                        ){
                            //
                            Image(
                                bitmap = response.asImageBitmap(),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(width.dp)
                                    .height(height.dp)
                                    .clickable { selectedList = setAsActive(8) }
                            )
                        }

                        //
                        Box(
                            modifier = Modifier
                                .background(getBackground(selectedList, 9))
                                .padding(smallBoxPadding.dp)
                        ){
                            //
                            Image(
                                bitmap = response.asImageBitmap(),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(width.dp)
                                    .height(height.dp)
                                    .clickable { selectedList = setAsActive(9) }
                            )
                        }

                        //
                        Box(
                            modifier = Modifier
                                .background(getBackground(selectedList, 10))
                                .padding(smallBoxPadding.dp)
                        ){
                            //
                            Image(
                                bitmap = response.asImageBitmap(),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(width.dp)
                                    .height(height.dp)
                                    .clickable { selectedList = setAsActive(10) }
                            )
                        }

                        //
                        Box(
                            modifier = Modifier
                                .background(getBackground(selectedList, 11))
                                .padding(smallBoxPadding.dp)
                        ){
                            //
                            Image(
                                bitmap = response.asImageBitmap(),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(width.dp)
                                    .height(height.dp)
                                    .clickable { selectedList = setAsActive(11) }
                            )
                        }
                    }

                    //
                    Row(modifier = Modifier
                        .wrapContentWidth(),
                        horizontalArrangement = Arrangement.spacedBy(spacingValue.dp)
                    ) {
                        //
                        Box(
                            modifier = Modifier
                                .background(getBackground(selectedList, 12))
                                .padding(smallBoxPadding.dp)
                                .clickable { selectedList = setAsActive(12) }
                        ){
                            //
                            Image(
                                bitmap = response.asImageBitmap(),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(width.dp)
                                    .height(height.dp)
                            )
                        }

                        //
                        Box(
                            modifier = Modifier
                                .background(getBackground(selectedList, 13))
                                .padding(smallBoxPadding.dp)
                        ){
                            //
                            Image(
                                bitmap = response.asImageBitmap(),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(width.dp)
                                    .height(height.dp)
                                    .clickable { selectedList = setAsActive(13) }
                            )
                        }

                        //
                        Box(
                            modifier = Modifier
                                .background(getBackground(selectedList, 14))
                                .padding(smallBoxPadding.dp)
                        ){
                            //
                            Image(
                                bitmap = response.asImageBitmap(),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(width.dp)
                                    .height(height.dp)
                                    .clickable { selectedList = setAsActive(14) }
                            )
                        }

                        //
                        Box(
                            modifier = Modifier
                                .background(getBackground(selectedList, 15))
                                .padding(smallBoxPadding.dp)
                        ){
                            //
                            Image(
                                bitmap = response.asImageBitmap(),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(width.dp)
                                    .height(height.dp)
                                    .clickable { selectedList = setAsActive(15) }
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(36.dp))

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ){
                item {
                    Box(
                        modifier = Modifier
                            .background(getBackground(bottomList, 0))
                            .padding(smallBoxPadding.dp)
                    ){
                        //
                        Image(
                            bitmap = response.asImageBitmap(),
                            contentDescription = null,
                            modifier = Modifier
                                .width(width.dp)
                                .height(height.dp)
                                .clickable { bottomList = setAsActive(0) }
                        )
                    }
                }

                item {
                    Box(
                        modifier = Modifier
                            .background(getBackground(bottomList, 1))
                            .padding(smallBoxPadding.dp)
                    ){
                        //
                        Image(
                            bitmap = response.asImageBitmap(),
                            contentDescription = null,
                            modifier = Modifier
                                .width(width.dp)
                                .height(height.dp)
                                .clickable { bottomList = setAsActive(1) }
                        )
                    }
                }

                item {
                    Box(
                        modifier = Modifier
                            .background(getBackground(bottomList, 2))
                            .padding(smallBoxPadding.dp)
                    ){
                        //
                        Image(
                            bitmap = response.asImageBitmap(),
                            contentDescription = null,
                            modifier = Modifier
                                .width(width.dp)
                                .height(height.dp)
                                .clickable { bottomList = setAsActive(2) }
                        )
                    }
                }

                item {
                    Box(
                        modifier = Modifier
                            .background(getBackground(bottomList, 3))
                            .padding(smallBoxPadding.dp)
                    ){
                        //
                        Image(
                            bitmap = response.asImageBitmap(),
                            contentDescription = null,
                            modifier = Modifier
                                .width(width.dp)
                                .height(height.dp)
                                .clickable { bottomList = setAsActive(3) }
                        )
                    }
                }

                item {
                    Box(
                        modifier = Modifier
                            .background(getBackground(bottomList, 4))
                            .padding(smallBoxPadding.dp)
                    ){
                        //
                        Image(
                            bitmap = response.asImageBitmap(),
                            contentDescription = null,
                            modifier = Modifier
                                .width(width.dp)
                                .height(height.dp)
                                .clickable { bottomList = setAsActive(4) }
                        )
                    }
                }

                item {
                    Box(
                        modifier = Modifier
                            .background(getBackground(bottomList, 5))
                            .padding(smallBoxPadding.dp)
                    ){
                        //
                        Image(
                            bitmap = response.asImageBitmap(),
                            contentDescription = null,
                            modifier = Modifier
                                .width(width.dp)
                                .height(height.dp)
                                .clickable { bottomList = setAsActive(5) }
                        )
                    }
                }

                item {
                    Box(
                        modifier = Modifier
                            .background(getBackground(bottomList, 6))
                            .padding(smallBoxPadding.dp)
                    ){
                        //
                        Image(
                            bitmap = response.asImageBitmap(),
                            contentDescription = null,
                            modifier = Modifier
                                .width(width.dp)
                                .height(height.dp)
                                .clickable { bottomList = setAsActive(6) }
                        )
                    }
                }

                item {
                    Box(
                        modifier = Modifier
                            .background(getBackground(bottomList, 7))
                            .padding(smallBoxPadding.dp)
                    ){
                        //
                        Image(
                            bitmap = response.asImageBitmap(),
                            contentDescription = null,
                            modifier = Modifier
                                .width(width.dp)
                                .height(height.dp)
                                .clickable { bottomList = setAsActive(7) }
                        )
                    }
                }

                item {
                    Box(
                        modifier = Modifier
                            .background(getBackground(bottomList, 8))
                            .padding(smallBoxPadding.dp)
                    ){
                        //
                        Image(
                            bitmap = response.asImageBitmap(),
                            contentDescription = null,
                            modifier = Modifier
                                .width(width.dp)
                                .height(height.dp)
                                .clickable { bottomList = setAsActive(8) }
                        )
                    }
                }

                item {
                    Box(
                        modifier = Modifier
                            .background(getBackground(bottomList, 9))
                            .padding(smallBoxPadding.dp)
                    ){
                        //
                        Image(
                            bitmap = response.asImageBitmap(),
                            contentDescription = null,
                            modifier = Modifier
                                .width(width.dp)
                                .height(height.dp)
                                .clickable { bottomList = setAsActive(9) }
                        )
                    }
                }

                item {
                    Box(
                        modifier = Modifier
                            .background(getBackground(bottomList, 10))
                            .padding(smallBoxPadding.dp)
                    ){
                        //
                        Image(
                            bitmap = response.asImageBitmap(),
                            contentDescription = null,
                            modifier = Modifier
                                .width(width.dp)
                                .height(height.dp)
                                .clickable { bottomList = setAsActive(10) }
                        )
                    }
                }

                item {
                    Box(
                        modifier = Modifier
                            .background(getBackground(bottomList, 11))
                            .padding(smallBoxPadding.dp)
                    ){
                        //
                        Image(
                            bitmap = response.asImageBitmap(),
                            contentDescription = null,
                            modifier = Modifier
                                .width(width.dp)
                                .height(height.dp)
                                .clickable { bottomList = setAsActive(11) }
                        )
                    }
                }

                item {
                    Box(
                        modifier = Modifier
                            .background(getBackground(bottomList, 12))
                            .padding(smallBoxPadding.dp)
                    ){
                        //
                        Image(
                            bitmap = response.asImageBitmap(),
                            contentDescription = null,
                            modifier = Modifier
                                .width(width.dp)
                                .height(height.dp)
                                .clickable { bottomList = setAsActive(12) }
                        )
                    }
                }

                item {
                    Box(
                        modifier = Modifier
                            .background(getBackground(bottomList, 13))
                            .padding(smallBoxPadding.dp)
                    ){
                        //
                        Image(
                            bitmap = response.asImageBitmap(),
                            contentDescription = null,
                            modifier = Modifier
                                .width(width.dp)
                                .height(height.dp)
                                .clickable { bottomList = setAsActive(13) }
                        )
                    }
                }

                item {
                    Box(
                        modifier = Modifier
                            .background(getBackground(bottomList, 14))
                            .padding(smallBoxPadding.dp)
                    ){
                        //
                        Image(
                            bitmap = response.asImageBitmap(),
                            contentDescription = null,
                            modifier = Modifier
                                .width(width.dp)
                                .height(height.dp)
                                .clickable { bottomList = setAsActive(14) }
                        )
                    }
                }

                item {
                    Box(
                        modifier = Modifier
                            .background(getBackground(bottomList, 15))
                            .padding(smallBoxPadding.dp)
                    ){
                        //
                        Image(
                            bitmap = response.asImageBitmap(),
                            contentDescription = null,
                            modifier = Modifier
                                .width(width.dp)
                                .height(height.dp)
                                .clickable { bottomList = setAsActive(15) }
                        )
                    }
                }
            }
        }
    }
}

fun getBackground(selectedGraph: List<Boolean>, index: Int) : Color {
    if (selectedGraph[index]){
        return Constants.clickedBackground
    }
    return Constants.unClickedBackground
}

fun setAsActive(index: Int) : List<Boolean>{
    val list = mutableListOf(
        false, false, false, false,
        false, false, false, false,
        false, false, false, false,
        false, false, false, false,
    )
    list[index] = true
    return list
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PuzzleTheme {
        JigsawScreen()
    }
}