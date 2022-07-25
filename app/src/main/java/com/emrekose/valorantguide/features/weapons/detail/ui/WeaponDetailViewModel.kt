package com.emrekose.valorantguide.features.weapons.detail.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emrekose.valorantguide.common.doOnError
import com.emrekose.valorantguide.common.doOnLoading
import com.emrekose.valorantguide.common.doOnSuccess
import com.emrekose.valorantguide.features.weapons.detail.domain.usecase.WeaponDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeaponDetailViewModel @Inject constructor(
    private val useCase: WeaponDetailUseCase,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _state = mutableStateOf(WeaponDetailState())
    val state: State<WeaponDetailState> = _state

    init {
        savedStateHandle.get<String>("weaponUuid")?.let { weaponUuid ->
            getWeaponDetail(weaponUuid)
        }
    }

    fun onEvent(event: WeaponDetailPageEvent) {
        when(event) {
            is WeaponDetailPageEvent.OnSkinItemClick -> {
                _state.value = _state.value.copy(skinDetails = event.skin)
            }
            is WeaponDetailPageEvent.OnVideoShow -> {
                _state.value = _state.value.copy(levelDetails = event.level)
            }
        }
    }

    private fun getWeaponDetail(weaponUuid: String) {
        viewModelScope.launch {
            useCase.getWeaponDetail(weaponUuid)
                .doOnLoading {
                    _state.value = WeaponDetailState(isLoading = true)
                }
                .doOnSuccess { details ->
                    _state.value = WeaponDetailState(weaponDetails = details)
                }
                .doOnError { error ->
                    _state.value = WeaponDetailState(error = error.toString())
                }
                .collect()
        }
    }
}