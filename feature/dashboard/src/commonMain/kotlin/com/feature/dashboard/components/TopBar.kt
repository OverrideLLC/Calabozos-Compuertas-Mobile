package com.feature.dashboard.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.resources.HOMEBAN
import com.resources.LogoCyC
import com.resources.Res
import com.resources.settings_24dp_E3E3E3_FILL0_wght400_GRAD0_opsz24
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun TopBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(210.dp),
        content = {
            Image(
                painter = painterResource(Res.drawable.HOMEBAN),
                contentDescription = "Logo",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(210.dp),
                contentScale = ContentScale.Crop
            )
            ContentTopBar()
        }
    )
}

@Composable
private fun ContentTopBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        content = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(horizontal = 16.dp)
                    .align(Alignment.TopCenter),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Profile()
                Settings()
            }
        }
    )
}

@Composable
private fun Settings(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    IconButton(
        modifier = modifier.size(30.dp),
        onClick = { onClick() },
        content = {
            Icon(
                painter = painterResource(Res.drawable.settings_24dp_E3E3E3_FILL0_wght400_GRAD0_opsz24),
                contentDescription = "Settings",
                modifier = Modifier.fillMaxSize(),
                tint = colorScheme.surface
            )
        }
    )
}

@Composable
private fun Profile(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    IconButton(
        modifier = modifier
            .size(30.dp)
            .background(
                color = colorScheme.surface,
                shape = CircleShape
            ),
        onClick = { onClick() },
        content = {
            Image(
                painter = painterResource(Res.drawable.LogoCyC),
                contentDescription = "Profile",
                modifier = Modifier.fillMaxSize()
            )
        }
    )
}