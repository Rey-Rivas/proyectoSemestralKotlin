package com.example.veterinaria.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.veterinaria.classes.Especie
import com.example.veterinaria.classes.Mascota
import com.example.veterinaria.classes.Raza

class EspecieViewModel : ViewModel() {
    private val _especie = MutableLiveData<Especie>()
    val raza: LiveData<Especie> = _especie

    fun setEspecie(id: Int, nombre: String, razas: List<Raza>) {
        _especie.value = Especie(id, nombre, razas)
    }

    fun obtenerRaza(): List<Raza>? {
        return _especie.value?.razas
    }

    fun listarMascotasPorEspecie(): List<String> {
        return listOf()
    }
}