package com.feature.dashboard.utils.enums

import androidx.compose.ui.graphics.Color
import com.resources.Res
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
        description = """
            
        """.trimIndent(),
        image = Res.drawable.portada_runes,
        routes = RoutesStart.RunesBook.route,
        color = Color(0xFF3c5b6b)
    ),
    LOGIC_BOOK(
        title = "La maldicion de la cueva logica.",
        description = """
            Sigue a los aventureros a través de la "Cueva Lógica", enfrentando subcuevas malditas. 
            Superan desafíos usando antorchas para crear luz según reglas específicas.
        """.trimIndent(),
        image = Res.drawable.portada_logic,
        routes = RoutesStart.LogicBook.route,
        color = Color(0xFF0d0809)
    )
}