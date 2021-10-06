package ru.heatalways.chucknorrisfunfacts.presentation.screen.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.emptyFlow
import ru.heatalways.chucknorrisfunfacts.R
import ru.heatalways.chucknorrisfunfacts.databinding.FragmentMainBinding
import ru.heatalways.chucknorrisfunfacts.extensions.setupWithNavController
import ru.heatalways.chucknorrisfunfacts.presentation.base.BindingMviFragment

@AndroidEntryPoint
class MainFragment: BindingMviFragment<FragmentMainBinding, MainAction, MainViewState>(
    bindingInflater = FragmentMainBinding::inflate
) {
    override val viewModel: MainViewModel by viewModels()

    override val actions get() = emptyFlow<MainAction>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bottomNavigationBar.setupWithNavController(
            navGraphIds = listOf(
                R.navigation.nav_graph_search,
                R.navigation.nav_graph_random
            ),
            fragmentManager = childFragmentManager,
            containerId = R.id.mainFragmentContainer,
            intent = requireActivity().intent
        )
    }

    override fun renderState(state: MainViewState) = Unit
}