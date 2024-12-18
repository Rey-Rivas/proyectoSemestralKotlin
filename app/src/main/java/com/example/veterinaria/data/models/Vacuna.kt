package com.example.veterinaria.data.models

import java.util.Date

class Vacuna(
    val tipoVacuna: String,
    id: Int,
    fecha: Date,
    proximaDosis: Date
) : Tratamiento(id, fecha, proximaDosis)