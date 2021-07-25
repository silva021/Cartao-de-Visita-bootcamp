package com.silva021.cartaodevisita.domain.repository

import com.silva021.cartaodevisita.data.model.UserEntity
import com.silva021.cartaodevisita.domain.model.User

interface CardVisitRepository {
    suspend fun listAll() : List<UserEntity>

    fun save(user: UserEntity) : Long
}