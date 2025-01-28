package org.book.ui.components

import androidx.compose.animation.Crossfade
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun IconCrossfade(
    targetState: Boolean,
    label: String,
    iconActual: DrawableResource,
    iconNew: DrawableResource,
) {
    Crossfade(
        targetState = targetState,
        label = label,
        content = { action ->
            if (action) {
                Icon(
                    painter = painterResource(iconActual),
                    contentDescription = "",
                    tint = colorScheme.tertiary
                )
            } else {
                Icon(
                    painter = painterResource(iconNew),
                    contentDescription = "",
                    tint = colorScheme.tertiary
                )
            }
        }
    )
}