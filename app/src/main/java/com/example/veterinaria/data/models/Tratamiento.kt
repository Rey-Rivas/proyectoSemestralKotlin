package com.example.veterinaria.data.models

import java.util.Date

open class Tratamiento (
    val idTratamiento: Int,
    var fecha: Date,
    var proximaDosis: Date
)