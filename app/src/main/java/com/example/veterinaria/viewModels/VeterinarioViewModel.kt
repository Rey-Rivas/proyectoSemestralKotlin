package com.example.veterinaria.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import com.example.veterinaria.classes.Consulta
import com.example.veterinaria.classes.Mascota
import com.example.veterinaria.classes.Tratamiento
import com.example.veterinaria.classes.Veterinario

class VeterinarioViewModel : ViewModel() {
    private val _veterinarios = MutableLiveData<List<Veterinario>>()
    val veterinarios: MutableLiveData<List<Veterinario>> = _veterinarios

    init {
        loadVeterinarios()
    }

    private fun loadVeterinarios() {
        val veterinariosList = listOf(
            Veterinario(1, "Dr. Smith", "123456789", "123 Main St", 0.0, 0.0),
            Veterinario(2, "Dr. Johnson", "987654321", "456 Elm St", 0.0, 0.0)
        )
        _veterinarios.value = veterinariosList
    }

    fun realizarDiagnostico(consulta: Consulta, nuevoDiagnostico: String, veterinario: Veterinario) {
        if (consulta.veterinario?.Id == veterinario.Id) {
            consulta.diagnostico = nuevoDiagnostico
        }
    }

    fun recetarTratamiento(mascota: Mascota, tratamiento: Tratamiento, registroMedicoViewModel: RegistroMedicoViewModel) {
        val registroMedico = registroMedicoViewModel.registroMedico.value
        if (registroMedico != null && registroMedico.mascota.id == mascota.id) {
            registroMedicoViewModel.agregarTratamiento(tratamiento)
        }
    }
}