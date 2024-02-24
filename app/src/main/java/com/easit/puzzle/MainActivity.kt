package com.easit.puzzle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.easit.puzzle.ui.main.puzzle1.JigsawScreen
import com.easit.puzzle.ui.theme.PuzzleTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PuzzleTheme {

                val navController = rememberNavController()
                val backStackEntry by navController.currentBackStackEntryAsState()

                fun getRoute(): Screen {
                    return when (backStackEntry?.destination?.route) {
                        Screen.Create.route -> Screen.Create
                        Screen.Play.route -> Screen.Play
                        else -> Screen.Create
                    }
                }
                Scaffold {
                    Navigation(navController = navController, innerPadding = it.calculateTopPadding())
                }
            }
        }
    }
}

