package com.silva021.cartaodevisita

import android.app.Application
import android.util.Log
import com.silva021.cartaodevisita.di.applicationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CardVisitApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@CardVisitApplication)
            modules(applicationModule)
        }
        Log.d("debug-app", "Koin iniciado")
    }
}