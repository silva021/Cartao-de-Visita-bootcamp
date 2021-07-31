package com.silva021.cartaodevisita.data.repository

import com.silva021.cartaodevisita.data.dao.UserDAO
import com.silva021.cartaodevisita.data.model.UserEntity
import com.silva021.cartaodevisita.domain.repository.CardVisitRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class AppCardVisitRepository(private val dao: UserDAO) : CardVisitRepository {
    override suspend fun listAll(): List<UserEntity> = dao.getAll()

    override fun save(user: UserEntity): Long =
        runBlocking {
            dao.insertUser(user = user)
        }
}