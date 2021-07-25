package com.silva021.cartaodevisita.ui.cardvisit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.silva021.cartaodevisita.domain.model.User
import com.silva021.cartaodevisita.domain.usecase.SendCardVisitUseCase
import com.silva021.cartaodevisita.utils.mapper.UserMapper
import kotlinx.coroutines.launch

class CardVisitViewModel(
    private val sendCardVisitUseCase: SendCardVisitUseCase,
    private val mapper: UserMapper,
) : ViewModel() {
    private val _isAdded = MutableLiveData<Boolean>()
    val response = _isAdded as LiveData<Boolean>

    fun insertNewCardVisit(user: User) {
        viewModelScope.launch {
            _isAdded.value = sendCardVisitUseCase(mapper.userModelToUserEntity(user))
        }

    }
}