package com.example.kotlincrudexample.data.network

import com.example.kotlincrudexample.core.RetrofitHelper
import com.example.kotlincrudexample.data.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getUsers(): List<User> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(UserApiClient::class.java).getUsers()
            response.body()?.userList ?: emptyList()
        }
    }
}