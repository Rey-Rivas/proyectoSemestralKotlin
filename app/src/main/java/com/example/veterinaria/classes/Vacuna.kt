package com.example.veterinaria.classes

import java.util.Date

class Vacuna(
    val tipoVacuna: String,
    id: Int,
    fecha: Date,
    proximaDosis: Date
) : Tratamiento(id, fecha, proximaDosis)