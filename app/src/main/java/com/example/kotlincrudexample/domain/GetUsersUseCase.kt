package com.example.kotlincrudexample.domain

import com.example.kotlincrudexample.data.model.User
import com.example.kotlincrudexample.data.repository.UserRepository

class GetUsersUseCase {

    private val repository = UserRepository()

    suspend operator fun invoke():List<User> = repository.getAllUsers()
}