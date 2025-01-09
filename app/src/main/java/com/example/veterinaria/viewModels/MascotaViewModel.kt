package com.example.veterinaria.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.veterinaria.MainActivity
import com.example.veterinaria.classes.Alergia
import com.example.veterinaria.classes.Mascota
import com.example.veterinaria.classes.Raza
import kotlinx.coroutines.launch
import java.util.Date

class MascotaViewModel(application: Application) : AndroidViewModel(application) {
    private val _mascota = MutableLiveData<Mascota>()
    val mascota: LiveData<Mascota> = _mascota

    private val _mascotaList = MutableLiveData<List<Mascota>>()
    val mascotaList: LiveData<List<Mascota>> = _mascotaList

    init {
        viewModelScope.launch {
            _mascotaList.value = MainActivity.database.mascotaDao().getAllMascotas()
        }
    }

    fun setMascota(id: Int, nombre: String, fechaNacimiento: Date, foto: String, peso: Double, raza: Raza) {
        _mascota.value = Mascota(id, nombre, fechaNacimiento, foto, peso, raza)
    }

    fun setMascotaList(mascotas: List<Mascota>) {
        _mascotaList.value = mascotas
    }

    fun calcularEdad(): Int {
        val today = Date()
        val diff = today.time - _mascota.value?.fechaNacimiento?.time!!
        val age = diff / (1000L * 60 * 60 * 24 * 365)
        return age.toInt()
    }

    fun alergias(): List<Alergia> {
        val mascotaActual = _mascota.value
        return if (mascotaActual != null) {
            val todasLasAlergias = listOf<Alergia>()
            todasLasAlergias.filter { it.mascotas.contains(mascotaActual) }
        } else {
            emptyList()
        }
    }

    fun updateMascota(mascota: Mascota?) {
        mascota?.let {
            viewModelScope.launch {
                MainActivity.database.mascotaDao().update(it)
                _mascota.value = it
                _mascotaList.value = MainActivity.database.mascotaDao().getAllMascotas()
            }
        }
    }

    fun addMascota(mascota: Mascota) {
        viewModelScope.launch {
            MainActivity.database.mascotaDao().insert(mascota)
            _mascotaList.value = MainActivity.database.mascotaDao().getAllMascotas()
        }
    }
}