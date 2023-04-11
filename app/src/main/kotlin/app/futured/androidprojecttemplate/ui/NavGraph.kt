package app.futured.androidprojecttemplate.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import app.futured.androidprojecttemplate.navigation.Destination
import app.futured.androidprojecttemplate.navigation.NavigationDestinations
import app.futured.androidprojecttemplate.navigation.NavigationDestinationsImpl
import app.futured.androidprojecttemplate.navigation.composable
import app.futured.androidprojecttemplate.ui.screens.detail.DetailScreen
import app.futured.androidprojecttemplate.ui.screens.home.HomeScreen

@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController(),
    navigation: NavigationDestinations = remember { NavigationDestinationsImpl(navController) },
) {
    NavHost(
        navController = navController,
        startDestination = Destination.Home.route,
    ) {
        composable(Destination.Home) {
            HomeScreen(navigation)
        }

        composable(Destination.Detail) {
            DetailScreen(navigation)
        }
    }
}
