package com.mokelab.lesson.compose.layout

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mokelab.lesson.compose.layout.applist.appListGraph
import com.mokelab.lesson.compose.layout.login.loginGraph
import com.mokelab.lesson.compose.layout.top.TopScreen
import kotlinx.serialization.Serializable

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Top) {
        composable<Top> {
            TopScreen(
                toLogin = { navController.navigate(Login) },
                toAppList = { navController.navigate(AppList) },
            )
        }
        loginGraph(navController = navController)
        appListGraph(navController = navController)
    }
}

@Serializable
data object Top

@Serializable
data object Login

@Serializable
data object AppList

