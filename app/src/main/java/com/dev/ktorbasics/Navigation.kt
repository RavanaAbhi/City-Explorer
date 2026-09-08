package com.dev.ktorbasics

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.dev.ktorbasics.presentation.CityListScreen
import com.dev.ktorbasics.presentation.DetailsScreen


@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "cities"
    ) {
        composable("cities"
        ) {
            CityListScreen(
                onCityClick = {
                    city ->
                    navController.navigate("details/${Uri.encode(city)}")
                }
            )
        }

        composable(
            route = "details/{city}",
            arguments = listOf(
                navArgument("city") {
                    type = NavType.StringType
                }
            )
        ) {
            backStackEntry ->
            val city = backStackEntry.arguments?.getString("city").orEmpty()
            DetailsScreen(
                cityName = city,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}