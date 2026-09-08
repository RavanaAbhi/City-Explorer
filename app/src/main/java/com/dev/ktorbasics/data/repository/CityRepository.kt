package com.dev.ktorbasics.data.repository

import com.dev.ktorbasics.domain.model.City

interface CityRepository {
    suspend fun getCityDetails(
        city: String): Result<City>
}