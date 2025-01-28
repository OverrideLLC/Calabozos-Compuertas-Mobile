package org.book.utils.data

import org.book.utils.enum.InventoryObject
import org.book.utils.enum.RunesEnum
import kotlin.enums.EnumEntries

data class RuneState(
    val rune: EnumEntries<RunesEnum> = RunesEnum.entries,
    var indexActual: Int = 0,
    var directionNavigation: Boolean = false,
    var runeSelection: InventoryObject? = null
)