package com.example.coffeeshop

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun CommentsView(navController: NavController, cafeIndex: Int) {
    val comentarios = listOf(
        "Great place, excellent service!",
        "The coffee was a bit cold...",
        "Loved the atmosphere!",
        "Would definitely visit again.",
        "The barista was really friendly.",
        "Nice spot, but a bit pricey.",
        "Best coffee in town!"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    )

    {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(comentarios.size) { index ->
                Text(
                    text = comentarios[index],
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }

        Button(
            onClick = { navController.navigateUp() },  // Regresa a la pantalla anterior
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 16.dp)
        ) {
            Text(text = "Volver")
        }
    }
}