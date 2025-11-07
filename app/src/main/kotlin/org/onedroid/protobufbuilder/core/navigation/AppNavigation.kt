package org.onedroid.protobufbuilder.core.navigation

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.onedroid.protobufbuilder.presentation.home.HomeScreen

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
            HomeScreen()
        }
    }
}