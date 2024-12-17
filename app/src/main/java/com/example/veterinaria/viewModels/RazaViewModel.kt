package com.example.veterinaria.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.veterinaria.classes.Especie
import com.example.veterinaria.classes.Raza

class RazaViewModel : ViewModel() {
    private val _raza = MutableLiveData<Raza>()
    val raza: LiveData<Raza> = _raza

    fun setRaza(id: Int, nombre: String, especies: List<Especie>) {
        _raza.value = Raza(id, nombre, especies)
    }

    fun obtenerEspecie(): List<Especie>? {
        return _raza.value?.especie
    }

    fun listarMascotasPorRaza(): List<String> {
        return listOf()
    }
}