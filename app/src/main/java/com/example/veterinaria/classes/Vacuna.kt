package com.example.veterinaria.classes

import java.util.Date

class Vacuna(
    val tipoVacuna: String,
    idTratamiento: Int,
    fecha: Date,
    proximaDosis: Date
) : Tratamiento(idTratamiento, fecha, proximaDosis) {
    fun copyWith(
        tipoVacuna: String = this.tipoVacuna,
        idTratamiento: Int = this.idTratamiento,
        fecha: Date = this.fecha,
        proximaDosis: Date = this.proximaDosis
    ): Vacuna {
        return Vacuna(tipoVacuna, idTratamiento, fecha, proximaDosis)
    }
}