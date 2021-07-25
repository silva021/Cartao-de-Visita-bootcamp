package com.silva021.cartaodevisita.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.silva021.cartaodevisita.data.model.UserEntity
import com.silva021.cartaodevisita.domain.model.User
import com.silva021.cartaodevisita.domain.usecase.GetListCardVisitUseCase
import com.silva021.cartaodevisita.utils.mapper.UserMapper
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getListCardVisitUseCase: GetListCardVisitUseCase,
    private val mapper: UserMapper
) : ViewModel() {
    private val _listCardVisit = MutableLiveData<List<User>>()
    val listCardVisit = _listCardVisit as LiveData<List<User>>

    fun getListCardVisit() {
        viewModelScope.launch {
            val getListCardVisitUseCase = getListCardVisitUseCase()

            _listCardVisit.value = getListCardVisitUseCase.map { mapper.userEntityToUserModel(it) }
        }
    }
}