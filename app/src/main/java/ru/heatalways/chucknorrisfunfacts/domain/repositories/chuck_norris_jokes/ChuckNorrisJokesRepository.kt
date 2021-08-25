package ru.heatalways.chucknorrisfunfacts.domain.repositories.chuck_norris_jokes

import ru.heatalways.chucknorrisfunfacts.data.network.util.ResultWrapper

interface ChuckNorrisJokesRepository {
    suspend fun random(category: String? = null): ResultWrapper<ChuckJoke>
    suspend fun categories(): ResultWrapper<List<Category>>
    suspend fun search(query: String): ResultWrapper<List<ChuckJoke>>

    suspend fun saveJoke(joke: ChuckJoke)
    suspend fun getSavedJokesBy(limit: Int = 10, offset: Int = 0): List<ChuckJoke>
    suspend fun getAllSavedJokes(): List<ChuckJoke>
}