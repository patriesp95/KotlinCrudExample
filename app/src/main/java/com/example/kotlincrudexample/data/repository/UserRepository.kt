package com.example.kotlincrudexample.data.repository

import android.util.Log
import com.example.kotlincrudexample.data.model.User
import com.example.kotlincrudexample.data.model.UserProvider
import com.example.kotlincrudexample.data.network.UserService

class UserRepository {

    private val api = UserService()

    suspend fun getAllUsers(): List<User> {
        val response = api.getUsers()
        UserProvider.users = response
        return response
    }
}