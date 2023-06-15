package app.futured.academyproject.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import app.futured.academyproject.tools.compose.ComponentPreviews

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
