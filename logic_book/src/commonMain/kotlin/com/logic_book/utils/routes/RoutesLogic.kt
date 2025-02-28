package com.logic_book.utils.routes

sealed class RoutesLogic(val route: String) {
    object PAG1 : RoutesLogic("PAG1")
    object PAG2 : RoutesLogic("PAG2")
    object PAG3 : RoutesLogic("PAG3")
    object PAG4 : RoutesLogic("PAG4")
    object PAG5 : RoutesLogic("PAG5")
    object PAG6 : RoutesLogic("PAG6")
    object PAG7 : RoutesLogic("PAG7")
}