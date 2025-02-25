package com.logic_book.utils.enums

import com.logic_book.utils.routes.RoutesLogic

enum class ImagesBook(
    val imageUrl: String,
    val routeActual: String,
    val routeNext: String,
    val routePrevious: String,
    val text: String
) {
    PAG1(
        imageUrl = "https://wbbnuyicfrlrpbrgdyqa.supabase.co/storage/v1/object/public/logic//pagina1_logic.png",
        routeActual = RoutesLogic.PAG1.route,
        routeNext = RoutesLogic.PAG2.route,
        routePrevious = RoutesLogic.PAG1.route,
        text = """
        La cueva lógica tenía muchas subcuevas malditas, 
        la cueva Wire era la primera de ellas... justo en la entrada.
        La cueva wire no permitía que la luz fuera hecha a 
        menos que la antorcha fuera tomada por el portador
    """.trimIndent()
    ),
    PAG2(
        imageUrl = "https://wbbnuyicfrlrpbrgdyqa.supabase.co/storage/v1/object/public/logic//pagina2_logic.png",
        routeActual = RoutesLogic.PAG2.route,
        routeNext = RoutesLogic.PAG3.route,
        routePrevious = RoutesLogic.PAG1.route,
        text = """
        La siguiente subcueva maldita era la cueva not, 
        donde el ojo led brillaba con una fuerza cegadora 
        y solo podia ser apagado si el portador de la antorcha sostenia con firmeza su antorcha
    """.trimIndent()
    ),
    PAG3(
        imageUrl = "https://wbbnuyicfrlrpbrgdyqa.supabase.co/storage/v1/object/public/logic//pagina3_logic.png",
        routeActual = RoutesLogic.PAG3.route,
        routeNext = RoutesLogic.PAG4.route,
        routePrevious = RoutesLogic.PAG2.route,
        text = """
        La cueva or era simple. 
        Almenos uno o ambos valientes 
        debia sostener la antorcha 
        para que la luz fuera creada.
    """.trimIndent()
    ),
    PAG4(
        imageUrl = "https://wbbnuyicfrlrpbrgdyqa.supabase.co/storage/v1/object/public/logic//pagina4_logic.png",
        routeActual = RoutesLogic.PAG4.route,
        routeNext = RoutesLogic.PAG5.route,
        routePrevious = RoutesLogic.PAG3.route,
        text = """
        La cueva and. 
        La maldicion de esta cueva 
        se rompia cuando 
        ambos valientes tomaban sus antorchas.
        Los dos caballeros 
        se acercaban cada vez mas a un destino fatal...
    """.trimIndent()
    ),
    PAG5(
        imageUrl = "https://wbbnuyicfrlrpbrgdyqa.supabase.co/storage/v1/object/public/logic//pagina5_logic.png",
        routeActual = RoutesLogic.PAG5.route,
        routeNext = RoutesLogic.PAG6.route,
        routePrevious = RoutesLogic.PAG4.route,
        text = """
        Cerca de su destino se encuentran la cueva xor.
        Los dos valientes 
        no podian sostener la antorcha al mismo tiempo
        para que la luz fuera creada
    """.trimIndent()
    ),
    PAG6(
        imageUrl = "https://wbbnuyicfrlrpbrgdyqa.supabase.co/storage/v1/object/public/logic//pagina6_logic.png",
        routeActual = RoutesLogic.PAG6.route,
        routeNext = RoutesLogic.PAG7.route,
        routePrevious = RoutesLogic.PAG5.route,
        text = """
        La ultima cueva... la cueva latch. Una cueva peligrosa y tamprosa, 
        pues los valientes debian de ser astutos con sus antorchas. 
        Un valiente es el que debera sostener la antorcha 
        para que la luz sea creada pero el otro debera soltarla hasta el final de la cueva.
    """.trimIndent()
    ),
    PAG7(
        imageUrl = "https://wbbnuyicfrlrpbrgdyqa.supabase.co/storage/v1/object/public/logic//pagina7_logic.png",
        routeActual = RoutesLogic.PAG7.route,
        routeNext = RoutesLogic.PAG7.route,
        routePrevious = RoutesLogic.PAG6.route,
        text =  """
        Atravesando la cueva latch, llegaron al tesoro mas valioso que se ha visto nunca, 
        pero pronto se dieron cuenta el porque no debieron olvidar sus espadas en aquella taverna...
    """.trimIndent()
    )
}