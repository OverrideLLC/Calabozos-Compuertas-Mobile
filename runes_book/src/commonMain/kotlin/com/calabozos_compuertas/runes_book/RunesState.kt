package com.calabozos_compuertas.runes_book

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.shared.enum.ComparisonOperator
import com.shared.enum.InventoryObject
import com.shared.enum.RunesEnum
import kotlin.enums.EnumEntries

data class RunesState(
    val rune: EnumEntries<RunesEnum> = RunesEnum.entries,
    var indexActual: Int = 0,
    var runeActual: RunesEnum = rune[indexActual],
    var directionNavigation: Boolean = false,
    var expandedDp: Dp = 600.dp,
    var expandedBoolean: Boolean = false,
    val selectedItems: List<InventoryObject> = emptyList(),
    var isSelectedRune: Boolean = false,
    var isClicked: Boolean = false,
    var comparisonOperator: ComparisonOperator? = null,
    var isPagComplete: Boolean = false,
    var isLoading: Boolean = false,
)