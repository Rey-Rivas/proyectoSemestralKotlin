package com.example.veterinaria.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.veterinaria.classes.Alergia
import com.example.veterinaria.classes.Mascota
import com.example.veterinaria.classes.Raza
import com.example.veterinaria.classes.Especie
import java.util.Date

class MascotaViewModel : ViewModel() {
    private val _mascota = MutableLiveData<Mascota>()
    val mascota: LiveData<Mascota> = _mascota

    private val _mascotaList = MutableLiveData<List<Mascota>>()
    val mascotaList: LiveData<List<Mascota>> = _mascotaList

    init {
        val razaBase = Raza(1, "Labrador", listOf(Especie(1, "Canino")))
        val mascota1 = Mascota(1, "Max el destrosa mundos", Date(2001,11,12), "https://static.wikia.nocookie.net/gatopedia/images/2/2e/El_gatoo.png/revision/latest?cb=20230103150310&path-prefix=es", 25.0, razaBase)
        val mascota2 = Mascota(2, "Cheems", Date(2000,4,11), "https://static.wikia.nocookie.net/cheems/images/e/e1/Flat%2C750x%2C075%2Cf-pad%2C750x1000%2Cf8f8f8.u2.jpg/revision/latest/scale-to-width-down/750?cb=20200928233506&path-prefix=es", 30.0, razaBase)
        val mascota3 = Mascota(3, "Bella, Maga del pan con queso", Date(2019,3,2), "https://static.wikia.nocookie.net/gatopedia/images/a/af/Pop1.png/revision/latest?cb=20230105144717&path-prefix=es", 20.0, razaBase)

        val mascotaList = listOf(mascota1, mascota2, mascota3)
        _mascotaList.value = mascotaList
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
}