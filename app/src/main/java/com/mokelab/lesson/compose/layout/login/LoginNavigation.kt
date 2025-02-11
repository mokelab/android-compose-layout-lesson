package com.mokelab.lesson.compose.layout.login

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.mokelab.lesson.compose.layout.Login
import kotlinx.serialization.Serializable

fun NavGraphBuilder.loginGraph(
    navController: NavController,
) {
    navigation<Login>(startDestination = Top) {
        composable<Top> {
            LoginScreen(
                back = { navController.popBackStack() },
                toAnswer = { navController.navigate(Answer) },
                toExample = { navController.navigate(Example) }
            )
        }
        composable<Answer> {
            LoginAnswerScreen(back = { navController.popBackStack() })
        }
        composable<Example> {
            LoginExampleScreen(back = { navController.popBackStack() })
        }
    }
}

@Serializable
private data object Top

@Serializable
private data object Answer

@Serializable
private data object Example