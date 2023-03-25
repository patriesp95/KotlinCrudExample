package com.example.kotlincrudexample.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://192.168.1.116:3000")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}