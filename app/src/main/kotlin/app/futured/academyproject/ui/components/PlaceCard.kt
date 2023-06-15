package app.futured.academyproject.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import app.futured.academyproject.data.model.local.Place
import app.futured.academyproject.tools.Constants.Ui.GRADIENT_OVERLAY_ALPHA
import app.futured.academyproject.tools.Constants.Ui.PLACE_CARD_ASPECT_RATIO
import app.futured.academyproject.ui.theme.Grid
import app.futured.academyproject.ui.theme.cloud100
import app.futured.academyproject.ui.theme.cloud50
import app.futured.academyproject.ui.theme.ink900
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest

@Composable
fun PlaceCard(place: Place, onClick: (Int) -> Unit, modifier: Modifier = Modifier) {
    Card(
        colors = CardDefaults.cardColors(),
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(PLACE_CARD_ASPECT_RATIO)
            .clip(MaterialTheme.shapes.medium)
            .clickable { onClick(place.id) },
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
                    .fillMaxWidth()
                    .fillMaxHeight()
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
                    style = MaterialTheme.typography.titleMedium,
                    color = cloud50,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )
                Spacer(modifier = Modifier.height(Grid.d1))
                Text(
                    text = place.type.uppercase(),
                    style = MaterialTheme.typography.bodyMedium,
                    color = cloud100,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
    }
}
