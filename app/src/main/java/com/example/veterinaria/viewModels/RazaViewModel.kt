package com.example.veterinaria.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.veterinaria.classes.Especie
import com.example.veterinaria.classes.Mascota
import com.example.veterinaria.classes.Raza

class RazaViewModel : ViewModel() {
    private val _raza = MutableLiveData<Raza>()
    val raza: LiveData<Raza> = _raza

    private val _mascota = MutableLiveData<List<Mascota>>()
    val mascota: LiveData<List<Mascota>> = _mascota

    fun setRaza(id: Int, nombre: String, especie: Especie) {
        _raza.value = Raza(id, nombre, especie)
    }

    fun getEspecie(): Especie {
        if (_raza.value != null) {
            return _raza.value!!.especie
        } else {
            return Especie(0, "", listOf()) //revisar
        }
    }

    fun getMascotasPorRaza(): List<Mascota> {
        return if (_raza.value != null && _mascota.value != null) {
            _mascota.value!!.filter { mascotas ->
                mascotas.raza.idRaza == _raza.value!!.idRaza
            }
        } else {
            listOf()
        }
    }
}