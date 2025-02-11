package com.mokelab.lesson.compose.layout.applist

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.mokelab.lesson.compose.layout.AppList
import kotlinx.serialization.Serializable

fun NavGraphBuilder.appListGraph(
    navController: NavController,
) {
    navigation<AppList>(startDestination = Top) {
        composable<Top> {
            AppListScreen(
                back = { navController.popBackStack() },
                toAnswer = { navController.navigate(Answer) },
                toExample = { navController.navigate(Example) }
            )
        }
        composable<Answer> {
            AppListAnswerScreen(back = { navController.popBackStack() })
        }
        composable<Example> {
            AppListExampleScreen(back = { navController.popBackStack() })
        }

    }
}

@Serializable
private data object Top

@Serializable
private data object Answer

@Serializable
private data object Example