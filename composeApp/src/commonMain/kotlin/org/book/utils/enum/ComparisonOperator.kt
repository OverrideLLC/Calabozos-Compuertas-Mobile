package org.book.utils.enum

import book.composeapp.generated.resources.RUNAAND
import book.composeapp.generated.resources.RUNADESIGUALDAD
import book.composeapp.generated.resources.RUNAIGUALDAD
import book.composeapp.generated.resources.RUNAMAYORIGUAL
import book.composeapp.generated.resources.RUNAMAYORMENOR
import book.composeapp.generated.resources.RUNAMAYORMENOR2
import book.composeapp.generated.resources.RUNAMENORIGUAL
import book.composeapp.generated.resources.RUNAOR
import book.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.DrawableResource

enum class ComparisonOperator(val symbol: String, val icon: DrawableResource) {
    EQUAL("==", Res.drawable.RUNAIGUALDAD),
    NOT_EQUAL("!=", Res.drawable.RUNADESIGUALDAD),
    LESS_THAN("<", Res.drawable.RUNAMAYORMENOR),
    GREATER_THAN(">", Res.drawable.RUNAMAYORMENOR2),
    LESS_EQUAL("<=", Res.drawable.RUNAMENORIGUAL),
    GREATER_EQUAL(">=", Res.drawable.RUNAMAYORIGUAL),
    OR("||", Res.drawable.RUNAAND),
    AND("&&", Res.drawable.RUNAOR)
}
