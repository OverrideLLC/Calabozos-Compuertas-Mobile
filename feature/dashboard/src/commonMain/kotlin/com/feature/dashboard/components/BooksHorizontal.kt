package com.feature.dashboard.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.resources.Res
import com.resources._7112649_pencil_hold_writing_hand_gesture_icon
import com.resources.pagina7_logic
import com.resources.portada_image_runes
import com.resources.portada_logic
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
internal fun BooksHorizontal() {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        content = {
            item { BookItem(image = Res.drawable.portada_image_runes) }
            item { Spacer(modifier = Modifier.width(16.dp)) }
            item { BookItem(image = Res.drawable.pagina7_logic) }
            item { Spacer(modifier = Modifier.width(16.dp)) }
            item { BookItemWorkInProgress() }
            item { Spacer(modifier = Modifier.width(16.dp)) }
        }
    )
}

@Composable
internal fun BookItem(
    image: DrawableResource,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = Modifier
            .height(280.dp)
            .width(150.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorScheme.surface
        ),
        onClick = { onClick() },
        content = {
            Image(
                painter = painterResource(image),
                contentDescription = "Book",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
    )
}

@Composable
internal fun BookItemWorkInProgress() {
    Card(
        modifier = Modifier
            .height(280.dp)
            .width(150.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorScheme.surface
        ),
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = painterResource(Res.drawable._7112649_pencil_hold_writing_hand_gesture_icon),
                    contentDescription = "Book",
                    modifier = Modifier.size(100.dp),
                    tint = colorScheme.onSurface
                )
                Text(
                    text = "Writing in Progress...",
                    style = MaterialTheme.typography.bodyMedium,
                    color = colorScheme.onSurface,
                    fontSize = 20.sp
                )
            }
        }
    )
}