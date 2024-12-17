package com.example.veterinaria.classes

import java.util.Date

class Antiparasitario (
    val tipoAntiparasitario: String,
    idTratamiento: Int,
    fecha: Date,
    proximaDosis: Date
) : Tratamiento(idTratamiento, fecha, proximaDosis)