package com.dev.ktorbasics.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.ktorbasics.domain.usecase.GetCityDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val getCityDetailsUseCase: GetCityDetailsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<CityDetailsUIState>(CityDetailsUIState.Loading)

    val uiState: StateFlow<CityDetailsUIState> = _uiState.asStateFlow()

    fun loadCity(city: String) {
        viewModelScope.launch {
            _uiState.value = CityDetailsUIState.Loading

            getCityDetailsUseCase(city).onSuccess { cityDetails ->
                _uiState.value = CityDetailsUIState.Success(cityDetails)
            }
                .onFailure {exception ->
                    _uiState.value = CityDetailsUIState.
                    Failure(exception.message ?: "something went wrong")

                }
        }
    }

}