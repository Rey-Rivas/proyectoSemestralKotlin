package com.example.veterinaria.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.veterinaria.classes.Mascota

@Dao
interface MascotaDao {
    @Insert
    suspend fun insert(mascota: Mascota)

    @Update
    suspend fun update(mascota: Mascota)

    @Query("SELECT * FROM mascota WHERE id = :id")
    suspend fun getMascotaById(id: Int): Mascota?

    @Query("SELECT * FROM mascota")
    suspend fun getAllMascotas(): List<Mascota>
}