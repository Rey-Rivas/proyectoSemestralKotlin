package com.example.veterinaria.data.models

import android.location.Location
import java.util.Date

class Emergencia(
    val ubicacionActual: Location,
    val idEmergencia: Int,
    idConsulta: Int,
    motivo: String,
    diagnostico: String,
    Indicaciones: String,
    fecha: Date,
    veterinario: Veterinario
): Consulta(idConsulta, motivo, diagnostico, Indicaciones, fecha, veterinario)