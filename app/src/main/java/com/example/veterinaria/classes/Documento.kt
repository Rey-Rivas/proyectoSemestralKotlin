package com.example.veterinaria.classes

import java.util.Date

data class Documento (
    val idDocumento: Int,
    val titulo: String,
    val ruta: String,
    val fecha: Date,
    val registroMedico: RegistroMedico
)