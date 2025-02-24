package com.logic_book.ui

import com.logic_book.utils.enums.ImagesBook
import kotlin.enums.EnumEntries

data class LogicGatesData(
    var logicGates: EnumEntries<ImagesBook> = ImagesBook.entries,
    var logicGatesActual: ImagesBook = logicGates[0]
)