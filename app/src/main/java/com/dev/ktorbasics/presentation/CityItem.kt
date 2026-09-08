package com.dev.ktorbasics.presentation

import androidx.compose.ui.graphics.Color

data class CityItem(
    val name: String,
    val backgroundColor: Color
)

val cities = listOf(

    CityItem(
        name = "London",
        backgroundColor = Color(0xFFFF6D00)
    ),

    CityItem(
        name = "Chicago",
        backgroundColor = Color(0xFF2196F3)
    ),

    CityItem(
        name = "Delhi",
        backgroundColor = Color(0xFFFFC107)
    ),

    CityItem(
        name = "Hyderabad",
        backgroundColor = Color(0xFF26C6DA)
    ),

    CityItem(
        name = "Bangalore",
        backgroundColor = Color(0xFF4CAF50)
    ),

    CityItem(
        name = "Chennai",
        backgroundColor = Color(0xFFEC407A)
    ),

    CityItem(
        name = "Mumbai",
        backgroundColor = Color(0xFFAB47BC)
    ),

    CityItem(
        name = "Goa",
        backgroundColor = Color(0xFF42A5F5)
    ),

    CityItem(
        name = "Assam",
        backgroundColor = Color(0xFFD7CCC8)
    )
)