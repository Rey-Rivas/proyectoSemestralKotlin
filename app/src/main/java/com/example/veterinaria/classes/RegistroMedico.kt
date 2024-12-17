package com.example.veterinaria.classes

data class RegistroMedico (
    val Id: Int,
    val mascota: Mascota,
    val documentos: List<Documento>,
    val tratamientos: List<Tratamiento>,
    val consultas: List<Consulta>
)