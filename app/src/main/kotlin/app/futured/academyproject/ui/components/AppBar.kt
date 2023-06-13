package app.futured.academyproject.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import app.futured.academyproject.tools.compose.ComponentPreviews
import app.futured.academyproject.ui.theme.CustomColor

@Composable
fun AppBar(
    title: String,
    modifier: Modifier = Modifier,
    navModifier: Modifier = Modifier,
    alpha: Float = 1f,
    onNavigationIconClick: (() -> Unit)? = null,
    navIcon: @Composable () -> Unit = { Icon(imageVector = Icons.Filled.ArrowBack, "") },
    actions: @Composable (RowScope.() -> Unit) = { },
    showDivider: Boolean = false,
    background: Color = MaterialTheme.colors.surface,
) {
    Box {
        TopAppBar(
            title = {
                Text(
                    text = title,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colors.onSurface,
                    style = MaterialTheme.typography.h3,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            },
            modifier = modifier.alpha(alpha),
            navigationIcon = onNavigationIconClick?.let {
                {
                    IconButton(onClick = it, modifier = navModifier) {
                        navIcon()
                    }
                }
            },
            backgroundColor = background,
            actions = actions,
        )

        if (showDivider) {
            Divider(
                modifier = Modifier.align(Alignment.BottomCenter),
                color = CustomColor.divider.copy(alpha = alpha),
            )
        }
    }
}

@ComponentPreviews
@Composable
private fun NotinoAppBarPreview() {
    Showcase {
        AppBar(title = "Title", onNavigationIconClick = {})
    }
}

@ComponentPreviews
@Composable
private fun NotinoAppBar2Preview() {
    Showcase {
        Box(modifier = Modifier.padding(bottom = 12.dp)) {
            AppBar(
                title = "Title", onNavigationIconClick = {}, showDivider = true,
                navIcon = {
                    Icon(imageVector = Icons.Filled.Close, "")
                },
            )
        }
    }
}
