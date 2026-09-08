package com.dev.ktorbasics.presentation

import com.dev.ktorbasics.domain.model.City

sealed class CityDetailsUIState {

    data object Loading : CityDetailsUIState()
    data class Success(
        val city: City
    ): CityDetailsUIState()

    data class Failure(val msg: String) : CityDetailsUIState()
}