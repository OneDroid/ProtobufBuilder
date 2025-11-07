package org.onedroid.protobufbuilder.core.navigation

import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavigation(
    navController: NavHostController,
    initialScreen: Route,
    snackBarHostState: SnackbarHostState
) {
    NavHost(
        navController = navController,
        startDestination = initialScreen,
    ) {
        composable<Route.Home> {
            Text("Home")
        }
    }
}