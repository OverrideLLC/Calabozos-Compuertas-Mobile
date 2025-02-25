package com.shared.routes

sealed class RoutesStart(val route: String) {
    data object Start : RoutesStart("start")
    data object LogicBook : RoutesStart("logic book")
    data object RunesBook : RoutesStart("runes book")
}