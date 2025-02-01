package org.book.utils.data

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.book.utils.enum.InventoryObject
import org.book.utils.enum.RunesEnum
import kotlin.enums.EnumEntries

data class RuneState(
    val rune: EnumEntries<RunesEnum> = RunesEnum.entries,
    var indexActual: Int = 0,
    var runeActual: RunesEnum = rune[indexActual],
    var directionNavigation: Boolean = false,
    var expandedDp: Dp = 600.dp,
    var expandedBoolean: Boolean = false,
    val selectedItems: Set<InventoryObject> = emptySet(),
    var isSelectedRune: Boolean = false,
    var isClicked: Boolean = false,
    var comparison: String = "",
    var isPagComplete: Boolean = false,
)