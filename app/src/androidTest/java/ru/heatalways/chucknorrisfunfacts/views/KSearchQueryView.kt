package ru.heatalways.chucknorrisfunfacts.views

import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.image.KImageView
import ru.heatalways.chucknorrisfunfacts.R

class KSearchQueryView(function: ViewBuilder.() -> Unit) {
    val editText = KEditText(ViewBuilder().apply(function).getViewMatcher())
        { withId(R.id.searchQueryEditText) }

    val searchButton = KImageView(ViewBuilder().apply(function).getViewMatcher())
        { withId(R.id.searchButton) }
}