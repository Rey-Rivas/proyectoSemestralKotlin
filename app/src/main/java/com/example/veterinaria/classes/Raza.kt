package com.example.veterinaria.classes

data class Raza (
    val idRaza: Int,
    val nombre: String,
    val especie: List<Especie>
)