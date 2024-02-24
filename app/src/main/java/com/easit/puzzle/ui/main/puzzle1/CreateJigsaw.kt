package com.easit.puzzle.ui.main.puzzle1

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import android.content.Context
import java.io.FileOutputStream
import java.io.IOException
import android.graphics.BitmapFactory
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.easit.puzzle.model.createBitmapWithWhiteBackground
import java.io.FileInputStream

@Composable
fun CreateJigsaw(
    onNextButtonClicked: () -> Unit = {},
) {

    //
    val context = LocalContext.current

    var bitmap by remember { mutableStateOf<Bitmap?>(null) }
    var selectedImageUri by remember {
        mutableStateOf<Uri?>(null)
    }

    val whiteBG by remember { mutableStateOf( createBitmapWithWhiteBackground(1200, 1200) )}
    var estimatedTime by remember { mutableIntStateOf( 60 ) }
    //
    val singlePhotoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri -> selectedImageUri = uri }
    )
    selectedImageUri?.let {
        if (Build.VERSION.SDK_INT < 28) {
            bitmap = MediaStore.Images
                .Media.getBitmap(context.contentResolver, it)
        } else {
            val source = ImageDecoder.createSource(context.contentResolver, it)
            bitmap = ImageDecoder.decodeBitmap(source)
        }
    }

    Column(
        modifier = Modifier.fillMaxWidth().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.CenterStart
        ){
            Text(
                text = "Puzzle",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 36.sp,
                color = Color.Red,
                fontFamily = FontFamily.Cursive,
                textDecoration = TextDecoration.Underline
            )
        }
        Spacer(modifier = Modifier.height(24.dp))

        //
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    brush = Brush.horizontalGradient(listOf(Color.Black, Color.Black)),
                    shape = RoundedCornerShape(10.dp)
                )
                .clip(RoundedCornerShape(10.dp))
                .background(Color.Gray),
            contentAlignment = Alignment.Center
        ){
            //

            if (bitmap == null){
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .background(Color.White)
                        .clickable {
                            singlePhotoPickerLauncher.launch(
                                PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                            )
                        }
                ){
                    Image(
                        bitmap = whiteBG.asImageBitmap(),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                singlePhotoPickerLauncher.launch(
                                    PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                                )
                            },
                        contentScale = ContentScale.Fit,
                    )
                    Text(
                        text = "Click to select Image",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 18.sp,
                        color = Color.Black
                    )
                }
            }else {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .background(Color.White)
                        .clickable {
                            singlePhotoPickerLauncher.launch(
                                PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                            )
                        }
                ){
                    Image(
                        bitmap = bitmap!!.asImageBitmap(),
                        contentDescription = null,
                        modifier = Modifier
                            .clickable {
                                singlePhotoPickerLauncher.launch(
                                    PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                                )
                            }
                    )
                }
            }

        }
        Spacer(modifier = Modifier.height(24.dp))
        /*Button(
            onClick = {
                //

            },
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.LightGray,
                contentColor = Color.Black
            ),
            contentPadding = PaddingValues(top = 10.dp, bottom = 10.dp, start = 24.dp, end = 24.dp),
            border = BorderStroke(1.dp, Color.Black)
        ) {
            Text(text = "Get Image")
        }*/

        /*selectedImageUri?.let {
            if (Build.VERSION.SDK_INT < 28) {
                bitmap = MediaStore.Images
                    .Media.getBitmap(context.contentResolver, it)
            } else {
                val source = ImageDecoder.createSource(context.contentResolver, it)
                bitmap = ImageDecoder.decodeBitmap(source)
            }

            bitmap?.let { btmMain ->
                Image(
                    bitmap = btmMain.asImageBitmap(),
                    contentDescription = null,
                    modifier = Modifier
                        .size(200.dp)
                        .padding(20.dp)
                )
                Text(text = "W=${bitmap!!.width}, H=${bitmap!!.height}")
            }
        }*/

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "Target time",
                fontWeight = FontWeight.Bold
            )

            //
            Text(
                text = "5 Minutes",
                fontWeight = FontWeight.Bold
            )

            //
            /*OutlinedTextField(
                modifier = Modifier.width(48.dp),
                value = estimatedTime,
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default,
                onValueChange = {
                    //estimatedTime = it
                }
            )*/

        }
        Spacer(modifier = Modifier.height(24.dp))

        //
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                //Navigate to quiz page
                saveBitmapToInternalStorage(context, bitmap!!, "JigsawImage")
                onNextButtonClicked()
            },
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red,
                contentColor = Color.White
            ),
            contentPadding = PaddingValues(top = 10.dp, bottom = 10.dp, start = 24.dp, end = 24.dp),
            border = BorderStroke(1.dp, Color.Black)
        ) {
            Text(text = "Create Quiz", fontWeight = FontWeight.Bold)
        }
    }
}

fun saveBitmapToInternalStorage(context: Context, bitmap: Bitmap, filename: String) {
    try {
        val fos = context.openFileOutput(filename, Context.MODE_PRIVATE)
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos)
        fos.close()
    } catch (e: IOException) {
        e.printStackTrace()
    }
}


fun retrieveImageFromInternalStorage(context: Context, filename: String): Bitmap? {
    return try {
        val fis = context.openFileInput(filename)
        val bitmap = BitmapFactory.decodeStream(fis)
        fis.close()
        bitmap
    } catch (e: IOException) {
        e.printStackTrace()
        null
    }
}
