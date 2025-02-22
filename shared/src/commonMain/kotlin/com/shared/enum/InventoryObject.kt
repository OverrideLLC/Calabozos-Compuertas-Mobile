package com.shared.enum

import androidx.compose.ui.graphics.Color

enum class InventoryObject(
    val imageUrl: String,
    var selected: Boolean = false,
    val value: Int
) {
    NUMBER0(
        imageUrl = "https://wbbnuyicfrlrpbrgdyqa.supabase.co/storage/v1/object/public/runes//NUMERO0.png",
        selected = false,
        value = 0
    ),
    NUMBER1(
        imageUrl = "https://wbbnuyicfrlrpbrgdyqa.supabase.co/storage/v1/object/public/runes//NUMERO1.png",
        selected = false,
        value = 1
    ),
    NUMBER2(
        imageUrl = "https://wbbnuyicfrlrpbrgdyqa.supabase.co/storage/v1/object/public/runes//NUMERO2.png",
        selected = false,
        value = 2
    ),
    NUMBER3(
        imageUrl = "https://wbbnuyicfrlrpbrgdyqa.supabase.co/storage/v1/object/public/runes//NUMERO3.png",
        selected = false,
        value = 3
    ),
    NUMBER4(
        imageUrl = "https://wbbnuyicfrlrpbrgdyqa.supabase.co/storage/v1/object/public/runes//NUMERO4.png",
        selected = false,
        value = 4
    ),
    NUMBER5(
        imageUrl = "https://wbbnuyicfrlrpbrgdyqa.supabase.co/storage/v1/object/public/runes//NUMERO5.png",
        selected = false,
        value = 5
    ),
    NUMBER6(
        imageUrl = "https://wbbnuyicfrlrpbrgdyqa.supabase.co/storage/v1/object/public/runes//NUMERO6.png",
        selected = false,
        value = 6
    ),
    NUMBER7(
        imageUrl = "https://wbbnuyicfrlrpbrgdyqa.supabase.co/storage/v1/object/public/runes//NUMERO7.png",
        selected = false,
        value = 7
    ),
    NUMBER8(
        imageUrl = "https://wbbnuyicfrlrpbrgdyqa.supabase.co/storage/v1/object/public/runes//NUMERO8.png",
        selected = false,
        value = 8
    ),
    NUMBER9(
        imageUrl = "https://wbbnuyicfrlrpbrgdyqa.supabase.co/storage/v1/object/public/runes//NUMERO9.png",
        selected = false,
        value = 9
    ),
}