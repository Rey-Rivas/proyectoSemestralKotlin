package com.example.veterinaria.classes

import java.util.Date

data class Mascota(
    val id: Int,
    var nombre: String,
    val fechaNacimiento: Date, // Usar formato de fecha adecuado
    val foto: String, // Ruta de la foto
    val peso: Double,
    val raza: Raza,
    val registroMedico: RegistroMedico
)