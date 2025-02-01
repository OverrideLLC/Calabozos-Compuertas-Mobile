package org.book.utils.enum

import book.composeapp.generated.resources.Res
import book.composeapp.generated.resources.pagina10_image_runes
import book.composeapp.generated.resources.pagina1_image_runes
import book.composeapp.generated.resources.pagina2_image_runes
import book.composeapp.generated.resources.pagina3_image_runes
import book.composeapp.generated.resources.pagina4_image_runes
import book.composeapp.generated.resources.pagina5_image_runes
import book.composeapp.generated.resources.pagina6_image_runes
import book.composeapp.generated.resources.pagina7_image_runes
import book.composeapp.generated.resources.pagina8_image_runes
import book.composeapp.generated.resources.pagina9_image_runes
import org.book.utils.data.DataRuneNavigation
import org.book.utils.routes.RoutesRunes
import org.jetbrains.compose.resources.DrawableResource

enum class RunesEnum(
    val dataRuneNavigation: DataRuneNavigation,
    val texts: Map<String, String>,
    val image: DrawableResource,
    val rune: String?,
    val requiredComparisons: Int = 1
) {
    Pag1(
        dataRuneNavigation = DataRuneNavigation(
            routeRuneActual = RoutesRunes.Pag1.route,
            routeRuneNext = RoutesRunes.Pag2.route,
            routeRunePrevious = RoutesRunes.Pag1.route
        ),
        texts = mapOf(
            "text1" to """
                En el reino de Itsu se cuenta la historia de la gran hechizera programadora y su pequeña
                aprendiz, quien, movida por una insaciable curiosidad por dominar las antiguas lenguas 
                arcanas, sigue a su maestra en una peligrosa aventura. Las montañas más allá del reino 
                clamaban el nombre de la hechizera, y ella debía responder al llamado...
            """.trimIndent()
        ),
        image = Res.drawable.pagina1_image_runes,
        rune = null
    ),
    Pag2(
        dataRuneNavigation = DataRuneNavigation(
            routeRuneActual = RoutesRunes.Pag2.route,
            routeRuneNext = RoutesRunes.Pag3.route,
            routeRunePrevious = RoutesRunes.Pag1.route
        ),
        texts = mapOf(
            "text1" to """
                Primero pasaron por el gran bosque de civilia donde vieron una
                runa de asigancion.
                La hechizera con gran sabiduria le explico a
                su pequeña becaria que esta runa tenia el la capacidad de darle
                poder a un hechizo vacio e incluso cambiar el poder de un hechizo.
                Asi que le asigno objetos varios para que pueda usarlos en su travesia
                y completar las pruebas que le vendrian.
            """.trimIndent()
        ),
        image = Res.drawable.pagina2_image_runes,
        rune = "="
    ),
    Pag3(
        dataRuneNavigation = DataRuneNavigation(
            routeRuneActual = RoutesRunes.Pag3.route,
            routeRuneNext = RoutesRunes.Pag4.route,
            routeRunePrevious = RoutesRunes.Pag2.route
        ),
        texts = mapOf(
            "text1" to """
                Explorando las heladas montañas de industrialis, ambas se toparon
                con una runa de comparacion, la runa de la igualdad.
                Esta runa es usada por hechizeros programadores para saber si un hechizo
                tiene el mismo poder que otro.
            """.trimIndent()
        ),
        image = Res.drawable.pagina3_image_runes,
        rune = "=="
    ),
    Pag4(
        dataRuneNavigation = DataRuneNavigation(
            routeRuneActual = RoutesRunes.Pag4.route,
            routeRuneNext = RoutesRunes.Pag5.route,
            routeRunePrevious = RoutesRunes.Pag3.route
        ),
        texts = mapOf(
            "text1" to """
                Dirigiendose a los puentes en el cielo de
                Mecatronicanto, vieron dos runas de comparacion.
                la runa menor y la runa mayor.
                La runa menor es utilizada por grandes hechizeros para conocer si el hechizo
                de su mano izquierda tiene menor poder que el hechizo de su mano derecha.
                
                La runa mayor, funciona igual que la runa
                menor pero con una diferencia, la runa
                mayor te da a saber cuando el hechizo de 
                tu mano izquierda tiene menor poder que 
                el hechizo de tu mano derecha.
            """.trimIndent(),
        ),
        image = Res.drawable.pagina4_image_runes,
        rune = "<>",
        requiredComparisons = 2
    ),
    Pag5(
        dataRuneNavigation = DataRuneNavigation(
            routeRuneActual = RoutesRunes.Pag5.route,
            routeRuneNext = RoutesRunes.Pag6.route,
            routeRunePrevious = RoutesRunes.Pag4.route
        ),
        texts = mapOf(
            "text1" to """
                Caminando por los valles de alimentaris, vieron de nuevo 
                una runa de comparacion. La runa mayor o igual.
                La hechizera explicando con certeza a la pequeña becaria 
                dice:
                "Veras, esa runa es
                maravillosa pues compara el poder de el
                hechizo de tu mano izquierda y de tu mano derecha, 
                para saber cuando el poder es mas grande o si es igual"
                
                
                Que confuso...
                Respondio la pequeña becaria.
            """.trimIndent(),
        ),
        image = Res.drawable.pagina5_image_runes,
        rune = ">="
    ),
    Pag6(
        dataRuneNavigation = DataRuneNavigation(
            routeRuneActual = RoutesRunes.Pag6.route,
            routeRuneNext = RoutesRunes.Pag7.route,
            routeRunePrevious = RoutesRunes.Pag5.route
        ),
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
        image = Res.drawable.pagina6_image_runes,
        rune = "<="
    ),
    Pag7(
        dataRuneNavigation = DataRuneNavigation(
            routeRuneActual = RoutesRunes.Pag7.route,
            routeRuneNext = RoutesRunes.Pag8.route,
            routeRunePrevious = RoutesRunes.Pag6.route
        ),
        texts = mapOf(
            "text1" to """
                Llegando al arido desierto de mecanican, caminando por las orillas de las montañas
                contemplaron de nuevo otra runa de comparacion. La runa de la desigualdad.
                Esta runa se encarga de que el hechizero pueda saber que los hechizos de sus manos tienen poderes 
                diferentes, que no sean iguales.
            """.trimIndent()
        ),
        image = Res.drawable.pagina7_image_runes,
        rune = "!="
    ),
    Pag8(
        dataRuneNavigation = DataRuneNavigation(
            routeRuneActual = RoutesRunes.Pag8.route,
            routeRuneNext = RoutesRunes.Pag9.route,
            routeRunePrevious = RoutesRunes.Pag7.route
        ),
        texts = mapOf(
            "text1" to """
                En las cascadas eternas se econtraba algo especial, una runa logica. La runa OR.
                
                - Runa OR? 
                Dijo la pequeña becaria
                
                - Asi es! La runa OR es especial ya que requiere de hechizos con runas 
                de comparacion para crear hechizos condicionales y teniendo dos
                hechizos condicionales la runa OR puede darle al hechizero el poder de
                decidir entre un hechizo condicional u otro.
                respondio la hechizera programadora.
                
                - Muy confuso!"
                dijo la pequeña becaria
            """.trimIndent(),
        ),
        image = Res.drawable.pagina8_image_runes,
        rune = "||"
    ),
    Pag9(
        dataRuneNavigation = DataRuneNavigation(
            routeRuneActual = RoutesRunes.Pag9.route,
            routeRuneNext = RoutesRunes.Pag10.route,
            routeRunePrevious = RoutesRunes.Pag8.route
        ),
        texts = mapOf(
            "text1" to """
                Pasando por la ultima parte de su camino, se econtraron a un gigante
                que tenia a sus espaldas una runa logica. La runa AND. Una runa 
                que al igual que la runa OR necesitaba de hechizos condicionales
                para ser usada ya que permite al hechizero elegir dos hechizos 
                condicionales al mismo timepo.
            """.trimIndent()
        ),
        image = Res.drawable.pagina9_image_runes,
        rune = "&&"
    ),
    Pag10(
        dataRuneNavigation = DataRuneNavigation(
            routeRuneActual = RoutesRunes.Pag10.route,
            routeRuneNext = RoutesRunes.Pag10.route,
            routeRunePrevious = RoutesRunes.Pag9.route
        ),
        texts = mapOf(
            "text1" to """
                Llegando porfin a su destino, la hechizera descubrio
                quien le hacia el gran llamado...
            """.trimIndent()
        ),
        image = Res.drawable.pagina10_image_runes,
        rune = null
    );
}