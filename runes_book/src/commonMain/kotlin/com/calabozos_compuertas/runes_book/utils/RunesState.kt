package com.calabozos_compuertas.runes_book.utils

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.shared.enum.ComparisonOperator
import com.shared.enum.InventoryObject
import com.shared.enum.RunesEnum
import kotlin.enums.EnumEntries

data class RunesState(
    val rune: EnumEntries<RunesEnum> = RunesEnum.entries,
    var runeActual: RunesEnum = rune[0],
    var expandedDp: Dp = 600.dp,
    var expandedBoolean: Boolean = false,
    val selectedItems: List<InventoryObject> = emptyList(),
    var isSelectedRune: Boolean = false,
    var isClicked: Boolean = false,
    var isExpandedInventory: Boolean = false,
    var comparisonOperator: ComparisonOperator? = null,
)