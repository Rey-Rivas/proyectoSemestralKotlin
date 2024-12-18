package com.example.veterinaria.data.models

data class RegistroMedico (
    val Id: Int,
    val mascota: Mascota,
    val documentos: List<Documento>,
    val tratamientos: List<Tratamiento>,
    val consultas: List<Consulta>
)