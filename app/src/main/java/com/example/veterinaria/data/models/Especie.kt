package com.example.veterinaria.data.models

data class Especie (
    val idEspecie: Int,
    val nombre: String,
    val razas: List<Raza>
)