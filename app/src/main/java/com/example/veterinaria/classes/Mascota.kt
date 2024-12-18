package com.example.veterinaria.classes
import java.util.Date

data class Mascota(
    val id: Int,
    var nombre: String,
    val fechaNacimiento: Date,
    val foto: String, // Ruta de la foto
    val peso: Double,
    val especie: Especie,
    val raza: Raza,
    val registroMedico: RegistroMedico
)