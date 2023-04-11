package app.futured.androidprojecttemplate.navigation

import androidx.navigation.NavController

interface NavigationDestinations {
    fun popBackStack()
    fun navigateToDetailScreen(title: String, subtitle: String? = null, value: String? = null)
}

/**
 * Class that triggers navigation actions on provided [navController].
 */
class NavigationDestinationsImpl(private val navController: NavController) : NavigationDestinations {

    override fun popBackStack() {
        navController.popBackStack()
    }

    override fun navigateToDetailScreen(title: String, subtitle: String?, value: String?) =
        navController.navigate(Destination.Detail.buildRoute(title, subtitle, value))
}
