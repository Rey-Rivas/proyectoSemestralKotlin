package com.example.veterinaria.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.veterinaria.data.models.Especie
import com.example.veterinaria.data.models.Mascota
import com.example.veterinaria.data.models.Raza

class EspecieViewModel : ViewModel() {
    private val _especie = MutableLiveData<Especie>()
    val especie: LiveData<Especie> = _especie

    private val _mascotas = MutableLiveData<List<Mascota>>()
    val mascota: LiveData<List<Mascota>> = _mascotas

    fun setEspecie(id: Int, nombre: String, razas: List<Raza>) {
        _especie.value = Especie(id, nombre, razas)
    }

    fun getRazas(): List<Raza>? {
        return _especie.value?.razas
    }

    fun listarMascotasPorEspecie(): List<Mascota> {
        return if (_especie.value != null && _mascotas.value != null) {
            _mascotas.value!!.filter { mascota ->
                mascota.especie.idEspecie == _especie.value!!.idEspecie
            }
        } else {
            listOf()
        }
    }
}