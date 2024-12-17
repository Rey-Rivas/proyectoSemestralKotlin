package com.example.veterinaria.classes

import java.util.Date

open class Tratamiento (
    val idTratamiento: Int,
    val fecha: Date,
    val proximaDosis: Date
)