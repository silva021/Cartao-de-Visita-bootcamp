package com.silva021.cartaodevisita.domain.usecase

import com.silva021.cartaodevisita.data.model.UserEntity
import com.silva021.cartaodevisita.domain.repository.CardVisitRepository
import java.lang.Exception


interface SendCardVisitUseCase {
    operator fun invoke(user: UserEntity): Boolean
}

class SendCardVisit(private val repository: CardVisitRepository) : SendCardVisitUseCase {
    override fun invoke(user: UserEntity): Boolean = try {
        repository.save(user = user)
        true
    } catch (e: Exception) {
        false
    }
}