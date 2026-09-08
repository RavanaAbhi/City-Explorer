package com.dev.ktorbasics.data.mapper

import com.dev.ktorbasics.data.dto.CityDto
import com.dev.ktorbasics.domain.model.City

fun CityDto.toDomain() : City {
    return City (
        name = name.orEmpty(),
        population = population,
        region = region,
        latitude = latitude,
        longitude = longitude
    )
}