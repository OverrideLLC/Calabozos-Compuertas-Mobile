package org.book.utils.enum

import androidx.compose.ui.graphics.Color
import book.composeapp.generated.resources.NUMERO0
import book.composeapp.generated.resources.NUMERO1
import book.composeapp.generated.resources.NUMERO2
import book.composeapp.generated.resources.NUMERO3
import book.composeapp.generated.resources.NUMERO4
import book.composeapp.generated.resources.NUMERO5
import book.composeapp.generated.resources.NUMERO6
import book.composeapp.generated.resources.NUMERO7
import book.composeapp.generated.resources.NUMERO8
import book.composeapp.generated.resources.NUMERO9
import book.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.DrawableResource

enum class InventoryObject(
    val form: String,
    val image: DrawableResource,
    var selected: Boolean = false,
    val color: Color = Color.White,
    val value: Int = 0
) {
    CeroSecond(
        form = "cero",
        image = Res.drawable.NUMERO0,
        selected = false,
        value = 0
    ),
    Cero(
        form = "cero",
        image = Res.drawable.NUMERO0,
        selected = false,
        value = 0
    ),
    Uno(
        form = "uno",
        image = Res.drawable.NUMERO1,
        selected = false,
        value = 1
    ),
    Dos(
        form = "dos",
        image = Res.drawable.NUMERO2,
        selected = false,
        value = 2
    ),
    Tres(
        form = "tres",
        image = Res.drawable.NUMERO3,
        selected = false,
        value = 3
    ),
    Cuatro(
        form = "cuatro",
        image = Res.drawable.NUMERO4,
        selected = false,
        value = 4
    ),
    Cinco(
        form = "cinco",
        image = Res.drawable.NUMERO5,
        selected = false,
        value = 5
    ),
    Seis(
        form = "seis",
        image = Res.drawable.NUMERO6,
        selected = false,
        value = 6
    ),
    Siete(
        form = "siete",
        image = Res.drawable.NUMERO7,
        selected = false,
        value = 7
    ),
    Ocho(
        form = "ocho",
        image = Res.drawable.NUMERO8,
        selected = false,
        value = 8
    ),
    Nueve(
        form = "NINE",
        image = Res.drawable.NUMERO9,
        selected = false,
        value = 9
    ),
    UnoSecond(
        form = "uno",
        image = Res.drawable.NUMERO1,
        selected = false,
        value = 1
    ),
    DosSecond(
        form = "dos",
        image = Res.drawable.NUMERO2,
        selected = false,
        value = 2
    ),
    TresSecond(
        form = "tres",
        image = Res.drawable.NUMERO3,
        selected = false,
        value = 3
    ),
    CuatroSecond(
        form = "cuatro",
        image = Res.drawable.NUMERO4,
        selected = false,
        value = 4
    ),
    CincoSecond(
        form = "cinco",
        image = Res.drawable.NUMERO5,
        selected = false,
        value = 5
    ),
    SeisSecond(
        form = "seis",
        image = Res.drawable.NUMERO6,
        selected = false,
        value = 6
    ),
    SieteSecond(
        form = "siete",
        image = Res.drawable.NUMERO7,
        selected = false,
        value = 7
    ),
    OchoSecond(
        form = "ocho",
        image = Res.drawable.NUMERO8,
        selected = false,
        value = 8
    ),
    NueveSecond(
        form = "NINE",
        image = Res.drawable.NUMERO9,
        selected = false,
        value = 9
    )

}