package org.book

import android.app.Application
import org.book.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.component.KoinComponent
import org.koin.core.logger.Level

class AppMain : Application(), KoinComponent {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@AppMain)
            printLogger()
            modules()
        }
    }
}