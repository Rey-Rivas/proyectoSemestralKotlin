package com.example.veterinaria.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.veterinaria.classes.Especie
import com.example.veterinaria.classes.Raza
import com.example.veterinaria.classes.Mascota

class RazaViewModel : ViewModel() {
    private val _raza = MutableLiveData<Raza>()
    val raza: LiveData<Raza> = _raza

    fun setRaza(id: Int, nombre: String, especies: List<Especie>) {
        _raza.value = Raza(id, nombre, especies)
    }

    fun obtenerEspecie(): List<Especie>? {
        return _raza.value?.especie
    }

    fun listarMascotasPorRaza(mascotas: List<Mascota>): List<String> {
        val razaActual = _raza.value
        return if (razaActual != null) {
            mascotas.filter { it.raza.idRaza == razaActual.idRaza }
                    .map { it.nombre }
        } else {
            emptyList()
        }
    }
}