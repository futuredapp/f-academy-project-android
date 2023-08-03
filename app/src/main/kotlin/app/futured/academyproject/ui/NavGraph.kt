package app.futured.academyproject.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import app.futured.academyproject.navigation.Destination
import app.futured.academyproject.navigation.NavigationDestinations
import app.futured.academyproject.navigation.NavigationDestinationsImpl
import app.futured.academyproject.navigation.composable
import app.futured.academyproject.ui.screens.detail.DetailScreen
import app.futured.academyproject.ui.screens.home.HomeScreen

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
