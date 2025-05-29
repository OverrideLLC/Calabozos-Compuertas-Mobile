package com.feature.dashboard.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.BottomAppBarDefaults.windowInsets
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.resources.Res
import com.resources.home_24dp_E3E3E3_FILL0_wght400_GRAD0_opsz24
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
internal fun BottomBar() {
    BottomAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        contentColor = colorScheme.primary,
        containerColor = colorScheme.surface.copy(alpha = 0.7f),
        windowInsets = windowInsets,
        content = { BottomBarContent() }
    )
}

@Composable
internal fun RowScope.BottomBarContent() {
    Spacer(modifier = Modifier.weight(1f))
    BottomIcon(
        icon = Res.drawable.home_24dp_E3E3E3_FILL0_wght400_GRAD0_opsz24,
        name = "Home",
        selected = true,
        modifier = Modifier,
        onClick = {}
    )
    Spacer(modifier = Modifier.weight(1f))
}

@Composable
internal fun BottomIcon(
    icon: DrawableResource,
    name: String,
    selected: Boolean,
    modifier: Modifier,
    onClick: () -> Unit
) {
    val colorIsSelected = if (selected) colorScheme.primary else colorScheme.secondary
    Box(
        modifier = modifier
            .clickable { onClick() },
        content = {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ){
                Icon(
                    painter = painterResource(icon),
                    contentDescription = name,
                    tint = colorIsSelected,
                    modifier = Modifier.height(34.dp)
                )
                Text(
                    text = name,
                    fontSize = 14.sp,
                    color = colorIsSelected
                )
            }
        }
    )
}
