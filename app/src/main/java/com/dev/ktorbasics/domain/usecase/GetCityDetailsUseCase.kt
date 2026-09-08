package com.dev.ktorbasics.domain.usecase

import com.dev.ktorbasics.data.repository.CityRepository
import com.dev.ktorbasics.domain.model.City

class GetCityDetailsUseCase(
    private val repository: CityRepository
) {

    suspend operator fun invoke(
        city: String
    ): Result<City> {

        return repository.getCityDetails(city)
    }
}