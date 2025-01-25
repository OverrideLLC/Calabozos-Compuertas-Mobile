package org.book.utils.routes

sealed class RoutesRunes(val route: String) {
    data object Pag1 : RoutesRunes("pag1")
    data object Pag2 : RoutesRunes("pag2")
    data object Pag3 : RoutesRunes("pag3")
    data object Pag4 : RoutesRunes("pag4")
    data object Pag5 : RoutesRunes("pag5")
    data object Pag6 : RoutesRunes("pag6")
    data object Pag7 : RoutesRunes("pag7")
    data object Pag8 : RoutesRunes("pag8")
    data object Pag9 : RoutesRunes("pag9")
}