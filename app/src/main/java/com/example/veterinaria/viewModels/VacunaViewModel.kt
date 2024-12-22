package com.example.veterinaria.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.veterinaria.classes.Vacuna
import java.util.Date

class VacunaViewModel : ViewModel() {
    private val _vacuna = MutableLiveData<Vacuna?>()
    val vacuna: MutableLiveData<Vacuna?> = _vacuna

    fun aplicarVacuna(fecha: Date) {
        _vacuna.value?.let {
            val updatedVacuna = it.copyWith(fecha = fecha)
            _vacuna.value = updatedVacuna
        }
    }

    fun registrarProximaDosis(fecha: Date) {
        _vacuna.value?.let {
            val updatedVacuna = it.copyWith(proximaDosis = fecha)
            _vacuna.value = updatedVacuna
        }
    }
}