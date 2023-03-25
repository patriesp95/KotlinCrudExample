package com.example.kotlincrudexample.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlincrudexample.data.model.User
import com.example.kotlincrudexample.domain.GetUsersUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {

    var getUsersUseCase = GetUsersUseCase()

    private val _state = MutableLiveData(UiState())
    val state: LiveData<UiState>
        get() = _state

    init{
        refresh()
    }


    private fun refresh() {
        viewModelScope.launch{
            _state.value = _state.value?.copy(loading = true)
            _state.value = UiState(users = getUsersUseCase())
            _state.value = _state.value?.copy(loading = false)
        }
    }

    data class UiState(
        val loading: Boolean = false,
        val users: List<User>? = null
    )

}