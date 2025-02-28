package com.logic_book.ui

import com.logic_book.utils.enums.ImagesBook
import com.logic_book.utils.enums.ImagesLogicGates
import kotlin.enums.EnumEntries

data class LogicGatesData(
    var logicGates: List<ImagesBook> = ImagesBook.entries.toList(),
    var logicGatesExpanded: List<ImagesLogicGates> = ImagesLogicGates.entries.toList(),
    var isExpanded: Boolean = false,
    var activeWire: Boolean = false,
    var activeNot: Boolean = false,
    var activeOr: Boolean = false,
    var activeAnd: Boolean = false,
    var activeXor: Boolean = false,
    var activeLatch: Boolean = false,
    var illumiGate: Boolean = false,
)