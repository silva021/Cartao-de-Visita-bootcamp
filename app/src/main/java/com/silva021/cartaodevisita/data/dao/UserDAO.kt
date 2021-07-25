package com.silva021.cartaodevisita.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.silva021.cartaodevisita.data.model.UserEntity
import com.silva021.cartaodevisita.domain.model.User

@Dao
interface UserDAO {
    @Query("SELECT * FROM t_User")
    fun getAll(): List<UserEntity>

    @Insert
    fun insertUser(user: UserEntity) :Long
}