package com.example.veterinaria.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.veterinaria.classes.Consulta
import com.example.veterinaria.classes.Veterinario
import java.util.Date

class ConsultaViewModel : ViewModel() {
    private val _consulta = MutableLiveData<Consulta?>()
    val consulta: MutableLiveData<Consulta?> = _consulta

    fun realizarConsulta(veterinario: Veterinario) {
        val fechaHoy = Date()
        val nuevaConsulta = Consulta(
            idConsulta = 0, // Assuming id is set elsewhere
            motivo = "",
            diagnostico = "",
            Indicaciones = "",
            fecha = fechaHoy,
            veterinario = veterinario
        )
        _consulta.value = nuevaConsulta
    }

    fun obtenerDiagnostico(): String? {
        return _consulta.value?.diagnostico
    }
}