package com.logic_book.utils.enums

import com.logic_book.utils.routes.RoutesLogic

enum class ImagesBook(
    val imageUrl: String,
    val routeActual: String,
    val routeNext: String,
    val routePrevious: String,
) {
    PAG1(
        imageUrl = "https://wbbnuyicfrlrpbrgdyqa.supabase.co/storage/v1/object/public/logic//pagina1_logic.png",
        routeActual = RoutesLogic.PAG1.route,
        routeNext = RoutesLogic.PAG2.route,
        routePrevious = RoutesLogic.PAG1.route
    ),
    PAG2(
        imageUrl = "https://wbbnuyicfrlrpbrgdyqa.supabase.co/storage/v1/object/public/logic//pagina2_logic.png",
        routeActual = RoutesLogic.PAG2.route,
        routeNext = RoutesLogic.PAG3.route,
        routePrevious = RoutesLogic.PAG1.route
    ),
    PAG3(
        imageUrl = "https://wbbnuyicfrlrpbrgdyqa.supabase.co/storage/v1/object/public/logic//pagina3_logic.png",
        routeActual = RoutesLogic.PAG3.route,
        routeNext = RoutesLogic.PAG4.route,
        routePrevious = RoutesLogic.PAG2.route
    ),
    PAG4(
        imageUrl = "https://wbbnuyicfrlrpbrgdyqa.supabase.co/storage/v1/object/public/logic//pagina4_logic.png",
        routeActual = RoutesLogic.PAG4.route,
        routeNext = RoutesLogic.PAG5.route,
        routePrevious = RoutesLogic.PAG3.route
    ),
    PAG5(
        imageUrl = "https://wbbnuyicfrlrpbrgdyqa.supabase.co/storage/v1/object/public/logic//pagina5_logic.png",
        routeActual = RoutesLogic.PAG5.route,
        routeNext = RoutesLogic.PAG6.route,
        routePrevious = RoutesLogic.PAG4.route
    ),
    PAG6(
        imageUrl = "https://wbbnuyicfrlrpbrgdyqa.supabase.co/storage/v1/object/public/logic//pagina6_logic.png",
        routeActual = RoutesLogic.PAG6.route,
        routeNext = RoutesLogic.PAG7.route,
        routePrevious = RoutesLogic.PAG5.route
    ),
    PAG7(
        imageUrl = "https://wbbnuyicfrlrpbrgdyqa.supabase.co/storage/v1/object/public/logic//pagina7_logic.png",
        routeActual = RoutesLogic.PAG7.route,
        routeNext = RoutesLogic.PAG7.route,
        routePrevious = RoutesLogic.PAG6.route
    )
}