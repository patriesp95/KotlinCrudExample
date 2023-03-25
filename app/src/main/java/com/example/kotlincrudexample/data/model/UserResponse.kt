package com.example.kotlincrudexample.data.model

import com.google.gson.annotations.SerializedName

data class UserResponse(
       @SerializedName("listaUsuarios") val userList: List<User>? = null
        )