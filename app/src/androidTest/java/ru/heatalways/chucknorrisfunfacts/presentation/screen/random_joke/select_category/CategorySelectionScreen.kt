package ru.heatalways.chucknorrisfunfacts.presentation.screen.random_joke.select_category

import io.github.kakaocup.kakao.recycler.KRecyclerView
import ru.heatalways.chucknorrisfunfacts.R
import ru.heatalways.chucknorrisfunfacts.presentation.adapters.view_holders.CategoryItem
import ru.heatalways.chucknorrisfunfacts.presentation.screen.BaseScreen
import ru.heatalways.chucknorrisfunfacts.presentation.custom_view.KSearchQueryView

object CategorySelectionScreen: BaseScreen<CategorySelectionScreen>() {
    override val layoutId = R.layout.fragment_select_category
    override val viewClass = CategorySelectionFragment::class.java

    val searchQueryView = KSearchQueryView { withId(R.id.searchView) }
    val categories = KRecyclerView(
        {
            withId(R.id.categoriesRecyclerView)
        },
        {
            itemType(::CategoryItem)
        }
    )
}