package org.book.utils

import android.content.Context

actual class ContextProvider(val applicationContext: Context) {
    actual val context: Any = applicationContext
}