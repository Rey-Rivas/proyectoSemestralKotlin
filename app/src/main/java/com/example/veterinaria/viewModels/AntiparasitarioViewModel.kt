package com.example.veterinaria.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.veterinaria.data.models.Antiparasitario
import java.util.Date

class AntiparasitarioViewModel : ViewModel() {
    private val _antiparasitario = MutableLiveData<Antiparasitario>()
    val antiparasitario: LiveData<Antiparasitario> = _antiparasitario

    fun setAntiparasitario(tipoAntiparasitario: String, idTratamiento: Int, fecha: Date, proximaDosis: Date) {
        _antiparasitario.value = Antiparasitario(tipoAntiparasitario, idTratamiento, fecha, proximaDosis)
    }

    fun aplicarAntiparasitario(fecha: Date) {
        _antiparasitario.value?.fecha = fecha
    }

    fun registrarProximaAplicacion(proximaDosis: Date) {
        _antiparasitario.value?.proximaDosis = proximaDosis

    }
}



