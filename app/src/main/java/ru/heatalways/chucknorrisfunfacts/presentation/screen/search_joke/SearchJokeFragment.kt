package ru.heatalways.chucknorrisfunfacts.presentation.screen.search_joke

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.terrakok.cicerone.androidx.FragmentScreen
import dagger.hilt.android.AndroidEntryPoint
import ru.heatalways.chucknorrisfunfacts.R
import ru.heatalways.chucknorrisfunfacts.databinding.FragmentSearchJokeBinding
import ru.heatalways.chucknorrisfunfacts.presentation.adapters.JokesAdapter
import ru.heatalways.chucknorrisfunfacts.presentation.base.BaseFragment

@AndroidEntryPoint
class SearchJokeFragment: BaseFragment<FragmentSearchJokeBinding>() {
    private val viewModel: SearchJokeViewModel by viewModels()
    private val jokesAdapter = JokesAdapter()

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSearchJokeBinding
        get() = FragmentSearchJokeBinding::inflate

    override val contentId = R.id.jokesRecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle(R.string.search_joke_screen_title)

        binding.apply {
            jokesRecyclerView.layoutManager = LinearLayoutManager(context)
            jokesRecyclerView.adapter = jokesAdapter

            searchView.onSearchExecute = { searchQuery ->
                viewModel.onSearchQueryExecute(searchQuery)
            }
        }

        initJokesObserver()
    }

    private fun initJokesObserver() {
        observe(viewModel.state) { state ->
            when (state) {
                is SearchJokeState.Error -> {
                    setProgressBarVisibility(false)
                    setErrorVisibility(true, state.message)
                }
                is SearchJokeState.Empty -> {
                    setProgressBarVisibility(false)
                    setErrorVisibility(true, getString(R.string.error_not_found))
                }
                is SearchJokeState.Loaded -> {
                    setProgressBarVisibility(false)
                    setErrorVisibility(false)
                    jokesAdapter.submitList(state.jokes)
                }
                SearchJokeState.Loading -> {
                    setProgressBarVisibility(true)
                    setErrorVisibility(false)
                }
            }
        }
    }

    companion object {
        fun getScreen() = FragmentScreen { SearchJokeFragment() }
    }
}