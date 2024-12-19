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

    fun setEspecie(id: Int, nombre: String) {
        _especie.value = Especie(id, nombre)
    }

    fun listarRazas(): List<Raza>? {
        //return _especie.value?.raza
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