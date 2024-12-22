package com.example.veterinaria.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.veterinaria.classes.Consulta
import java.util.Date

class EmergenciaViewModel : ViewModel() {
    private val _emergencia = MutableLiveData<Consulta?>()
    val emergencia: MutableLiveData<Consulta?> = _emergencia

    fun registrarEmergencia(tipo: String, descripcion: String) {
        val fechaHoy = Date()
        val nuevaEmergencia = Consulta(
            idConsulta = 0, // Assuming id is set elsewhere
            motivo = tipo,
            diagnostico = descripcion,
            Indicaciones = "",
            fecha = fechaHoy,
            veterinario = null // Assuming no veterinarian is assigned
        )
        _emergencia.value = nuevaEmergencia
    }

    fun cerrarEmergencia() {
        _emergencia.value = null
    }
}