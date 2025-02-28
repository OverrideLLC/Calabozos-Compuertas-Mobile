package org.book.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import book.composeapp.generated.resources.DRAGON_HUNTER
import book.composeapp.generated.resources.Raleway_Regular
import book.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.Font

@Composable
fun TitleThematic(): FontFamily = FontFamily(Font(Res.font.DRAGON_HUNTER))

@Composable
fun BodyRailway(): FontFamily = FontFamily(Font(Res.font.Raleway_Regular))