package com.silva021.cartaodevisita.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.silva021.cartaodevisita.data.dao.UserDAO
import com.silva021.cartaodevisita.data.model.UserEntity
import org.koin.android.ext.koin.androidContext

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDAO(): UserDAO

    companion object {
        fun createDatabase(context: Context) =
            Room.databaseBuilder(context,
                AppDatabase::class.java, "cardvisit-database")
                .build()
    }
}