package com.example.kotlincrudexample.data.network

import com.example.kotlincrudexample.data.model.User
import com.example.kotlincrudexample.data.model.UserResponse
import retrofit2.Response
import retrofit2.http.*

interface UserApiClient {

    @GET("/usuarios")
    suspend fun getUsers(): Response<UserResponse>

    @GET("/usuario/{id}")
    suspend fun getUserById(@Path("id") id: Int): Response<User>

    @POST("/usuario/add")
    suspend fun addUser(@Body usuario: User): Response<String>

    @PUT("/usuario/update/{id}")
    suspend fun updateUser(@Path("id") id: Int, @Body usuario: User): Response<String>

    @DELETE("/usuario/delete/{id}")
    suspend fun borrarUsuario(@Path("id") id: Int):Response<String>
}