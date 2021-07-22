package com.silva021.cartaodevisita.di

import com.silva021.cartaodevisita.data.database.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val applicationModule = module {
    single { AppDatabase.createDatabase(androidContext()) }
}