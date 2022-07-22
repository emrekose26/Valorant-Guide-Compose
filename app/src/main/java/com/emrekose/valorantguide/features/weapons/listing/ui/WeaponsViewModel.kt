package com.emrekose.valorantguide.features.weapons.listing.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emrekose.valorantguide.common.doOnError
import com.emrekose.valorantguide.common.doOnLoading
import com.emrekose.valorantguide.common.doOnSuccess
import com.emrekose.valorantguide.features.weapons.listing.domain.usecase.WeaponsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeaponsViewModel @Inject constructor(
    private val useCase: WeaponsUseCase,
): ViewModel() {

    private val _state = mutableStateOf(WeaponsState())
    val state: State<WeaponsState> = _state

    init {
        getWeapons()
    }

    private fun getWeapons() {
        viewModelScope.launch {
            useCase.getWeapons()
                .doOnLoading {
                    _state.value = WeaponsState(isLoading = true)
                }
                .doOnSuccess { weapons ->
                    _state.value = WeaponsState(weapons = weapons)
                }
                .doOnError { error ->
                    _state.value = WeaponsState(error = error.toString())
                }
                .collect()
        }
    }

}