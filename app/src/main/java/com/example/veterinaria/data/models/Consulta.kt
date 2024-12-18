package com.example.veterinaria.data.models

import java.util.Date

open class Consulta (
    val idConsulta: Int,
    val motivo: String,
    val diagnostico: String,
    val Indicaciones: String,
    val fecha: Date,
    val veterinario: Veterinario
)