package com.example.veterinaria.classes

import java.util.Date

open class consConsulta (
    val idConsulta: Int,
    val motivo: String,
    val diagnostico: String,
    val Indicaciones: String,
    val fecha: Date,
    val veterinario: Veterinario
)