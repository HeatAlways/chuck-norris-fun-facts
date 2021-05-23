package ru.heatalways.chucknorrisfunfacts.domain.network.api

import retrofit2.http.GET
import retrofit2.http.Query
import ru.heatalways.chucknorrisfunfacts.data.entities.ChuckJoke
import ru.heatalways.chucknorrisfunfacts.data.entities.SearchResponse
import ru.heatalways.chucknorrisfunfacts.domain.network.api_response.ApiResponse

interface ChuckNorrisJokesApi {
    @GET("random")
    suspend fun random(
        @Query("category") category: String? = null
    ): ApiResponse<ChuckJoke>

    @GET("categories")
    suspend fun categories(): ApiResponse<List<String>>

    @GET("search")
    suspend fun search(
        @Query("query") query: String
    ): ApiResponse<SearchResponse>

    companion object {
        const val BASE_URL = "https://api.chucknorris.io/jokes/"
    }
}