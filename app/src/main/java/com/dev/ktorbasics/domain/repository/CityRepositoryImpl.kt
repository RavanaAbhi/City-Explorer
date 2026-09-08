package com.dev.ktorbasics.domain.repository

import com.dev.ktorbasics.data.dto.CityDto
import com.dev.ktorbasics.data.mapper.toDomain
import com.dev.ktorbasics.data.remote.CityApi
import com.dev.ktorbasics.data.repository.CityRepository
import com.dev.ktorbasics.domain.model.City
import kotlinx.io.IOException

class CityRepositoryImpl(
    private val api: CityApi
) : CityRepository {

    override suspend fun getCityDetails(city: String): Result<City> {
        return try {
            val response = api.getCityDetails(city)
            val city = response.firstOrNull() ?:
            return Result.failure(IllegalStateException(
                "City Not Found"
            ))
            Result.success(city.toDomain())
        }
        catch (e: IOException) {
            Result.failure(Exception("Network Error. Please check your internet connection"))
        }
        catch (e: Exception) {
            Result.failure(Exception(e.message ?: "Something went wrong"))
        }
    }

}