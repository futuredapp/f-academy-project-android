package app.futured.academyproject.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.navArgument
import app.futured.academyproject.tools.Constants.Args.PLACE_ID

typealias DestinationArgumentKey = String
typealias DestinationArgumentValue = String

sealed class Destination(
    val route: String,
    val arguments: List<NamedNavArgument> = emptyList(),
    val deepLinks: List<NavDeepLink> = emptyList(),
) {
    object Home : Destination(route = "home")

    object Detail : Destination(
        route = "detail/{$PLACE_ID}",
        arguments = listOf(
            navArgument(PLACE_ID) {
                type = NavType.IntType
            },
        ),
    ) {
        fun buildRoute(placeId: Int): String = route
            .withArgument(PLACE_ID, placeId.toString())
    }
}

/**
 * Registers provided [destination] as a composable in [NavGraphBuilder].
 */
fun NavGraphBuilder.composable(
    destination: Destination,
    content: @Composable (NavBackStackEntry) -> Unit,
) = composable(
    route = destination.route,
    arguments = destination.arguments,
    deepLinks = destination.deepLinks,
    content = content,
)

/**
 * Registers provided [destination] as a dialog in [NavGraphBuilder].
 */
fun NavGraphBuilder.composable(
    destination: Destination,
    dialogProperties: DialogProperties = DialogProperties(),
    content: @Composable (NavBackStackEntry) -> Unit,
) = dialog(
    route = destination.route,
    arguments = destination.arguments,
    deepLinks = destination.deepLinks,
    dialogProperties = dialogProperties,
    content = content,
)

/**
 * Replaces an argument placeholder defined by [key] in
 * route string with value provided in [argument].
 *
 * Example:
 * Route: "emptyScreen/{title}"
 * key: "title"
 * argument: "Hello"
 * Result: "emptyScreen/Hello"
 */
fun String.withArgument(key: DestinationArgumentKey, argument: DestinationArgumentValue?) =
    argument?.let { replace("{$key}", it) } ?: this
