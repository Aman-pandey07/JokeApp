package com.aman.jokeapp.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aman.jokeapp.api.Joke
import com.aman.jokeapp.api.JokeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class JokeViewModel : ViewModel() {
    private val repository = JokeRepository()

    private val _joke = MutableStateFlow<Joke?>(null)
    val joke: StateFlow<Joke?> = _joke

    fun fetchJoke() {
        viewModelScope.launch {
            _joke.value = repository.getJoke()
        }
    }
}