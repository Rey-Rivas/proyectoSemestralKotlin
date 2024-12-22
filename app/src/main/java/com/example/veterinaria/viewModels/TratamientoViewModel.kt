package com.example.veterinaria.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.veterinaria.classes.Tratamiento
import java.util.Calendar
import java.util.Date

class TratamientoViewModel : ViewModel() {
    private val _tratamiento = MutableLiveData<Tratamiento?>()
    val tratamiento: MutableLiveData<Tratamiento?> = _tratamiento

    companion object {
        private var lastId: Int = 0
    }

    fun iniciarTratamiento(fechaInicio: Date, duracion: Int) {
        val calendar = Calendar.getInstance()
        calendar.time = fechaInicio
        calendar.add(Calendar.DAY_OF_YEAR, duracion)
        val proximaDosis = calendar.time

        val newId = ++lastId
        _tratamiento.value = Tratamiento(newId, fechaInicio, proximaDosis)
    }

    fun finalizarTratamiento() {
        _tratamiento.value = null
    }
}