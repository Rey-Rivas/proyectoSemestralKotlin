package com.example.veterinaria.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.veterinaria.classes.Alergia
import com.example.veterinaria.classes.Mascota

class AlergiaViewModel : ViewModel() {
    private val _alergia = MutableLiveData<Alergia?>()
    val alergia: MutableLiveData<Alergia?> = _alergia

    fun registrarAlergia(id: Int, tipo: String, sustancia: String, severidad: Int, reaccion: String, mascotas: List<Mascota>) {
        _alergia.value = Alergia(id, tipo, sustancia, severidad, reaccion, mascotas)
    }

    fun actualizarSeveridad(nuevaSeveridad: Int) {
        val alergia = _alergia.value
        if (alergia != null) {
            val updatedAlergia = alergia.copy(severidad = nuevaSeveridad)
            _alergia.value = updatedAlergia
        }
    }

    fun eliminarAlergia(delete: Boolean) {
        if (delete) {
            _alergia.value = null
        }
    }
}