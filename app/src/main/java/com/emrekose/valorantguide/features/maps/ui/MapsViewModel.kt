package com.emrekose.valorantguide.features.maps.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emrekose.valorantguide.common.doOnError
import com.emrekose.valorantguide.common.doOnLoading
import com.emrekose.valorantguide.common.doOnSuccess
import com.emrekose.valorantguide.features.maps.domain.usecase.MapsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapsViewModel @Inject constructor(
    private val useCase: MapsUseCase
): ViewModel() {

    private val _state = mutableStateOf(MapsState())
    val state: State<MapsState> = _state

    private val _eventFlow = Channel<UiEvent>(Channel.BUFFERED)
    val eventFlow = _eventFlow.receiveAsFlow()

    init {
        getMaps()
    }

    private fun getMaps() {
        viewModelScope.launch {
            useCase.getMaps()
                .doOnLoading {
                    _state.value = MapsState(isLoading = true)
                }
                .doOnSuccess { maps ->
                    _state.value = MapsState(maps = maps)
                }
                .doOnError { error ->
                    _state.value = MapsState(error = error.toString())
                }
                .collect()
        }
    }

    sealed class UiEvent {

    }
}