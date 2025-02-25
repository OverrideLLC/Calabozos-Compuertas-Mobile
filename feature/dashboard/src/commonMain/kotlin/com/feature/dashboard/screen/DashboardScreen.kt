package com.feature.dashboard.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
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
import androidx.navigation.NavController
import com.feature.dashboard.utils.BooksEnums
import com.resources.LogoCyC
import com.resources.Res
import com.resources.pagina1_image_runes
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun DashboardScreen(navController: NavController) = Screen(navController)

@Composable
private fun Screen(navController: NavController) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.Black,
        topBar = { TopBar() },
        content = { padding ->
            Content(navController, padding)
        },
    )
}

@Composable
private fun TopBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(.3f)
            .background(colorScheme.background),
        contentAlignment = Alignment.Center,
        content = {
            Image(
                painter = painterResource(Res.drawable.pagina1_image_runes),
                contentDescription = "menu",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
    )
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(.3f)
            .padding(top = 50.dp, start = 16.dp),
        contentAlignment = Alignment.TopStart,
        content = {
            Column(
                modifier = Modifier.wrapContentSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                IconButton(
                    modifier = Modifier.size(60.dp).background(colorScheme.background, CircleShape),
                    onClick = {},
                    content = {
                        Icon(
                            painter = painterResource(Res.drawable.LogoCyC),
                            contentDescription = "menu",
                            modifier = Modifier.fillMaxSize(),
                            tint = Color.Black
                        )
                    }
                )
                Spacer(modifier = Modifier.padding(5.dp))
                Text(
                    text = "Perfil",
                    color = colorScheme.background,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleLarge
                )
            }
            Box(
                contentAlignment = Alignment.BottomEnd,
                modifier = Modifier.fillMaxSize(),
                content = {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(.5f)
                            .height(70.dp)
                            .padding(10.dp)
                            .background(colorScheme.background, RoundedCornerShape(30.dp)),
                        contentAlignment = Alignment.Center,
                        content = {
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.padding(10.dp).fillMaxSize()
                            ) {
                                IconButton(
                                    modifier = Modifier
                                        .size(40.dp)
                                        .background(Color.Transparent, CircleShape),
                                    onClick = {},
                                    content = {
                                        Icon(
                                            imageVector = Icons.Default.Favorite,
                                            contentDescription = "menu",
                                            modifier = Modifier.fillMaxSize(),
                                            tint = Color.Red
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
                                            contentDescription = "menu",
                                            modifier = Modifier.fillMaxSize(),
                                            tint = Color.Green
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
                                            contentDescription = "menu",
                                            modifier = Modifier.fillMaxSize(),
                                            tint = Color.Black
                                        )
                                    }
                                )
                            }
                        }
                    )
                }
            )
        }
    )
}

@Composable
private fun Content(navController: NavController, paddingValues: PaddingValues) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(colorScheme.background)
            .padding(16.dp)
            .padding(paddingValues)
            .clip(shape = RoundedCornerShape(20.dp)),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        content = {
            items(BooksEnums.entries) { book ->
                BookItem(
                    color = book.color,
                    image = book.image,
                    title = book.title,
                    description = book.description,
                    onClick = {
                        navController.navigate(book.routes)
                    }
                )
                Spacer(modifier = Modifier.padding(10.dp))
            }
        }
    )
}

@Composable
private fun BookItem(
    color: Color,
    image: DrawableResource,
    title: String,
    description: String,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(shape = RoundedCornerShape(20.dp))
            .clickable { onClick() },
        contentAlignment = Alignment.Center,
        content = {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                content = {
                    Image(
                        painter = painterResource(image),
                        contentDescription = "portada",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
            )
        }
    )
}