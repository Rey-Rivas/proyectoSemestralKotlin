package com.example.veterinaria.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.veterinaria.classes.Alergia
import com.example.veterinaria.classes.Mascota
import com.example.veterinaria.classes.Raza
import com.example.veterinaria.classes.RegistroMedico
import java.util.Date

class MascotaViewModel : ViewModel() {
    private val _mascota = MutableLiveData<Mascota>()
    val mascota: LiveData<Mascota> = _mascota

    fun setMascota(id: Int, nombre: String, fechaNacimiento: Date, foto: String, peso: Double, raza: Raza, registroMedico: RegistroMedico) {
        _mascota.value = Mascota(id, nombre, fechaNacimiento, foto, peso, raza, registroMedico)
    }

    fun calcularEdad(): Int {
        val today = Date()
        val diff = today.time - _mascota.value?.fechaNacimiento?.time!!
        val age = diff / (1000L * 60 * 60 * 24 * 365)
        return age.toInt()
    }

    fun alergias(): List<Alergia> {
        // Lógica para obtener alergias de la mascota
        return listOf() // Ejemplo de retorno
    }
}