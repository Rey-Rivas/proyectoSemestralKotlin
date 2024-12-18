package com.example.veterinaria.data.models

import java.util.Date

class Antiparasitario (
    val tipoAntiparasitario: String,
    idTratamiento: Int,
    fecha: Date,
    proximaDosis: Date
) : Tratamiento(idTratamiento, fecha, proximaDosis)