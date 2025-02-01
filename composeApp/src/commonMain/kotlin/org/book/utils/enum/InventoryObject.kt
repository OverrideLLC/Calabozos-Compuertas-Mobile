package org.book.utils.enum

import androidx.compose.ui.graphics.Color
import book.composeapp.generated.resources.Res
import book.composeapp.generated.resources.change_history_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
import book.composeapp.generated.resources.circle_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
import book.composeapp.generated.resources.crop_7_5_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
import book.composeapp.generated.resources.hexagon_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
import book.composeapp.generated.resources.rectangle_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
import org.jetbrains.compose.resources.DrawableResource

enum class InventoryObject(
    val form: String,
    val image: DrawableResource,
    var selected: Boolean = false,
    val color: Color = Color.White,
    val value: Int = 0
) {
    Circular(
        form = "circular",
        image = Res.drawable.circle_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24,
        selected = false,
    ),
    Rectangular(
        form = "rectangular",
        image = Res.drawable.rectangle_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24,
        selected = false,
        value = 4
    ),
    Circular1(
        form = "circular",
        image = Res.drawable.circle_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24,
        selected = false,
    ),
    Square(
        form = "Square",
        image = Res.drawable.crop_7_5_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24,
        selected = false,
        value = 4
    ),
    Rectangular1(
        form = "rectangular",
        image = Res.drawable.rectangle_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24,
        selected = false,
        value = 4
    ),
    Triangle(
        form = "Triangle",
        image = Res.drawable.change_history_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24,
        selected = false,
        value = 3
    ),
    Square1(
        form = "Square",
        image = Res.drawable.crop_7_5_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24,
        selected = false,
        value = 4
    ),
    Hexagon(
        form = "Hexagon",
        image = Res.drawable.hexagon_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24,
        selected = false,
        value = 6
    ),
    Triangle1(
        form = "Triangle",
        image = Res.drawable.change_history_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24,
        selected = false,
        value = 3
    ),
    Hexagon1(
        form = "Hexagon",
        image = Res.drawable.hexagon_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24,
        selected = false,
        value = 6
    ),
}