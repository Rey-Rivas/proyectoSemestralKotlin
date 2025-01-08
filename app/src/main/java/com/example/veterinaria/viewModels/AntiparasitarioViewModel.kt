package com.example.veterinaria.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.veterinaria.classes.Antiparasitario
import java.util.Date

class AntiparasitarioViewModel : ViewModel() {
    private val _antiparasitario = MutableLiveData<Antiparasitario?>()
    val antiparasitario: MutableLiveData<Antiparasitario?> = _antiparasitario

    fun aplicarAntiparasitario(fecha: Date) {
        _antiparasitario.value?.let {
            val updatedAntiparasitario = it.copyWith(fecha = fecha)
            _antiparasitario.value = updatedAntiparasitario
        }
    }

    fun registrarProximaAplicacion(fecha: Date) {
        _antiparasitario.value?.let {
            val updatedAntiparasitario = it.copyWith(proximaDosis = fecha)
            _antiparasitario.value = updatedAntiparasitario
        }
    }
}