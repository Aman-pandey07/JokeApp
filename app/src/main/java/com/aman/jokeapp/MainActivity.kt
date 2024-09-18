package com.aman.jokeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.unit.dp
import com.aman.jokeapp.screens.JokeViewModel
import com.aman.jokeapp.ui.theme.JokeAppTheme
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JokeAppTheme {
                JokeScreen()
            }
        }
    }
}

@Composable
fun JokeScreen(jokeViewModel: JokeViewModel = viewModel()) {
    val joke by jokeViewModel.joke.collectAsState()

    LaunchedEffect(Unit) {
        jokeViewModel.fetchJoke()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (joke != null) {
            Text(text = joke!!.setup, style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = joke!!.punchline, style = MaterialTheme.typography.bodyLarge)
        } else {
            CircularProgressIndicator()
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = { jokeViewModel.fetchJoke() }) {
            Text(text = "Fetch Another Joke")
        }
    }
}

