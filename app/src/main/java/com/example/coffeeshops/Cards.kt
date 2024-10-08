package com.example.coffeeshops

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

var puntuacionJuego: Float = 1.0f

@Composable
fun Cards(navController: NavController) {

    var puntuaciones by remember { mutableStateOf(List(7) { 1.0f }) }

    val imagenes = listOf(
        R.drawable.images1,
        R.drawable.images2,
        R.drawable.images3,
        R.drawable.images4,
        R.drawable.images5,
        R.drawable.images6,
        R.drawable.images7
    )

    val titulos = listOf(
        "Antico Caffè Greco",
        "Coffee Room",
        "Coffee Ibiza",
        "Pudding Coffee Shop",
        "L'Express",
        "Coffee Corner",
        "Sweet Cup"
    )

    val subtitulos = listOf(
        "St. Italy, Rome",
        "St. Germany, Berlin",
        "St. Colon, Madrid",
        "St. Diagonal, Barcelona",
        "St. Picadilly Circus, London",
        "St. Ángel Guimerà, Valencia",
        "St. Kinkerstraat, Amsterdam"
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(imagenes.size) { index ->
            Card(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .fillMaxHeight(0.9f),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Image(
                        modifier = Modifier.fillMaxWidth()
                            .size(200.dp),
                        painter = painterResource(id = imagenes[index]),
                        contentDescription = "Descripción de la imagen",
                        contentScale = ContentScale.Crop
                    )

                    Text(
                        text = titulos[index],
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    CrearSlider(puntuaciones[index]) { newPuntuacion ->
                        puntuaciones = puntuaciones.toMutableList().also { it[index] = newPuntuacion }
                    }

                    Text(
                        text = subtitulos[index],
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    HorizontalDivider()

                    Button(
                        onClick = { /* Acción del botón */ },
                        modifier = Modifier.align(Alignment.Start)
                    ) {
                        Text("Acción")
                    }
                }
            }
        }
    }
}

@Composable
fun CrearSlider(puntuacion: Float, onPuntuacionChange: (Float) -> Unit) {

    Row {
        for (i in 1..5) {
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = "Favorite Icon",
                tint = if (i <= puntuacion) {
                    Color(0xFFFFC107)
                } else {
                    Color(0xFF7E7E7E)
                },
                modifier = Modifier
                    .padding(7.dp)
                    .size(30.dp)
                    .clickable {
                        onPuntuacionChange(i.toFloat())
                    }
            )
        }
    }
}