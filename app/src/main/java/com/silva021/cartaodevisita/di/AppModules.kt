package com.silva021.cartaodevisita.di

import android.app.Application
import androidx.room.Room
import com.silva021.cartaodevisita.data.dao.UserDAO
import com.silva021.cartaodevisita.data.database.CardVisitDatabase
import com.silva021.cartaodevisita.data.repository.AppCardVisitRepository
import com.silva021.cartaodevisita.domain.repository.CardVisitRepository
import com.silva021.cartaodevisita.domain.usecase.GetListCardVisit
import com.silva021.cartaodevisita.domain.usecase.GetListCardVisitUseCase
import com.silva021.cartaodevisita.domain.usecase.SendCardVisit
import com.silva021.cartaodevisita.domain.usecase.SendCardVisitUseCase
import com.silva021.cartaodevisita.ui.cardvisit.CardVisitViewModel
import com.silva021.cartaodevisita.ui.home.HomeViewModel
import com.silva021.cartaodevisita.utils.mapper.UserMapper
import com.silva021.cartaodevisita.utils.mapper.UserMapperImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val applicationModule = module {
    fun provideDatabase(application: Application): CardVisitDatabase {
        return Room.databaseBuilder(
            application,
            CardVisitDatabase::class.java,
            "cardvisit-database")
            .allowMainThreadQueries()
            .build()
    }

    fun provideCountriesDao(database: CardVisitDatabase): UserDAO {
        return database.userDAO()
    }

    single { provideDatabase(androidApplication()) }
    single { provideCountriesDao(get()) }
    factory<UserMapper> { UserMapperImpl() }
    single<CardVisitRepository> { AppCardVisitRepository(dao = get()) }
    single<GetListCardVisitUseCase> { GetListCardVisit(repository = get()) }
    single { HomeViewModel(getListCardVisitUseCase = get(), get()) }


    single<SendCardVisitUseCase> { SendCardVisit(repository = get()) }
    single { CardVisitViewModel(sendCardVisitUseCase = get(), mapper = get()) }
}