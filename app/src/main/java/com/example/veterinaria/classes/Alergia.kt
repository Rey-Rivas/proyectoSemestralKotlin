package com.example.veterinaria.classes

data class Alergia(
    val idAlergia: Int,
    val tipo: String,
    val sustancia: String,
    val severidad: Int,
    val reaccion: String,
    val mascotas: List<Mascota>
)