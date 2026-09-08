package com.dev.ktorbasics.presentation


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CityRow(
    city: CityItem,
    onClick: () -> Unit
) {


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(34.dp)
            .background(
                city.backgroundColor
            )
            .clickable {
                onClick()
            }
            .padding(
                horizontal = 20.dp
            ),
        verticalAlignment =
            Alignment.CenterVertically,
        horizontalArrangement =
            Arrangement.SpaceBetween
    ) {

        Text(
            text = city.name,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "›",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

//@Composable
//fun CityRow(
//    city: CityItem,
//    onClick: () -> Unit
//) {
//
//    val backgroundView = when (city.colourIndex ) {
//        0 -> MaterialTheme.colorScheme.background.blue
//        1 -> MaterialTheme.colorScheme.background.red
//        2 -> MaterialTheme.colorScheme.background.green
//        3 -> MaterialTheme.colorScheme.background.blue
//        4 -> MaterialTheme.colorScheme.background.red
//        5 -> MaterialTheme.colorScheme.background.green
//        6 -> MaterialTheme.colorScheme.background.red
//        7 -> MaterialTheme.colorScheme.background.green
//
//        else -> MaterialTheme.colorScheme.background.alpha
//    }
//
//    Card(
//        modifier = Modifier.fillMaxWidth()
//            .clickable(onClick = onClick)
//    ) {
//
//        Text(text = city.name,
//            style = MaterialTheme.typography.titleSmall)
//
//
////        Text(
////            text = city,
////            style = MaterialTheme.typography.titleSmall
////        )
//
//
//    }
//
//
//}

