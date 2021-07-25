package com.silva021.cartaodevisita.domain.usecase

import com.silva021.cartaodevisita.data.model.UserEntity
import com.silva021.cartaodevisita.domain.repository.CardVisitRepository

interface GetListCardVisitUseCase {
    suspend operator fun invoke(): List<UserEntity>
}

class GetListCardVisit(private val repository: CardVisitRepository) : GetListCardVisitUseCase {
    override suspend fun invoke(): List<UserEntity> = repository.listAll()
}