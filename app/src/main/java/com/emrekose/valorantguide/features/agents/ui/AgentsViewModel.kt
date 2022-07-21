package com.emrekose.valorantguide.features.agents.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emrekose.valorantguide.common.doOnError
import com.emrekose.valorantguide.common.doOnLoading
import com.emrekose.valorantguide.common.doOnSuccess
import com.emrekose.valorantguide.features.agents.domain.usecase.AgentsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgentsViewModel @Inject constructor(
    private val useCase: AgentsUseCase
): ViewModel() {

    private val _state = mutableStateOf(AgentsState())
    val state: State<AgentsState> = _state

    private val _eventFlow = Channel<UiEvent>(Channel.BUFFERED)
    val eventFlow = _eventFlow.receiveAsFlow()

    init {
        getAgents()
    }

    private fun getAgents() {
        viewModelScope.launch {
            useCase.getAgents()
                .doOnLoading {
                    _state.value = AgentsState(isLoading = true)
                }.doOnSuccess { agents ->
                    _state.value = AgentsState(agents = agents)
                }.doOnError { error ->
                    _state.value = AgentsState(error = error.toString())
                }.collect()
        }
    }

    sealed class UiEvent {

    }
}