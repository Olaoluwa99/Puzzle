package com.easit.puzzle

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.easit.puzzle.ui.main.puzzle1.CreateJigsaw
import com.easit.puzzle.ui.main.puzzle1.JigsawScreen

sealed class Screen(val route: String) {
    object Create : Screen("CreateJigsaw")
    object Play : Screen("PlayJigsaw")
}

@Composable
fun Navigation(
    navController: NavHostController,
    innerPadding : Dp
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Create.route
    ) {
        //
        composable(Screen.Create.route) {
            CreateJigsaw(
                onNextButtonClicked = {
                    navController.navigate(Screen.Play.route) {
                        popUpTo(Screen.Create.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(Screen.Play.route) {
            JigsawScreen(
                onNextButtonClicked = {
                    navController.navigate(Screen.Play.route) {
                        popUpTo(Screen.Create.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}