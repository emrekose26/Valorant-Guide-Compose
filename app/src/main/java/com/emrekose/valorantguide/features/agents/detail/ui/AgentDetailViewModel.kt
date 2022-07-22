package com.emrekose.valorantguide.features.agents.detail.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emrekose.valorantguide.common.doOnError
import com.emrekose.valorantguide.common.doOnLoading
import com.emrekose.valorantguide.common.doOnSuccess
import com.emrekose.valorantguide.features.agents.detail.domain.usecase.AgentDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgentDetailViewModel @Inject constructor(
    private val useCase: AgentDetailUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _state = mutableStateOf(AgentDetailState())
    val state: State<AgentDetailState> = _state

    init {
        savedStateHandle.get<String>("agentUuid")?.let { agentUuid ->
            getAgentDetail(agentUuid)
        }
    }

    private fun getAgentDetail(agentUuid: String) {
        viewModelScope.launch {
            useCase.getAgentDetail(agentUuid)
                .doOnLoading {
                    _state.value = AgentDetailState(isLoading = true)
                }
                .doOnSuccess { agentDetails ->
                    _state.value = AgentDetailState(agentDetails = agentDetails)
                }
                .doOnError { error ->
                    _state.value = AgentDetailState(error = error.toString())
                }
                .collect()
        }
    }
}