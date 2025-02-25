package com.shared.enum

enum class ComparisonOperator(val symbol: String, val icon: String) {
    EQUAL("==", "https://wbbnuyicfrlrpbrgdyqa.supabase.co/storage/v1/object/public/runes//RUNAIGUALDAD2.png"),
    NOT_EQUAL("!=", "https://wbbnuyicfrlrpbrgdyqa.supabase.co/storage/v1/object/public/runes//RUNADESIGUALDAD.png"),
    LESS_THAN("<", "https://wbbnuyicfrlrpbrgdyqa.supabase.co/storage/v1/object/public/runes//RUNAMAYORMENOR.png"),
    GREATER_THAN(">", "https://wbbnuyicfrlrpbrgdyqa.supabase.co/storage/v1/object/public/runes//RUNAMAYORMENOR2.png"),
    LESS_EQUAL("<=", "https://wbbnuyicfrlrpbrgdyqa.supabase.co/storage/v1/object/public/runes//RUNAMENORIGUAL.png"),
    GREATER_EQUAL(">=", "https://wbbnuyicfrlrpbrgdyqa.supabase.co/storage/v1/object/public/runes//RUNAMAYORIGUAL.png"),
    OR("||", "https://wbbnuyicfrlrpbrgdyqa.supabase.co/storage/v1/object/public/runes//RUNAOR.png"),
    AND("&&", "https://wbbnuyicfrlrpbrgdyqa.supabase.co/storage/v1/object/public/runes//RUNAAND.png")
}
