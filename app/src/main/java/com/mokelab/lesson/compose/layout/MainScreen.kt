package com.mokelab.lesson.compose.layout

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mokelab.lesson.compose.layout.applist.AppListExampleScreen
import com.mokelab.lesson.compose.layout.applist.AppListScreen
import com.mokelab.lesson.compose.layout.login.LoginExampleScreen
import com.mokelab.lesson.compose.layout.login.LoginScreen
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
        composable<Login> {
            LoginScreen(
                back = { navController.popBackStack() },
                toExample = { navController.navigate(LoginExample) }
            )
        }
        composable<LoginExample> {
            LoginExampleScreen(back = { navController.popBackStack() })
        }
        composable<AppList> {
            AppListScreen(
                back = { navController.popBackStack() },
                toExample = { navController.navigate(AppListExample) }
            )
        }
        composable<AppListExample> {
            AppListExampleScreen(back = { navController.popBackStack() })
        }
    }
}

@Serializable
data object Top

@Serializable
data object Login

@Serializable
data object LoginExample

@Serializable
data object AppList

@Serializable
data object AppListExample