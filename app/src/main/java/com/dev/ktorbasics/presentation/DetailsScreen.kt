package com.dev.ktorbasics.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.LocationCity
import androidx.compose.material.icons.filled.Navigation
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dev.ktorbasics.domain.model.City
import java.util.Locale

@Composable
fun DetailsScreen(
    cityName: String,
    onBackClick: () -> Unit,
    viewModel: DetailsViewModel = hiltViewModel()
) {

    val state by viewModel.uiState.collectAsState()

    LaunchedEffect(cityName) {
        viewModel.loadCity(cityName)
    }
    Scaffold(
        topBar = {
            CityDetailsTopBar(
                cityName = cityName,
                onBackClick = onBackClick
            )
        }
    ) { paddingValues ->

        when (val curentState = state) {
            CityDetailsUIState.Loading -> {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator()
                }

            }

            is CityDetailsUIState.Success -> {

                CityDetailsContent(
                    city = curentState.city,
                    modifier = Modifier.fillMaxSize()
                        .padding(paddingValues)
                )

            }

            is CityDetailsUIState.Failure -> {
                Column(
                    modifier = Modifier.fillMaxSize()
                        .padding(paddingValues),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = curentState.msg
                    )

                    Button(
                        onClick = {
                            viewModel.loadCity(cityName)
                        }
                    ) {
                        Text("Retry")
                    }

                }


            }
        }
    }



}

@Composable
private fun CityDetailsTopBar(
    cityName: String,
    onBackClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
    ) {

        IconButton(
            onClick = onBackClick,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 12.dp)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back"
            )
        }

        Text(
            text = cityName,
            modifier = Modifier.align(Alignment.Center),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun CityDetailsContent(
    city: City,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 20.dp)
    ) {

        CityHeaderCard(city)

        Spacer(
            modifier = Modifier.height(32.dp)
        )

        CityDetailRow(
            icon = Icons.Default.Groups,
            label = "Population",
            value = city.population.toString()
        )

        CityDetailRow(
            icon = Icons.Default.LocationCity,
            label = "Region",
            value = city.region
        )

        CityDetailRow(
            icon = Icons.Default.Navigation,
            label = "Latitude",
            value = String.format(
                Locale.US,
                "%.4f",
                city.latitude
            )
        )

        CityDetailRow(
            icon = Icons.Default.Navigation,
            label = "Longitude",
            value = String.format(
                Locale.US,
                "%.4f",
                city.longitude
            )
        )
    }
}

@Composable
private fun CityHeaderCard(
    city: City
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(
                RoundedCornerShape(24.dp)
            )
            .background(
                Color(0xFF4CAF00)
            )
            .padding(
                vertical = 28.dp,
                horizontal = 20.dp
            ),
        horizontalAlignment =
            Alignment.CenterHorizontally
    ) {

        Text(
            text = city.name,
            color = Color.White,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        city.region?.let {
            Text(
                text = it,
                color = Color.White.copy(alpha = 0.8f),
                fontSize = 16.sp
            )
        }
    }
}

@Composable
private fun CityDetailRow(
    icon: ImageVector,
    label: String,
    value: String?
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 14.dp),
        verticalAlignment =
            Alignment.CenterVertically
    ) {

        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF03A9F4),
            modifier = Modifier.size(32.dp)
        )

        Spacer(
            modifier = Modifier.width(24.dp)
        )

        Column {

            Text(
                text = label,
                fontSize = 14.sp,
                color = Color.Gray
            )

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            if (value != null) {
                Text(
                    text = value,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}