package ru.heatalways.chucknorrisfunfacts.business.interactors.random_joke

import ru.heatalways.chucknorrisfunfacts.business.datasource.network.chuck_norris_jokes.Category
import ru.heatalways.chucknorrisfunfacts.business.datasource.network.chuck_norris_jokes.ChuckJoke
import ru.heatalways.chucknorrisfunfacts.business.domain.utils.StringResource
import ru.heatalways.chucknorrisfunfacts.presentation.base.MviState

data class RandomJokeViewState(
    val isLoading: Boolean = false,
    val isJokeLoading: Boolean = false,
    val message: StringResource? = null,
    val jokes: List<ChuckJoke> = emptyList(),
    val category: Category = Category.Any
): MviState