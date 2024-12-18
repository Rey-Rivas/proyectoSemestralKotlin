package com.example.veterinaria.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.veterinaria.classes.Alergia
import com.example.veterinaria.classes.Mascota
import com.example.veterinaria.classes.Raza
import com.example.veterinaria.classes.Especie
import com.example.veterinaria.classes.RegistroMedico
import java.time.LocalDate
import java.time.Period
import java.time.ZoneId
import java.util.Date

class MascotaViewModel : ViewModel() {
    private val _mascota = MutableLiveData<Mascota>()
    val mascota: LiveData<Mascota> = _mascota

    private val _alergias = MutableLiveData<List<Alergia>>()
    val alergia: LiveData<List<Alergia>> = _alergias

    fun setMascota(id: Int, nombre: String, fechaNacimiento: Date, foto: String, peso: Double, especie: Especie, raza: Raza, registroMedico: RegistroMedico) {
        _mascota.value = Mascota(id, nombre, fechaNacimiento, foto, peso, especie, raza, registroMedico)
    }

    fun getEdad(): Int {
        val fechaNacimiento = _mascota.value?.fechaNacimiento
        if (fechaNacimiento != null) {
            val hoy = LocalDate.now()
            return Period.between(fechaNacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), hoy).years
        }
        return 0
    }

    fun getAlergias(): List<Alergia> {
        val mascotaId = _mascota.value?.id
        return if (mascotaId != null) {
            _alergias.value?.filter { alergia ->
                alergia.mascotas.any { it.id == mascotaId }
            } ?: listOf()
        } else {
            listOf()
        }
    }
}