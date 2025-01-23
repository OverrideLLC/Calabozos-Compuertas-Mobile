package org.book.utils.routes

sealed class RoutesStart(val route: String) {
    data object Start : RoutesStart("start")
}