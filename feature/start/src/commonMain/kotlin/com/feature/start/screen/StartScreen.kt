package com.feature.start.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.feature.start.BackgroundAnimated
import com.resources.Ilustración99
import com.resources.Res
import com.shared.routes.RoutesStart
import org.jetbrains.compose.resources.painterResource

@Composable
fun StartScreen(navController: NavController) = Screen(navController)

@Composable
fun Screen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = BackgroundAnimated(
                    colorPrimary = Color(0xFFE7152D),
                    colorSecondary = Color(0xFFE78515)
                )
            ),
        contentAlignment = Alignment.TopCenter,
        content = {
            Image(
                painter = painterResource(Res.drawable.Ilustración99),
                contentDescription = "portada",
                alignment = Alignment.TopCenter,
                modifier = Modifier.fillMaxSize()
            )
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                content = {
                    Spacer(modifier = Modifier.weight(.4f))
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = Color(0xFFE7152D) // Color para "Calabozos y"
                                )
                            ) {
                                append("Calabozos y ")
                            }
                            withStyle(
                                style = SpanStyle(
                                    color = Color(0xFFE78515) // Color para "Compuertas"
                                )
                            ) {
                                append("Compuertas")
                            }
                        },
                        color = colorScheme.tertiary,
                        fontSize = 60.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                        style = MaterialTheme.typography.titleLarge
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Button(
                        onClick = {
                            navController.navigate(RoutesStart.Dashboard.route)
                        },
                        content = {
                            Text(
                                text = "Empezar la aventura",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.bodyMedium
                            )
                        },
                        shape = MaterialTheme.shapes.medium,
                        modifier = Modifier.fillMaxWidth(0.8f).height(50.dp),
                        colors = buttonColors(
                            containerColor = colorScheme.background,
                            contentColor = colorScheme.primary
                        )
                    )
                    Spacer(modifier = Modifier.padding(5.dp))
                    OutlinedButton(
                        onClick = {

                        },
                        content = {
                            Text(
                                text = "Únete a la aventura",
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
                                    colorScheme.background,
                                    colorScheme.background
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