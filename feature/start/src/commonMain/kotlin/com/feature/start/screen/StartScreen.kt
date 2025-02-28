package com.feature.start.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.resources.Res
import com.resources.portada_image_runes
import com.shared.routes.RoutesStart
import org.jetbrains.compose.resources.painterResource

@Composable
fun StartScreen(navController: NavController) = Screen(navController)

@Composable
fun Screen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter,
        content = {
            Image(
                painter = painterResource(Res.drawable.portada_image_runes),
                contentDescription = "portada",
                contentScale = ContentScale.Crop,
                alignment = Alignment.TopCenter,
                alpha = 0.7f,
                modifier = Modifier.fillMaxSize()
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(colorScheme.background.copy(alpha = 0.7f)),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                content = {
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "Calabozos y Compuertas",
                        color = colorScheme.tertiary,
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                        style = MaterialTheme.typography.titleLarge
                    )
                    Spacer(modifier = Modifier.padding(5.dp))
                    Text(
                        text = "Domina desafíos épicos y perfecciona tus habilidades en las mazmorras de Calabozos y Compuertas.",
                        color = colorScheme.secondary,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Button(
                        onClick = {
                            navController.navigate(RoutesStart.Dashboard.route)
                        },
                        content = {
                            Text(
                                text = "Empezar la aventura",
                                color = Color.White,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.bodyMedium
                            )
                        },
                        shape = MaterialTheme.shapes.medium,
                        modifier = Modifier.fillMaxWidth(0.8f).height(50.dp),
                        colors = buttonColors(
                            containerColor = colorScheme.primary,
                            contentColor = Color.Black
                        )
                    )
                    Spacer(modifier = Modifier.padding(5.dp))
                    OutlinedButton(
                        onClick = {

                        },
                        content = {
                            Text(
                                text = "Únete a la aventura",
                                color = colorScheme.primary,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.bodyMedium
                            )
                        },
                        modifier = Modifier.fillMaxWidth(0.8f).height(50.dp),
                        shape = MaterialTheme.shapes.medium,
                        border = ButtonDefaults.outlinedButtonBorder.copy(
                            brush = Brush.linearGradient(
                                colors = listOf(
                                    colorScheme.primary,
                                    colorScheme.primary
                                )
                            )
                        ),
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = Color.White,
                            containerColor = Color.Transparent,
                        )
                    )
                    Spacer(modifier = Modifier.padding(20.dp))
                }
            )
        }
    )
}