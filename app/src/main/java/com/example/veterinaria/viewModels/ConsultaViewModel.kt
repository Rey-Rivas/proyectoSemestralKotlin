package com.example.veterinaria.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.veterinaria.classes.Consulta
import com.example.veterinaria.classes.Veterinario
import java.util.Date

class ConsultaViewModel : ViewModel() {
    private val _consulta = MutableLiveData<Consulta?>()
    val consulta: MutableLiveData<Consulta?> = _consulta
    private val _consultas = MutableLiveData<List<Consulta>>()
    val consultas: MutableLiveData<List<Consulta>> = _consultas

    init {
        loadConsultas()
    }

    private fun loadConsultas() {
        val veterinarios = listOf(
            Veterinario(1, "Dr. Smith", "123456789", "123 Main St", 0.0, 0.0),
            Veterinario(2, "Dr. Johnson", "987654321", "456 Elm St", 0.0, 0.0)
        )

        val consultasList = listOf(
            Consulta(1, "Checkup", "Healthy", "No medication", Date(), veterinarios[0]),
            Consulta(2, "Vaccination", "Vaccinated", "Next dose in 1 year", Date(), veterinarios[1])
        )
        _consultas.value = consultasList
    }

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