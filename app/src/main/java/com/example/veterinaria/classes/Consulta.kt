package com.example.veterinaria.classes

import java.util.Date

open class Consulta (
    val idConsulta: Int,
    val motivo: String,
    var diagnostico: String,
    val Indicaciones: String,
    val fecha: Date,
    val veterinario: Veterinario?
)