package com.example.veterinaria.viewModels

import androidx.lifecycle.ViewModel
import com.example.veterinaria.classes.*

class VeterinarioViewModel : ViewModel() {

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