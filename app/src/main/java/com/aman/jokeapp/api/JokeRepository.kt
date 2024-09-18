package com.aman.jokeapp.api

class JokeRepository {
    suspend fun getJoke(): Joke? {
        val response = RetrofitInstance.api.getRandomJoke()
        return if (response.isSuccessful) {
            response.body()
        } else {
            null
        }
    }
}