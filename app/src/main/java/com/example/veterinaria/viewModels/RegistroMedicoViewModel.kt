package com.example.veterinaria.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.veterinaria.classes.*

class RegistroMedicoViewModel : ViewModel() {
    private val _registroMedico = MutableLiveData<RegistroMedico>()
    val registroMedico: LiveData<RegistroMedico> = _registroMedico

    fun setRegistroMedico(registroMedico: RegistroMedico) {
        _registroMedico.value = registroMedico
    }

    fun agregarDocumento(documento: Documento) {
        _registroMedico.value?.let {
            val updatedDocumentos = it.documentos.toMutableList()
            updatedDocumentos.add(documento)
            _registroMedico.value = it.copy(documentos = updatedDocumentos)
        }
    }

    fun agregarTratamiento(tratamiento: Tratamiento) {
        _registroMedico.value?.let {
            val updatedTratamientos = it.tratamientos.toMutableList()
            updatedTratamientos.add(tratamiento)
            _registroMedico.value = it.copy(tratamientos = updatedTratamientos)
        }
    }

    fun obtenerVacunas(): List<Vacuna> {
        return _registroMedico.value?.tratamientos?.filterIsInstance<Vacuna>() ?: emptyList()
    }

    fun obtenerConsultas(): List<Consulta> {
        return _registroMedico.value?.consultas ?: emptyList()
    }
}