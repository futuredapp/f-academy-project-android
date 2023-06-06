package app.futured.academyproject.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.hilt.navigation.compose.hiltViewModel
import app.futured.academyproject.data.model.local.Place
import app.futured.academyproject.navigation.NavigationDestinations
import app.futured.academyproject.tools.Constants.Ui.GRADIENT_OVERLAY_ALPHA
import app.futured.academyproject.tools.Constants.Ui.PLACE_CARD_ASPECT_RATIO
import app.futured.academyproject.tools.arch.EventsEffect
import app.futured.academyproject.tools.arch.onEvent
import app.futured.academyproject.tools.compose.ScreenPreviews
import app.futured.academyproject.tools.preview.PlacesProvider
import app.futured.academyproject.ui.components.AppBar
import app.futured.academyproject.ui.components.Showcase
import app.futured.academyproject.ui.theme.Grid
import app.futured.academyproject.ui.theme.cloud200
import app.futured.academyproject.ui.theme.cloud50
import app.futured.academyproject.ui.theme.ink600
import app.futured.academyproject.ui.theme.ink900
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import kotlinx.collections.immutable.PersistentList

@Composable
fun HomeScreen(
    navigation: NavigationDestinations,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    with(viewModel) {
        EventsEffect {
            onEvent<NavigateToDetailEvent> {
                navigation.navigateToDetailScreen(
                    title = "Demo",
                    subtitle = "Subtitle",
                    value = "Demo Subtitle",
                )
            }
        }

        Home.Content(
            viewModel,
            viewState.places,
        )
    }
}

object Home {

    interface Actions {

        fun navigateToDetailScreen() = Unit

        fun incrementCounter() = Unit
    }

    object PreviewActions : Actions

    @Composable
    fun Content(
        actions: Actions,
        places: PersistentList<Place>,
        modifier: Modifier = Modifier,
    ) {
        Scaffold(
            topBar = { AppBar(title = "Davidova Kultůromapa", onNavigationIconClick = null) },
            modifier = modifier,
        ) { contentPadding ->
            Box(
                modifier = Modifier.padding(contentPadding),
            ) {
                LazyColumn(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    contentPadding = PaddingValues(Grid.d4),
                    verticalArrangement = Arrangement.spacedBy(Grid.d4),
                    modifier = Modifier.fillMaxSize(),
                ) {
                    items(
                        count = places.size,
                        key = { index -> places[index].id },
                    ) { index ->
                        PlaceCard(places[index], actions)
                    }
                }
            }
        }
    }

    @Composable
    private fun PlaceCard(place: Place, actions: Actions) {
        Card(
            backgroundColor = ink600,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(PLACE_CARD_ASPECT_RATIO)
                .clickable {
                    actions.navigateToDetailScreen()
                },
        ) {
            Box {
                Image(
                    painter = rememberAsyncImagePainter(
                        ImageRequest.Builder(LocalContext.current)
                            .data(place.image1Url)
                            .crossfade(true)
                            .build(),
                    ),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize(),
                )

                Box(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                0f to ink900.copy(alpha = 0f),
                                1f to ink900.copy(alpha = GRADIENT_OVERLAY_ALPHA),
                            ),
                        ),
                ) {}

                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .fillMaxWidth()
                        .padding(Grid.d4),
                ) {
                    Text(
                        text = place.name,
                        style = MaterialTheme.typography.h3,
                        color = cloud50,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                    Spacer(modifier = Modifier.height(Grid.d2))
                    Text(
                        text = place.type,
                        style = MaterialTheme.typography.body1,
                        color = cloud200,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            }
        }
    }
}

@ScreenPreviews
@Composable
private fun HomeContentPreview(@PreviewParameter(PlacesProvider::class) places: PersistentList<Place>) {
    Showcase {
        Home.Content(
            Home.PreviewActions,
            places,
        )
    }
}
