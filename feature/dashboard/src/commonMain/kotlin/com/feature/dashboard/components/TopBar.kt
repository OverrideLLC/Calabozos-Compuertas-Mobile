package com.feature.dashboard.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.resources.Res
import com.resources.compose_multiplatform
import com.resources.pagina1_image_runes
import com.resources.portada_image_runes
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
internal fun TopBar() {
    // Define the shape once to reuse it
    val bottomRoundedShape = RoundedCornerShape(
        bottomStart = 20.dp,
        bottomEnd = 20.dp
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background( // Apply background color and shape to the Box
                color = Color(0xFFE78515),
                shape = bottomRoundedShape
            ),
        contentAlignment = Alignment.BottomStart, // Align content (Row) to the bottom start
    ) {
        Image(
            painter = painterResource(Res.drawable.pagina1_image_runes),
            contentDescription = "portada",
            modifier = Modifier
                .fillMaxSize()
                .clip(bottomRoundedShape), // Clip the Image content to the shape
            contentScale = ContentScale.Crop // Crop the image content within the bounds
        )
        // This Row will be drawn on top of the Image, aligned to the BottomStart of the Box
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomStart) // Explicitly align Row to bottom start if needed
                .padding(bottom = 8.dp, start = 8.dp, end = 8.dp) // Add some padding for the icons
        ) {
            Profile(Res.drawable.portada_image_runes)
            Options()
        }
    }
}

@Composable
internal fun Profile(
    icon: DrawableResource,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        IconButton(
            modifier = Modifier.size(60.dp).background(Color.White, CircleShape),
            onClick = {},
            content = {
                Image(
                    painter = painterResource(icon),
                    contentDescription = "menu",
                    modifier = Modifier
                        .fillMaxSize()
                        .border(
                            width = 1.dp,
                            color = Color.White,
                            shape = CircleShape
                        ),
                    contentScale = ContentScale.Crop
                )
            }
        )
        Text(
            text = "Perfil",
            color = Color.White,
            fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
internal fun Options() {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(10.dp)
            .background(color = Color.White, RoundedCornerShape(40.dp))
            .size(
                width = 180.dp,
                height = 40.dp
            )
    ) {
        IconButton(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Transparent, CircleShape),
            onClick = {},
            content = {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "fovorite",
                    modifier = Modifier.fillMaxSize(),
                    tint = Color(0xffbd0202)
                )
            }
        )
        IconButton(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Transparent, CircleShape),
            onClick = {},
            content = {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "shop",
                    modifier = Modifier.fillMaxSize(),
                    tint = Color(0xff45bb46)
                )
            }
        )
        IconButton(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Transparent, CircleShape),
            onClick = {},
            content = {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "settings",
                    modifier = Modifier.fillMaxSize(),
                    tint = Color.Black
                )
            }
        )
    }
}