package app.futured.androidprojecttemplate.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import app.futured.androidprojecttemplate.ui.theme.AppTheme

/**
 * Preview surface wrapper
 */
@Composable
fun Showcase(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    AppTheme {
        Surface(color = MaterialTheme.colors.background, modifier = modifier) {
            content()
        }
    }
}
