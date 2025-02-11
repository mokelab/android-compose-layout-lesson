package com.mokelab.lesson.compose.layout.loading

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.mokelab.lesson.compose.layout.Loading
import kotlinx.serialization.Serializable

fun NavGraphBuilder.loadingGraph(
    navController: NavController,
) {
    navigation<Loading>(startDestination = Top) {
        composable<Top> {
            LoadingScreen(
                back = { navController.popBackStack() },
                toAnswer = { navController.navigate(Answer) },
                toExample = { navController.navigate(Example) }
            )
        }
        composable<Answer> {
            LoginAnswerScreen(back = { navController.popBackStack() })
        }
        composable<Example> {
            LoadingExampleScreen(back = { navController.popBackStack() })
        }
    }
}

@Serializable
private data object Top

@Serializable
private data object Answer

@Serializable
private data object Example