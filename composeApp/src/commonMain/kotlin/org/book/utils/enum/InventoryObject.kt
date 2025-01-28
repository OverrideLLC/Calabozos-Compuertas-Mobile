package org.book.utils.enum

import book.composeapp.generated.resources.Res
import book.composeapp.generated.resources.volume_off_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
import org.jetbrains.compose.resources.DrawableResource

enum class InventoryObject(
    val form: String,
    val vertices: Int,
    val image: DrawableResource
){
    Circular(
        form = "circular",
        vertices = 0,
        image = Res.drawable.volume_off_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
    ),
    Rectangular(
        form = "rectangular",
        vertices = 4,
        image = Res.drawable.volume_off_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
    ),
    Square(
        form = "Square",
        vertices = 4,
        image = Res.drawable.volume_off_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
    ),
    Triangle(
        form = "Triangle",
        vertices = 3,
        image = Res.drawable.volume_off_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
    ),
    Hexagon(
        form = "Hexagon",
        vertices = 6,
        image = Res.drawable.volume_off_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
    ),
    Octagon(
        form = "Octagon",
        vertices = 8,
        image = Res.drawable.volume_off_24dp_E8EAED_FILL0_wght400_GRAD0_opsz24
    ),
}