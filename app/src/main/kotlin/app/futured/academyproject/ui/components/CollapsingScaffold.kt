package app.futured.academyproject.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import app.futured.academyproject.tools.extensions.alphaFromRange
import app.futured.academyproject.ui.theme.CustomColor
import app.futured.academyproject.ui.theme.Grid
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.CollapsingToolbarScaffoldScope
import me.onebone.toolbar.CollapsingToolbarScaffoldState
import me.onebone.toolbar.CollapsingToolbarScope
import me.onebone.toolbar.CollapsingToolbarState
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState
import me.onebone.toolbar.rememberCollapsingToolbarState

@Composable
fun CollapsingScaffold(
    modifier: Modifier = Modifier,
    toolbarModifier: Modifier = Modifier,
    background: Color = MaterialTheme.colors.surface,
    toolbarState: CollapsingToolbarState = rememberCollapsingToolbarState(),
    state: CollapsingToolbarScaffoldState = rememberCollapsingToolbarScaffoldState(toolbarState),
    scrollStrategy: ScrollStrategy = ScrollStrategy.ExitUntilCollapsed,
    enabled: Boolean = true,
    toolbar: @Composable CollapsingToolbarScope.(CollapsingToolbarScaffoldState) -> Unit = {},
    body: @Composable CollapsingToolbarScaffoldScope.() -> Unit = {},
) {
    CollapsingToolbarScaffold(
        modifier = modifier
            .background(background)
            .scrollable(
                orientation = Orientation.Vertical,
                // allow to scroll from within the toolbar
                state = rememberScrollableState { delta ->
                    state.toolbarState.dispatchRawDelta(delta)
                    delta
                },
            ),
        state = state,
        scrollStrategy = scrollStrategy,
        enabled = enabled,
        toolbarModifier = toolbarModifier,
        toolbar = { toolbar(state) },
        body = body,
    )
}

@Composable
fun CollapsingToolbarScope.CollapsingToolbar(
    state: CollapsingToolbarScaffoldState,
    onNavigationIconClick: (() -> Unit)?,
    @StringRes titleRes: Int,
    modifier: Modifier = Modifier,
    showDivider: Boolean = true,
    navIcon: @Composable () -> Unit = { Icon(imageVector = Icons.Filled.ArrowBack, "") },
) {
    // set offset for title alpha
    val titleAlpha = 1.minus(state.toolbarState.progress).alphaFromRange(0.5f, 1f)
    val largeTitleAlpha = state.toolbarState.progress.alphaFromRange(0.5f, 1f)

    AppBar(
        title = stringResource(titleRes),
        alpha = titleAlpha,
        onNavigationIconClick = onNavigationIconClick,
        showDivider = false,
        navIcon = navIcon,
    )

    Column(
        modifier = modifier
            .fillMaxHeight()
            .parallax(ratio = 1f),
    ) {
        Text(
            text = stringResource(titleRes),
            style = MaterialTheme.typography.h1,
            color = MaterialTheme.colors.onSurface,
            modifier = Modifier
                .padding(start = Grid.d4, bottom = Grid.d2, top = Grid.d15)
                .alpha(largeTitleAlpha),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
        )

        if (showDivider) {
            Divider(
                modifier = Modifier.alpha(titleAlpha),
                color = CustomColor.divider.copy(alpha = titleAlpha),
            )
        }
    }
}
