package com.example.dependencyinjection.network

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkProvider {

    private val dogProvider = Retrofit.Builder().baseUrl("https://dog.ceo/").addConverterFactory(GsonConverterFactory.create()).build()

    private val dogService = dogProvider.create(DogService::class.java)

    fun provide() : DogService {
        return dogService
    }

}