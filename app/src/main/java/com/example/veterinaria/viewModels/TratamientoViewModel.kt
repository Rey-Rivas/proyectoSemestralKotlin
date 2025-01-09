package com.example.veterinaria.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.veterinaria.classes.Tratamiento
import java.util.Calendar
import java.util.Date

class TratamientoViewModel : ViewModel() {
    private val _tratamiento = MutableLiveData<Tratamiento?>()
    private val _tratamientos = MutableLiveData<List<Tratamiento>>()
    val tratamiento: MutableLiveData<Tratamiento?> = _tratamiento
    val tratamientos: MutableLiveData<List<Tratamiento>> = _tratamientos

    init {
        loadTratamientos()
    }

    companion object {
        private var lastId: Int = 0
    }

    private fun loadTratamientos() {
        val calendar = Calendar.getInstance()
        val tratamientosList = mutableListOf<Tratamiento>()

        for (i in 1..5) {
            val fechaInicio = calendar.time
            calendar.add(Calendar.DAY_OF_YEAR, 30)
            val proximaDosis = calendar.time
            tratamientosList.add(Tratamiento(i, fechaInicio, proximaDosis))
        }

        _tratamientos.value = tratamientosList
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