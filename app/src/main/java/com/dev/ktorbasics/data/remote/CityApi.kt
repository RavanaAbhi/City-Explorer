package com.dev.ktorbasics.data.remote

import com.dev.ktorbasics.data.dto.CityDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CityApi {
    @GET("v1/city")
    suspend fun getCityDetails (
        @Query ("name") cityName: String
    ): List<CityDto>
}