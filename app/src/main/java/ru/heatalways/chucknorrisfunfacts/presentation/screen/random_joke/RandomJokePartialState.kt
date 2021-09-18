package ru.heatalways.chucknorrisfunfacts.presentation.screen.random_joke

import ru.heatalways.chucknorrisfunfacts.domain.repositories.chuck_norris_jokes.Category
import ru.heatalways.chucknorrisfunfacts.domain.repositories.chuck_norris_jokes.ChuckJoke
import ru.heatalways.chucknorrisfunfacts.domain.utils.SnackbarState
import ru.heatalways.chucknorrisfunfacts.domain.utils.StringResource
import ru.heatalways.chucknorrisfunfacts.domain.utils.ToastState

sealed class RandomJokePartialState {
    data class Toast(val toastState: ToastState): RandomJokePartialState()
    data class Snackbar(val snackbarState: SnackbarState): RandomJokePartialState()
    data class ScrollUp(val isScrolling: Boolean): RandomJokePartialState()

    object JokeLoading: RandomJokePartialState()
    data class JokeLoaded(val joke: ChuckJoke?): RandomJokePartialState()

    object JokesLoading: RandomJokePartialState()
    data class JokesLoaded(val jokes: List<ChuckJoke>): RandomJokePartialState()
    object JokesUpdating: RandomJokePartialState()
    data class JokesUpdated(val jokes: List<ChuckJoke>): RandomJokePartialState()
    data class JokesMessage(val message: StringResource): RandomJokePartialState()

    data class CategorySelected(val category: Category): RandomJokePartialState()
}