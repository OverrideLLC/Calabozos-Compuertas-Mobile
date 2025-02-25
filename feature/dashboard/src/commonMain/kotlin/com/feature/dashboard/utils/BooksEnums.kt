package com.feature.dashboard.utils

import androidx.compose.ui.graphics.Color
import com.resources.Res
import com.resources.portada_image_runes
import com.resources.portada_logic
import com.resources.portada_runes
import com.shared.routes.RoutesStart
import org.jetbrains.compose.resources.DrawableResource

enum class BooksEnums(
    val title: String,
    val description: String,
    val image: DrawableResource,
    val routes: String,
    val color: Color
) {
    RUNE_BOOK(
        title = "El viaje de las grandes runas.",
        description = "",
        image = Res.drawable.portada_runes,
        routes = RoutesStart.RunesBook.route,
        color = Color(0xFF3c5b6b)
    ),
    LOGIC_BOOK(
        title = "La maldicion de la cueva logica.",
        description = "",
        image = Res.drawable.portada_logic,
        routes = RoutesStart.LogicBook.route,
        color = Color(0xFF0d0809)
    )
}