package com.example.veterinaria.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.veterinaria.data.models.Alergia
import com.example.veterinaria.data.models.Mascota

class AlergiaViewModel : ViewModel() {
    private val _alergia = MutableLiveData<Alergia>()
    val alergia: LiveData<Alergia> = _alergia

    private val _mascotas = MutableLiveData<List<Mascota>>()
    val mascotas: LiveData<List<Mascota>> = _mascotas
    

    fun registrarAlergia(sustancia: String, severidad: Int) {
        //implementar
    }

    fun updateSeveridad(nuevaSeveridad: Int) {
      //implementar
    }

    fun deleteAlergia(delete: Boolean) {
        //implementar
    }
}