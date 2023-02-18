package com.example.dependencyinjection.network

import com.example.dependencyinjection.model.Dog
import retrofit2.http.GET

interface DogService {

    @GET("api/breeds/image/random")
    suspend fun getRandomDog() : Dog
}