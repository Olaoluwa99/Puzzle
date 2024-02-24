package com.easit.puzzle.ui.main.puzzle1

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.graphics.Typeface
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.easit.puzzle.constants.Constants
import com.easit.puzzle.data.ImageData
import com.easit.puzzle.fullImageProcess
import com.easit.puzzle.model.createBitmapWithWhiteBackground
import com.easit.puzzle.model.createSeed
import com.easit.puzzle.model.retrieveStartImageList
import com.easit.puzzle.model.shuffleBitmap
import com.easit.puzzle.model.splitPuzzle
import com.easit.puzzle.ui.main.Timer
import com.easit.puzzle.ui.theme.PuzzleTheme

@SuppressLint("MutableCollectionMutableState")
@Composable
fun JigsawScreen(
    onNextButtonClicked: () -> Unit = {},
) {

    val context = LocalContext.current

    val jigsawViewModel = viewModel<JigsawViewModel>()

    val whiteBG by remember { mutableStateOf( createBitmapWithWhiteBackground(200, 200) )}
    var defaultList by remember { mutableStateOf( listOf<Bitmap>())}

    val split by remember {
        mutableStateOf(
            mutableListOf(
                whiteBG, whiteBG, whiteBG, whiteBG,
                whiteBG, whiteBG, whiteBG, whiteBG,
                whiteBG, whiteBG, whiteBG, whiteBG,
                whiteBG, whiteBG, whiteBG, whiteBG
            ))
    }
    val j = retrieveImageFromInternalStorage(context, "JigsawImage")

    LaunchedEffect(key1 = true) {
        when (j){
            null -> {
                //Do nothing
            }
            else -> {
                defaultList = splitPuzzle(4, j)
                val question = shuffleBitmap(defaultList, createSeed())
                //val question by remember { mutableStateOf( shuffleBitmap(defaultList, createSeed()) )}
                split[0] = question[0]
                split[1] = question[1]
                split[2] = question[2]
                split[3] = question[3]
                split[4] = question[4]
                split[5] = question[5]
                split[6] = question[6]
                split[7] = question[7]
                split[8] = question[8]
                split[9] = question[9]
                split[10] = question[10]
                split[11] = question[11]
                split[12] = question[12]
                split[13] = question[13]
                split[14] = question[14]
                split[15] = question[15]
            }
        }
    }


    val y = jigsawViewModel.calculation.collectAsState().value
    val x = jigsawViewModel.score.collectAsState().value
    when (x){
        0.toDouble() -> {
            //Toast.makeText(context, "Value = 0", Toast.LENGTH_SHORT).show()
            Toast.makeText(context, "Calculation = $y", Toast.LENGTH_SHORT).show()
        }
        else -> {
            //Toast.makeText(context, "Value is showing", Toast.LENGTH_SHORT).show()
            Toast.makeText(context, "Calculation = $y", Toast.LENGTH_SHORT).show()
        }
    }

    val width = 50
    val height = 50
    var smallBoxPadding = 2
    val spacingValue = 0
    var boxActive by remember { mutableStateOf( 0 )}
    var rowActive by remember { mutableStateOf( 0 )}
    var buttonText by remember { mutableStateOf( "Swap" )}
    val spacerHeight by remember { mutableStateOf( 36)}
    val rewSpacing by remember { mutableStateOf( 6)}

    /*
    val image = ImageData()
    val response = image.setBackground(200, 200, Color.Red, Color.Blue)


    val profileImageBitmap = fullImageProcess(
        text = "IO", width = 200, height = 200, startColor = Color.DarkGray, endColor = Color.LightGray,
        textColor = Color.White, textSize = 100f, typeface = Typeface.MONOSPACE, 123456
    )

    val defaultList by remember { mutableStateOf( splitPuzzle(4, profileImageBitmap ))}
    val question by remember { mutableStateOf( shuffleBitmap(defaultList, createSeed()) )}


    val split by remember {
        mutableStateOf(
            mutableListOf(
                question[0], question[1], question[2], question[3],
                question[4], question[5], question[6], question[7],
                question[8], question[9], question[10], question[11],
                question[12], question[13], question[14], question[15]
        ))
    }*/

    val jigsawList by remember {
        mutableStateOf(
            mutableListOf(
            whiteBG, whiteBG, whiteBG, whiteBG,
            whiteBG, whiteBG, whiteBG, whiteBG,
            whiteBG, whiteBG, whiteBG, whiteBG,
            whiteBG, whiteBG, whiteBG, whiteBG
        ))
    }

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

            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                //
                Box(
                    modifier = Modifier
                        .border(
                            width = 1.dp,
                            brush = Brush.horizontalGradient(
                                listOf(
                                    Color.Black,
                                    Color.Black
                                )
                            ),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .wrapContentWidth()
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.LightGray)
                        .padding(top = 10.dp, bottom = 10.dp, start = 24.dp, end = 24.dp)
                    ,
                    contentAlignment = Alignment.Center
                ){
                    Text(text = "Score: $x")
                }

                Box(
                    contentAlignment = Alignment.Center,
                    //modifier = Modifier.size(60.dp, 60.dp)
                ) {
                    Timer(
                        totalTime = 300L * 1000L,
                        handleColor = Color.Green,
                        inactiveBarColor = Color.DarkGray,
                        activeBarColor = Color(0xFF37B900),
                        modifier = Modifier.size(84.dp),
                        strokeWidth = 2.dp
                    )
                }
            }

            Spacer(modifier = Modifier.height(36.dp))

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
                                bitmap = jigsawList[0].asImageBitmap(),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(width.dp)
                                    .height(height.dp)
                                    .clickable {
                                        selectedList = setAsActive(0)
                                        boxActive = 0
                                    }
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
                                bitmap = jigsawList[1].asImageBitmap(),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(width.dp)
                                    .height(height.dp)
                                    .clickable {
                                        selectedList = setAsActive(1)
                                        boxActive = 1
                                    }
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
                                bitmap = jigsawList[2].asImageBitmap(),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(width.dp)
                                    .height(height.dp)
                                    .clickable {
                                        selectedList = setAsActive(2)
                                        boxActive = 2
                                    }
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
                                bitmap = jigsawList[3].asImageBitmap(),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(width.dp)
                                    .height(height.dp)
                                    .clickable {
                                        selectedList = setAsActive(3)
                                        boxActive = 3
                                    }
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
                                bitmap = jigsawList[4].asImageBitmap(),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(width.dp)
                                    .height(height.dp)
                                    .clickable {
                                        selectedList = setAsActive(4)
                                        boxActive = 4
                                    }
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
                                bitmap = jigsawList[5].asImageBitmap(),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(width.dp)
                                    .height(height.dp)
                                    .clickable {
                                        selectedList = setAsActive(5)
                                        boxActive = 5
                                    }
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
                                bitmap = jigsawList[6].asImageBitmap(),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(width.dp)
                                    .height(height.dp)
                                    .clickable {
                                        selectedList = setAsActive(6)
                                        boxActive = 6
                                    }
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
                                bitmap = jigsawList[7].asImageBitmap(),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(width.dp)
                                    .height(height.dp)
                                    .clickable {
                                        selectedList = setAsActive(7)
                                        boxActive = 7
                                    }
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
                                bitmap = jigsawList[8].asImageBitmap(),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(width.dp)
                                    .height(height.dp)
                                    .clickable {
                                        selectedList = setAsActive(8)
                                        boxActive = 8
                                    }
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
                                bitmap = jigsawList[9].asImageBitmap(),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(width.dp)
                                    .height(height.dp)
                                    .clickable {
                                        selectedList = setAsActive(9)
                                        boxActive = 9
                                    }
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
                                bitmap = jigsawList[10].asImageBitmap(),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(width.dp)
                                    .height(height.dp)
                                    .clickable {
                                        selectedList = setAsActive(10)
                                        boxActive = 10
                                    }
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
                                bitmap = jigsawList[11].asImageBitmap(),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(width.dp)
                                    .height(height.dp)
                                    .clickable {
                                        selectedList = setAsActive(11)
                                        boxActive = 11
                                    }
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
                                .clickable {
                                    selectedList = setAsActive(12)
                                    boxActive = 12
                                }
                        ){
                            //
                            Image(
                                bitmap = jigsawList[12].asImageBitmap(),
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
                                bitmap = jigsawList[13].asImageBitmap(),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(width.dp)
                                    .height(height.dp)
                                    .clickable {
                                        selectedList = setAsActive(13)
                                        boxActive = 13
                                    }
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
                                bitmap = jigsawList[14].asImageBitmap(),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(width.dp)
                                    .height(height.dp)
                                    .clickable {
                                        selectedList = setAsActive(14)
                                        boxActive = 14
                                    }
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
                                bitmap = jigsawList[15].asImageBitmap(),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(width.dp)
                                    .height(height.dp)
                                    .clickable {
                                        selectedList = setAsActive(15)
                                        boxActive = 15
                                    }
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(36.dp))

            Button(
                onClick = {
                    //Switch bitmap
                    val temp = split[rowActive]
                    split[rowActive] = jigsawList[boxActive]
                    jigsawList[boxActive] = temp
                    //Jigsaw box should refresh
                    buttonText = "Swapping"
                    buttonText = "Swap"
                    //Lazy Row should refresh
                    smallBoxPadding = 1
                    smallBoxPadding = 2
                },
                shape = RoundedCornerShape(10.dp),
                colors = buttonColors(
                    containerColor = Color.LightGray,
                    contentColor = Color.Black
                ),
                contentPadding = PaddingValues(top = 10.dp, bottom = 10.dp, start = 24.dp, end = 24.dp),
                border = BorderStroke(1.dp, Color.Black)
            ) {
                Text(text = buttonText)
            }

            Spacer(modifier = Modifier.height(36.dp))

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(rewSpacing.dp)
            ){
                item {
                    Box(
                        modifier = Modifier
                            .background(getBackground(bottomList, 0))
                            .padding(smallBoxPadding.dp)
                    ){
                        //
                        Image(
                            bitmap = split[0].asImageBitmap(),
                            contentDescription = null,
                            modifier = Modifier
                                .width(width.dp)
                                .height(height.dp)
                                .clickable {
                                    bottomList = setAsActive(0)
                                    rowActive = 0
                                }
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
                            bitmap = split[1].asImageBitmap(),
                            contentDescription = null,
                            modifier = Modifier
                                .width(width.dp)
                                .height(height.dp)
                                .clickable {
                                    bottomList = setAsActive(1)
                                    rowActive = 1
                                }
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
                            bitmap = split[2].asImageBitmap(),
                            contentDescription = null,
                            modifier = Modifier
                                .width(width.dp)
                                .height(height.dp)
                                .clickable {
                                    bottomList = setAsActive(2)
                                    rowActive = 2
                                }
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
                            bitmap = split[3].asImageBitmap(),
                            contentDescription = null,
                            modifier = Modifier
                                .width(width.dp)
                                .height(height.dp)
                                .clickable {
                                    bottomList = setAsActive(3)
                                    rowActive = 3
                                }
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
                            bitmap = split[4].asImageBitmap(),
                            contentDescription = null,
                            modifier = Modifier
                                .width(width.dp)
                                .height(height.dp)
                                .clickable {
                                    bottomList = setAsActive(4)
                                    rowActive = 4
                                }
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
                            bitmap = split[5].asImageBitmap(),
                            contentDescription = null,
                            modifier = Modifier
                                .width(width.dp)
                                .height(height.dp)
                                .clickable {
                                    bottomList = setAsActive(5)
                                    rowActive = 5
                                }
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
                            bitmap = split[6].asImageBitmap(),
                            contentDescription = null,
                            modifier = Modifier
                                .width(width.dp)
                                .height(height.dp)
                                .clickable {
                                    bottomList = setAsActive(6)
                                    rowActive = 6
                                }
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
                            bitmap = split[7].asImageBitmap(),
                            contentDescription = null,
                            modifier = Modifier
                                .width(width.dp)
                                .height(height.dp)
                                .clickable {
                                    bottomList = setAsActive(7)
                                    rowActive = 7
                                }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(rewSpacing.dp)
            ){
                item {
                    Box(
                        modifier = Modifier
                            .background(getBackground(bottomList, 8))
                            .padding(smallBoxPadding.dp)
                    ){
                        //
                        Image(
                            bitmap = split[8].asImageBitmap(),
                            contentDescription = null,
                            modifier = Modifier
                                .width(width.dp)
                                .height(height.dp)
                                .clickable {
                                    bottomList = setAsActive(8)
                                    rowActive = 8
                                }
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
                            bitmap = split[9].asImageBitmap(),
                            contentDescription = null,
                            modifier = Modifier
                                .width(width.dp)
                                .height(height.dp)
                                .clickable {
                                    bottomList = setAsActive(9)
                                    rowActive = 9
                                }
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
                            bitmap = split[10].asImageBitmap(),
                            contentDescription = null,
                            modifier = Modifier
                                .width(width.dp)
                                .height(height.dp)
                                .clickable {
                                    bottomList = setAsActive(10)
                                    rowActive = 10
                                }
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
                            bitmap = split[11].asImageBitmap(),
                            contentDescription = null,
                            modifier = Modifier
                                .width(width.dp)
                                .height(height.dp)
                                .clickable {
                                    bottomList = setAsActive(11)
                                    rowActive = 11
                                }
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
                            bitmap = split[12].asImageBitmap(),
                            contentDescription = null,
                            modifier = Modifier
                                .width(width.dp)
                                .height(height.dp)
                                .clickable {
                                    bottomList = setAsActive(12)
                                    rowActive = 12
                                }
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
                            bitmap = split[13].asImageBitmap(),
                            contentDescription = null,
                            modifier = Modifier
                                .width(width.dp)
                                .height(height.dp)
                                .clickable {
                                    bottomList = setAsActive(13)
                                    rowActive = 13
                                }
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
                            bitmap = split[14].asImageBitmap(),
                            contentDescription = null,
                            modifier = Modifier
                                .width(width.dp)
                                .height(height.dp)
                                .clickable {
                                    bottomList = setAsActive(14)
                                    rowActive = 14
                                }
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
                            bitmap = split[15].asImageBitmap(),
                            contentDescription = null,
                            modifier = Modifier
                                .width(width.dp)
                                .height(height.dp)
                                .clickable {
                                    bottomList = setAsActive(15)
                                    rowActive = 15
                                }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(36.dp))

            Button(
                onClick = {
                    jigsawViewModel.checkScore(jigsawList, defaultList)
                },
                shape = RoundedCornerShape(10.dp),
                colors = buttonColors(
                    containerColor = Color.Red,
                    contentColor = Color.White
                ),
                contentPadding = PaddingValues(top = 10.dp, bottom = 10.dp, start = 24.dp, end = 24.dp),
                border = BorderStroke(1.dp, Color.Black)
            ) {
                Text(text = "Submit", fontWeight = FontWeight.Bold)
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
fun JigsawPreview() {
    PuzzleTheme {
        JigsawScreen()
    }
}

/*
            Box(
                modifier = Modifier
                    .border(
                        width = 1.dp,
                        brush = Brush.horizontalGradient(
                            listOf(
                                Color.Black,
                                Color.Black
                            )
                        ),
                        shape = RoundedCornerShape(10.dp)
                    )
                    .wrapContentWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.LightGray)
                    .padding(top = 10.dp, bottom = 10.dp, start = 24.dp, end = 24.dp)
                    .clickable {
                        val temp = split[rowActive]
                        split[rowActive] = jigsawList[boxActive]
                        jigsawList[boxActive] = temp
                        buttonText = "Swapping"
                        buttonText = "Swap"
                        //Lazy Row should refresh
                        smallBoxPadding = 1
                        smallBoxPadding = 2

                    }
                ,
                contentAlignment = Alignment.Center
            ){
                Text(text = buttonText)
            }*/