package ru.heatalways.chucknorrisfunfacts.presentation.base

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

abstract class BaseMviFragment<
        Binding: ViewBinding,
        Event: MviAction,
        State: MviState,
        Effect: MviEffect
>: BaseFragment<Binding>() {

    protected abstract val viewModel: BaseMviViewModel<Event, State, Effect, *>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.state
                .onEach { renderState(it) }
                .launchIn(this)
        }

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.effect
                .onEach { handleEffect(it) }
                .launchIn(this)
        }
    }

    abstract fun renderState(state: State)
    abstract fun handleEffect(effect: Effect)

    protected fun action(event: Event) {
        viewModel.setAction(event)
    }
}