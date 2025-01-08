package com.example.veterinaria.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.veterinaria.classes.Especie
import com.example.veterinaria.classes.Mascota
import com.example.veterinaria.classes.Raza

class EspecieViewModel : ViewModel() {
    private val _especie = MutableLiveData<Especie>()
    val especie: LiveData<Especie> = _especie

    private val _razas = MutableLiveData<List<Raza>>()
    val razas: LiveData<List<Raza>> = _razas

    fun setEspecie(id: Int, nombre: String, razas: List<Raza>) {
        _especie.value = Especie(id, nombre)
        _razas.value = razas
    }

    fun listarRaza(): Raza? {
        val especieActual = _especie.value
        return if (especieActual != null) {
            _razas.value?.find { raza -> raza.especie.contains(especieActual) }
        } else {
            null
        }
    }

    fun obtenerMascotasPorEspecie(mascotas: List<Mascota>): List<String> {
        val especieActual = _especie.value
        return if (especieActual != null) {
            mascotas.filter { it.raza.especie.contains(especieActual) }
                   .map { it.nombre }
        } else {
            emptyList()
        }
    }
}