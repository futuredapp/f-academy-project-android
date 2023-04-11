package app.futured.androidprojecttemplate.ui.components

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import app.futured.androidprojecttemplate.tools.compose.ComponentPreviews

@Composable
fun AddFloatingActionButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    FloatingActionButton(onClick = onClick, modifier = modifier) {
        Icon(Icons.Default.Add, "")
    }
}

@ComponentPreviews
@Composable
fun AddFloatingActionButtonPreview() {
    Showcase {
        AddFloatingActionButton(onClick = {})
    }
}
