package com.example.veterinaria.classes

import java.util.Date

open class Tratamiento (
    val idTratamiento: Int,
    var fecha: Date,
    var proximaDosis: Date
)