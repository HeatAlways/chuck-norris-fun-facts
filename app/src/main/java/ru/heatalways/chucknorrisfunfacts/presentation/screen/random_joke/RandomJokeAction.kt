package ru.heatalways.chucknorrisfunfacts.presentation.screen.random_joke

import ru.heatalways.chucknorrisfunfacts.presentation.base.MviAction

sealed class RandomJokeAction: MviAction {
    object OnNextPage: RandomJokeAction()
    object OnRandomJokeRequest: RandomJokeAction()
    object OnCategorySelectionButtonClick: RandomJokeAction()
    data class OnMenuItemSelect(val itemId: Int): RandomJokeAction()
}