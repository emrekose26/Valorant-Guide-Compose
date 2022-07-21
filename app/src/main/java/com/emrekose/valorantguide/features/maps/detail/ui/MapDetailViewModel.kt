package com.emrekose.valorantguide.features.maps.detail.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emrekose.valorantguide.common.doOnError
import com.emrekose.valorantguide.common.doOnLoading
import com.emrekose.valorantguide.common.doOnSuccess
import com.emrekose.valorantguide.features.maps.detail.domain.usecase.MapDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapDetailViewModel @Inject constructor(
    private val useCase: MapDetailUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _state = mutableStateOf(MapDetailState())
    val state: State<MapDetailState> = _state

    init {
        savedStateHandle.get<String>("mapUuid")?.let { mapUuid ->
            getMapDetail(mapUuid)
        }
    }

    private fun getMapDetail(mapUuid: String) {
        viewModelScope.launch {
            useCase.getMapDetail(mapUuid)
                .doOnLoading {
                    _state.value = MapDetailState(isLoading = true)
                }
                .doOnSuccess { mapDetails ->
                    _state.value = MapDetailState(mapDetails = mapDetails)
                }
                .doOnError { error ->
                    _state.value = MapDetailState(error = error.toString())
                }
                .collect()
        }
    }
}