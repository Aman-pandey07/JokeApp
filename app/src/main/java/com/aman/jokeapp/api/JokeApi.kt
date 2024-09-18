package com.aman.jokeapp.api


import retrofit2.Response
import retrofit2.http.GET

interface JokeApi {
    @GET("https://official-joke-api.appspot.com/random_joke")
    suspend fun getRandomJoke(): Response<Joke>
}

data class Joke(
    val id: Int,
    val type: String,
    val setup: String,
    val punchline: String,
)