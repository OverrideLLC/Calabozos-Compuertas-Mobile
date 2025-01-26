package org.book.utils.enum

import book.composeapp.generated.resources.Res
import book.composeapp.generated.resources.pagina10_runes
import book.composeapp.generated.resources.pagina1_runes
import book.composeapp.generated.resources.pagina2_runes
import book.composeapp.generated.resources.pagina3_runes
import book.composeapp.generated.resources.pagina4_runes
import book.composeapp.generated.resources.pagina5_runes
import book.composeapp.generated.resources.pagina6_runes
import book.composeapp.generated.resources.pagina7_runes
import book.composeapp.generated.resources.pagina8_runes
import book.composeapp.generated.resources.pagina9_runes
import org.book.utils.data.DataRuneNavigation
import org.jetbrains.compose.resources.DrawableResource

enum class RunesEnum(
    val dataRuneNavigation: DataRuneNavigation,
    val texts: Map<String, String>,
    val image: DrawableResource,
    val rune: String?
) {
    Pag1(
        dataRuneNavigation = DataRuneNavigation(routeRuneActual = "pag1", routeRuneNext = "pag2"),
        texts = mapOf(
            "text1" to """
                En el reino de Itsu, se cuenta la historia de la gran hechizera programadora 
                y su pequeña aprendiz becaria que en su gran curiosidad por aprender 
                las antiguas lenguas arcanas sigue a su maestra que se incursionaba en
                una aventura peligrosa.
                Las montañas mas alla del reino clamaban el nombre de la hechizera y ella debia 
                responder al llamado...
            """.trimIndent()
        ),
        image = Res.drawable.pagina1_runes,
        rune = null
    ),
    Pag2(
        dataRuneNavigation = DataRuneNavigation(routeRuneActual = "pag2", routeRuneNext = "pag3"),
        texts = mapOf(
            "text1" to """
                Primero pasaron por el gran bosque de civilia donde vieron una
                runa de asigancion.
                La hechizera con gran sabiduria le explico a
                su pequeña becaria que esta runa tenia el la capacidad de darle
                poder a un hechizo vacio e incluso cambiar el poder de un hechizo.
            """.trimIndent()
        ),
        image = Res.drawable.pagina2_runes,
        rune = "="
    ),
    Pag3(
        dataRuneNavigation = DataRuneNavigation(routeRuneActual = "pag3", routeRuneNext = "pag4"),
        texts = mapOf(
            "text1" to """
                Explorando las heladas montañas de industrialis, ambas se toparon
                con una runa de comparacion, la runa de la igualdad.
                Esta runa es usada por hechizeros programadores para saber si un hechizo
                tiene el mismo poder que otro.
            """.trimIndent()
        ),
        image = Res.drawable.pagina3_runes,
        rune = "=="
    ),
    Pag4(
        dataRuneNavigation = DataRuneNavigation(routeRuneActual = "pag4", routeRuneNext = "pag5"),
        texts = mapOf(
            "text1" to """
                Dirigiendose a los puentes en el cielo de
                Mecatronicanto, vieron dos runas de comparacion.
                la runa menor y la runa mayor.
                La runa menor es utilizada por grandes hechizeros para conocer si el hechizo
                de su mano izquierda tiene menor poder que el hechizo de su mano derecha.
            """.trimIndent(),
            "text2" to """
                La runa mayor, funciona igual que la runa
                menor pero con una diferencia, la runa
                mayor te da a saber cuando el hechizo de tu mano izquierda tiene menor poder que el hechizo de
                tu mano derecha.
            """.trimIndent()
        ),
        image = Res.drawable.pagina4_runes,
        rune = "<>"
    ),
    Pag5(
        dataRuneNavigation = DataRuneNavigation(routeRuneActual = "pag5", routeRuneNext = "pag6"),
        texts = mapOf(
            "text1" to """
                Caminando por los valles de alimentaris, vieron de nuevo 
                una runa de comparacion. La runa mayor o igual.
                La hechizera explicando con certeza a la pequeña becaria 
                dice:
                "Veras, esa runa es
                maravillosa pues compara el poder de el
                hechizo de tu mano izquierda y de tu mano derecha, para saber cuando el poder es mas grande o si es igual"
            """.trimIndent(),
            "text2" to """
                Que confuso...
                Respondio la pequeña becaria.
            """.trimIndent()
        ),
        image = Res.drawable.pagina5_runes,
        rune = ">="
    ),
    Pag6(
        dataRuneNavigation = DataRuneNavigation(routeRuneActual = "pag6", routeRuneNext = "pag7"),
        texts = mapOf(
            "text1" to """
                Pasando por las montañas doradas de administralia admiraron la estatua que 
                lloraba oro, sosteniendo otra
                runa de comparacion. La runa menor o igual, que funciona de la misma
                manera que la runa mayor o igual con la diferencia de que esta runa compara el
                poder del hechizo de la mano izquierda con el de la mano derecha para saber cuando el poder 
                es menor o identico.
            """.trimIndent()
        ),
        image = Res.drawable.pagina6_runes,
        rune = "<="
    ),
    Pag7(
        dataRuneNavigation = DataRuneNavigation(routeRuneActual = "pag7", routeRuneNext = "pag8"),
        texts = mapOf(
            "text1" to """
                Llegando al arido desierto de mecanican, caminando por las orillas de las montañas
                contemplaron de nuevo otra runa de comparacion. La runa de la desigualdad.
                Esta runa se encarga de que el hechizero pueda saber que los hechizos de sus manos tienen poderes 
                diferentes, que no sean iguales.
            """.trimIndent()
        ),
        image = Res.drawable.pagina7_runes,
        rune = "!="
    ),
    Pag8(
        dataRuneNavigation = DataRuneNavigation(routeRuneActual = "pag8", routeRuneNext = "pag9"),
        texts = mapOf(
            "text1" to """
                En las cascadas eternas se econtraba algo especial, una runa logica. La runa OR
            """.trimIndent(),
            "text2" to """
                - Runa OR? 
                Dijo la pequeña becaria
            """.trimIndent(),
            "text3" to """
                - Asi es! La runa OR es especial ya 
                que requiere de hechizos con runas 
                de comparacion para crear hechizos 
                condicionales y teniendo dos
                hechizos condicionales la runa OR
                puede darle al hechizero el poder de
                decidir entre un hechizo condicional u
                otro.
                respondio la hechizera programadora.
            """.trimIndent(),
            "text4" to """
                - Muy confuso!"
                dijo la pequeña becaria
            """.trimIndent(),
        ),
        image = Res.drawable.pagina8_runes,
        rune = "||"
    ),
    Pag9(
        dataRuneNavigation = DataRuneNavigation(routeRuneActual = "pag9", routeRuneNext = "pag10"),
        texts = mapOf(
            "text1" to """
                Pasando por la ultima parte de su camino, se econtraron a un gigante
                que tenia a sus espaldas una runa logica. La runa AND. Una runa 
                que al igual que la runa OR necesitaba de hechizos condicionales
                para ser usada ya que permite al hechizero elegir dos hechizos 
                condicionales al mismo timepo.
            """.trimIndent()
        ),
        image = Res.drawable.pagina9_runes,
        rune = "&&"
    ),
    Pag10(
        dataRuneNavigation = DataRuneNavigation(routeRuneActual = "pag10", routeRuneNext = "pag10"),
        texts = mapOf(
            "text1" to """
                Llegando porfin a su destino, la hechizera descubrio
                quien le hacia el gran llamado...
            """.trimIndent()
        ),
        image = Res.drawable.pagina10_runes,
        rune = null
    );
}