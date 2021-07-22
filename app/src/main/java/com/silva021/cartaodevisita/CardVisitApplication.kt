package com.silva021.cartaodevisita

import android.app.Application
import android.util.Log
import androidx.room.Room
import com.silva021.cartaodevisita.data.database.AppDatabase
import com.silva021.cartaodevisita.di.applicationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CardVisitApplication : Application() {
    companion object {
        var database: AppDatabase? = null
    }
    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(this, AppDatabase::class.java, "cardvisit-database").allowMainThreadQueries().build()

        startKoin {
            androidContext(this@CardVisitApplication)
            listOf(applicationModule)
        }
        Log.d("debug-app", "Koin iniciado")
    }
}