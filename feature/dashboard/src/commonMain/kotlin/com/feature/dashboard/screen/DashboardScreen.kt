package com.feature.dashboard.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.feature.dashboard.components.BackgroundAnimated
import com.feature.dashboard.components.Content
import com.feature.dashboard.components.TopBar
import com.feature.dashboard.utils.enums.ItemsDrawerEnum
import com.resources.Res
import com.resources.calabozoscompuertas_logo
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource

@Composable
fun DashboardScreen(navController: NavController) = Screen(navController)

@Composable
private fun Screen(navController: NavController) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = drawerState,
        scrimColor = colorScheme.scrim.copy(alpha = 0.5f),
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = colorScheme.surface,
                modifier = Modifier.width(300.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(colorScheme.surface)
                        .padding(horizontal = 16.dp, vertical = 24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(Res.drawable.calabozoscompuertas_logo),
                        contentDescription = "Calabozos y Compuertas",
                        modifier = Modifier.size(64.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
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
                        style = MaterialTheme.typography.titleLarge,
                        color = colorScheme.onPrimaryContainer,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                ItemsDrawerEnum.entries.forEachIndexed { index, item ->
                    ItemDrawerMenu(
                        item = item,
                        onClick = {
                            scope.launch { drawerState.close() }
                            if (navController.currentDestination?.route != item.route) {
                                navController.navigate(item.route) {
                                    popUpTo(navController.graph.startDestinationId) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        }
                    )
                    if (index < ItemsDrawerEnum.entries.size - 1) {
                        HorizontalDivider(
                            modifier = Modifier.padding(horizontal = 16.dp),
                            thickness = 1.dp,
                            color = colorScheme.outline.copy(alpha = 0.2f)
                        )
                    }
                }
            }
        },
        content = {
            Box {
                Scaffold(
                    topBar = {
                        TopBar(
                            onMenuClick = {
                                scope.launch { drawerState.open() }
                            }
                        )
                    },
                    content = { paddingValues -> Content(navController, paddingValues) },
                    containerColor = Color.Transparent,
                    modifier = Modifier
                        .background(
                            brush = BackgroundAnimated(
                                colorPrimary = Color(0xffffffff),
                                colorSecondary = Color(0xffdbdbdb)
                            )
                        )
                )
            }
        }
    )
}

@Composable
internal fun ItemDrawerMenu(
    item: ItemsDrawerEnum,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth() // Make row take full width
            .clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 12.dp), // Add padding to each item
        verticalAlignment = Alignment.CenterVertically, // Align icon and text vertically
        horizontalArrangement = Arrangement.Start // Align content to the start
    ) {
        Icon(
            painter = painterResource(item.icon),
            contentDescription = item.title,
            tint = colorScheme.primary, // Or colorScheme.onSurfaceVariant for less emphasis
            modifier = Modifier.size(24.dp) // Slightly smaller icon for better balance
        )
        Spacer(modifier = Modifier.width(16.dp)) // Space between icon and text
        Text(
            text = item.title,
            style = MaterialTheme.typography.bodyLarge, // Use bodyLarge for better readability
            color = colorScheme.onSurface, // Use onSurface for text on background/surface
            // fontSize = 18.sp // Adjust if needed, but rely on typography style first
        )
    }
}
